package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
//import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous

public class TestAll1 extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Robot robot = new Robot();
        robot.init(this.hardwareMap);
        waitForStart();

        while(opModeIsActive()) {
            robot.FrontRightDrive.setPower(0.1);
            robot.FrontLeftDrive.setPower(0.1);
            robot.RearRightDrive.setPower(0.1);
            robot.RearLeftDrive.setPower(0.1);
            telemetry.addData("Current Position FrontRightDrive:", robot.FrontRightDrive.getCurrentPosition());
            telemetry.addData("Current Position FrontLeftDrive:", robot.FrontLeftDrive.getCurrentPosition());
            telemetry.addData("Current Position RearRightDrive:", robot.RearRightDrive.getCurrentPosition());
            telemetry.addData("Current Position RearLeftDrive:", robot.RearLeftDrive.getCurrentPosition());
            telemetry.update();
        }
    }
}
