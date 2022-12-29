package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp
public class TeleOP extends LinearOpMode {
    Robot robot = new Robot();   // Use Robot's feature
    //double dumperPos = 0;

        //robot.init(this.hardwareMap);
/*
        waitForStart();
        double distanceInches = 12;
        int leftTarget = (int) (distanceInches * COUNTS_PER_INCH);
        int rightTarget = (int)(distanceInches * COUNTS_PER_INCH);
        robot.drive(1, leftTarget);
 */
        //public DcMotor IntakeMotor = null;

    @Override
    public void runOpMode() {
       robot.init(this.hardwareMap);

        telemetry.addData("Mode", "waiting");
        telemetry.update();
          //  IntakeMotor = hardwareMap.get(DcMotor.class, "IntakeMotor");
        waitForStart();


        while (opModeIsActive()) {
           // I`ntakeMotor.setPower(gamepad1.left_stick_y);
        }

            double drive = -gamepad1.right_stick_y;
            double strafe = -gamepad1.right_stick_x;
            double turn = -gamepad1.left_stick_x * 0.8;



           if(Math.abs(strafe)<0.2){
                strafe = 0;
                double FLPower = Range.clip(drive - strafe + turn, -1.0, 1.0);
                double FRPower = Range.clip(drive + strafe - turn, -1.0, 1.0);
                double BLPower = Range.clip(drive + strafe + turn, -1.0, 1.0);
                double BRPower = Range.clip(drive - strafe - turn, -1.0, 1.0);

                robot.FrontLeftDrive.setPower(FLPower);
                robot.FrontRightDrive.setPower(FRPower);
                robot.RearLeftDrive.setPower(BLPower);
                robot.RearRightDrive.setPower(BRPower);
           }
    }
}

