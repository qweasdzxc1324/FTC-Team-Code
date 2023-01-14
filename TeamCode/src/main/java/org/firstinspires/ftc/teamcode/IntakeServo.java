package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class IntakeServo extends LinearOpMode {
    //Robot robot = new Robot();

    public Servo IntakeServo = null;
    public double threshold = 0.01;
    @Override
    public void runOpMode() throws InterruptedException {
        IntakeServo = hardwareMap.get(Servo.class,"IntakeServo");
        //robot.init(this.hardwareMap);
        telemetry.addData("Mode", "waiting");
        telemetry.update();

        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.left_stick_y < 0.01 && gamepad1.left_stick_y > -0.01) {

            } else {
                IntakeServo.setPosition(gamepad1.left_stick_y);
            }
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
