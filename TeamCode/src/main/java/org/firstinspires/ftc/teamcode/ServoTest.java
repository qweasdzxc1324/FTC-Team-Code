package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class ServoTest extends LinearOpMode {
    Robot robot = new Robot();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(this.hardwareMap);
        telemetry.addData("Mode", "waiting");
        telemetry.update();

        waitForStart();
        while(opModeIsActive()) {
            if (gamepad1.a) {
                robot.TestServo.setPower(1.0);
                robot.TestServo2.setPower(-1.0);
            } else if (gamepad1.b) {
                robot.TestServo.setPower(-1.0);
                robot.TestServo2.setPower(1.0);
            } else {
                robot.TestServo.setPower(0);
                robot.TestServo2.setPower(0);
            }
            //robot.FrontLeftDrive.setPower(gamepad1.left_stick_y);
        }
    }
}
