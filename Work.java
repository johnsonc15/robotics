package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Work", group = "Working")
public class Work extends LinearOpMode {

    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor frontLeft;
    private DcMotor frontRight;

    @Override
    public void runOpMode() throws InterruptedException {

        // Define and Initialize Motors
        backLeft = hardwareMap.dcMotor.get("left_rear");
        backRight = hardwareMap.dcMotor.get("right_rear");
        frontLeft = hardwareMap.dcMotor.get("left_front");
        frontRight = hardwareMap.dcMotor.get("right_front");

        // Reversing left motors
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.REVERSE);

        // Set all motors to run without encoders
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();

        while (opModeIsActive()) {

            backLeft.setPower(-gamepad1.left_stick_y);
            backRight.setPower(-gamepad1.right_stick_y);

            idle();
        }
    }
}
