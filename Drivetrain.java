package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="Diagonal", group="Linear Opmode")
public class Diag extends LinearOpMode {

    private DcMotor leftFront = null;
    private DcMotor leftBack = null;
    private DcMotor rightFront = null;
    private DcMotor rightBack = null;

    @Override
    public void runOpMode() {
        
        leftFront  = hardwareMap.get(DcMotor.class, "leftFront"); // Initialize it on the hardware variables
        leftBack   = hardwareMap.get(DcMotor.class, "leftBack"); // Initialize it on the hardware variables
        rightFront = hardwareMap.get(DcMotor.class, "rightFront"); // Initialize it on the hardware variables
        rightBack  = hardwareMap.get(DcMotor.class, "rightBack"); // Initialize it on the hardware variables

        // Reverse the right side motors to drive forward
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);
        rightBack.setDirection(DcMotor.Direction.FORWARD);

        // Stop and reset any encoder ticks if necessary
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("Status", "Initialized"); // for drivers station
        telemetry.update(); // update drivers station

        waitForStart();

        while (opModeIsActive()) {
            // Read joystick values (Y axis is negated because up is negative on gamepads)
            double forward = -gamepad1.left_stick_y;
            double strafe  = gamepad1.left_stick_x;
            double turn    = gamepad1.right_stick_x;

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all powers are scaled down proportionally if any value exceeds 1.0
            double denominator = Math.max(Math.abs(forward) + Math.abs(strafe) + Math.abs(turn), 1.0);
            
            // Standard Mecanum kinematics equations for robot-centric movement
            double leftFrontPower  = (forward + strafe + turn) / denominator;
            double leftBackPower   = (forward - strafe + turn) / denominator;
            double rightFrontPower = (forward - strafe - turn) / denominator;
            double rightBackPower  = (forward + strafe - turn) / denominator;

            leftFront.setPower(leftFrontPower); // Send calculated power to motors
            leftBack.setPower(leftBackPower); // Send calculated power to motors
            rightFront.setPower(rightFrontPower); // Send calculated power to motors
            rightBack.setPower(rightBackPower); // Send calculated power to motors

            // Show feedback on Driver Hub screen
            telemetry.addData("LF Power", leftFrontPower); //for drivers station
            telemetry.addData("LB Power", leftBackPower); //for drivers station
            telemetry.addData("RF Power", rightFrontPower); //for drivers station
            telemetry.addData("RB Power", rightBackPower); //for drivers station
            telemetry.update(); // update drivers station
        }
    }
 }
