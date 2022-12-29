package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
//import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous
public class AutoTest extends LinearOpMode {

    //Robot robot = new Robot();
    //static final double COUNTS_PER_MOTOR_REV = 28 ;
    //static final double DRIVE_GEAR_REDUCTION = 13.7;
    //static final double WHEEL_DIAMETER_INCHES = 4;
    //static final double COUNTS_PER_INCH = 45.4545455;
    //public DcMotor IntakeMotor = null;
    ElapsedTime runtime = new ElapsedTime();
    @Override
    public void runOpMode() {
        //robot.init(this.hardwareMap);
/*
        waitForStart();
        double distanceInches = 12;
        int leftTarget = (int) (distanceInches * COUNTS_PER_INCH);
        int rightTarget =i(int)(distanceInches * COUNTS_PER_INCH);
        robot.drive(1, leftTarget);
 */
        // IntakeMotor = hardwareMap.get(DcMotor.class, "IntakeMotor");
        waitForStart();
        runtime.reset();

        while (opModeIsActive() && runtime.seconds() < 1.0) {
           // IntakeMotor.setPower(1);
        } while (opModeIsActive() && runtime.seconds() < 2.0) {
            //IntakeMotor.setPower(-1);

        }

    }
}
