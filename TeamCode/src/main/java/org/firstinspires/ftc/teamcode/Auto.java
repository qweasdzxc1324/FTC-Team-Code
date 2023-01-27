package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


@Autonomous
public class Auto extends LinearOpMode {
    static final double COUNTS_PER_INCH = 45.4545455;
    public void runOpMode() throws InterruptedException {
        Robot robot = new Robot();
        robot.init(this.hardwareMap);
        waitForStart();
        robot.strafe(.6, (int)(-30*COUNTS_PER_INCH));
    }
}
