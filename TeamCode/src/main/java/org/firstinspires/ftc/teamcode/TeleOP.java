package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp
public class TeleOP extends LinearOpMode {
    //double dumperPos = 0;
/*
        waitForStart();
        double distanceInches = 12;
        int leftTarget = (int) (distanceInches * COUNTS_PER_INCH);
        int rightTarget = (int)(distanceInches * COUNTS_PER_INCH);
        robot.drive(1, leftTarget);
 */
        //public DcMotor IntakeMotor = null;
    public double threshold = 0.01;
    public double pivotPosition = 0;
    public double ClawServoLPosition = 0;
    public double ClawServoRPosition = 0;
    @Override
    public void runOpMode() {
        Robot robot = new Robot();
        robot.init(this.hardwareMap);

        telemetry.addData("Mode", "waiting");
        telemetry.update();
        robot.IntakeMotor = hardwareMap.get(DcMotor.class, "IntakeMotor");
        waitForStart();


        while (opModeIsActive()) {
            double slides = gamepad2.left_stick_y * 0.75;
            if (robot.IntakeMotor.getCurrentPosition() <= 0) {
                if (gamepad2.left_stick_y > 0) {
                    robot.IntakeMotor.setPower(slides);
                } else {
                    robot.IntakeMotor.setPower(0);
                }
            } else if (robot.IntakeMotor.getCurrentPosition() >= 3200) {
                if (gamepad2.left_stick_y < 0) {
                    robot.IntakeMotor.setPower(slides);
                } else {
                    robot.IntakeMotor.setPower(0);
                }
            } else {
                robot.IntakeMotor.setPower(slides);
            }
            telemetry.addData("Current Position:", robot.IntakeMotor.getCurrentPosition());
            telemetry.update();
            double drive = -gamepad1.right_stick_y;
            double strafe = -gamepad1.right_stick_x;
            double turn = gamepad1.left_stick_x * 0.8;


            // if(Math.abs(strafe)<0.2){
                //strafe = 0;
            double FLPower = Range.clip(drive - strafe + turn, -1.0, 1.0);
            double FRPower = Range.clip(drive + strafe - turn, -1.0, 1.0);
            double BLPower = Range.clip(drive + strafe + turn, -1.0, 1.0);
            double BRPower = Range.clip(drive - strafe - turn, -1.0, 1.0);

            robot.FrontLeftDrive.setPower(FLPower);
            robot.FrontRightDrive.setPower(FRPower);
            robot.RearLeftDrive.setPower(BLPower);
            robot.RearRightDrive.setPower(BRPower);
            robot.IntakeServo = hardwareMap.get(Servo.class,"IntakeServo");
        //robot.init(this.hardwareMap);
            if (gamepad2.a) {
                pivotPosition += 0.002;
                robot.IntakeServo.setPosition(pivotPosition);
            } else if (gamepad2.b) {
                pivotPosition -= 0.002;
                robot.IntakeServo.setPosition(pivotPosition);
            }
            if (pivotPosition >= 1) {
                pivotPosition = 1;
            }
            else if (pivotPosition <= 0) {
                pivotPosition = 0;
            }
            if (gamepad2.left_bumper) {
                robot.ClawServoR.setPosition(.9);
                robot.ClawServoL.setPosition(.6);
            } else if (gamepad2.right_bumper) {
                robot.ClawServoL.setPosition(.9);
                robot.ClawServoR.setPosition(.6);
            }
            /*
            if (ClawServoLPosition >= 1) {
                ClawServoLPosition = 1;
            } else if (ClawServoLPosition <= 0) {
                ClawServoRPosition = 0;
            }
            if (gamepad2.dpad_right) {
                ClawServoRPosition += 0.001;
                robot.ClawServoR.setPosition(ClawServoRPosition);
            } else if (gamepad2.dpad_left) {
                ClawServoRPosition -= 0.001;
                robot.ClawServoR.setPosition(ClawServoRPosition);
            }
            if (ClawServoRPosition >= 1) {
                ClawServoRPosition = 1;
            } else if (ClawServoRPosition <= 0) {
                ClawServoRPosition = 0;
            }
             */
            /*
            if (gamepad1.left_stick_y > 0) {
                IntakeServoPosition = Double.valueOf(gamepad1.left_stick_y);
            }
            IntakeServo.setPosition(gamepad1.left_stick_y);
            IntakeServo.setPosition(IntakeServoPosition);
            //Change to gamepad2 after testing
            */
            }
        }
    }