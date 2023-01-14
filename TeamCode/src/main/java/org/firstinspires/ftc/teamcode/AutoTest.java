package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
//import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous
public class AutoTest extends LinearOpMode {

    //static final double COUNTS_PER_MOTOR_REV = 28 ;
    //static final double DRIVE_GEAR_REDUCTION = 13.7;
    //static final double WHEEL_DIAMETER_INCHES = 4;
    static final double COUNTS_PER_INCH = 45.4545455;
    //public DcMotor IntakeMotor = null;
    ElapsedTime runtime = new ElapsedTime();


    public void runOpMode() throws InterruptedException {

        Robot robot = new Robot();
        robot.init(this.hardwareMap);
        waitForStart();

        robot.FrontLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.FrontRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.RearRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.RearLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.FrontLeftDrive.setTargetPosition((int)(48 * COUNTS_PER_INCH));
        robot.FrontRightDrive.setTargetPosition((int)(48 * COUNTS_PER_INCH));
        robot.RearLeftDrive.setTargetPosition((int)(48 * COUNTS_PER_INCH));
        robot.RearRightDrive.setTargetPosition((int)(48 * COUNTS_PER_INCH));

        robot.FrontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.FrontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.RearLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.RearRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.FrontLeftDrive.setPower(0.50);
        robot.FrontRightDrive.setPower(0.50);
        robot.RearLeftDrive.setPower(0.50);
        robot.RearRightDrive.setPower(0.50);


        while (opModeIsActive() && robot.FrontLeftDrive.isBusy())
        {
            telemetry.addData("encoder-fwd-left", robot.FrontLeftDrive.getCurrentPosition() + "  busy=" + robot.FrontLeftDrive.isBusy());
            telemetry.addData("encoder-fwd-right", robot.FrontRightDrive.getCurrentPosition() + "  busy=" + robot.FrontRightDrive.isBusy());
            telemetry.update();
            idle();
        }


        robot.FrontLeftDrive.setPower(0.0);
        robot.FrontRightDrive.setPower(0.0);
        robot.RearLeftDrive.setPower(0.0);
        robot.RearRightDrive.setPower(0.0);

        resetRuntime();
        while (opModeIsActive() && getRuntime() < 5)
        {
            telemetry.addData("encoder-fwd-left-end", robot.FrontLeftDrive.getCurrentPosition());
            telemetry.addData("encoder-fwd-right-end", robot.FrontRightDrive.getCurrentPosition());
            telemetry.update();
            idle();
        }
    }


}
