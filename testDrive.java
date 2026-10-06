package org.firstinspires.ftc.teamcode; //the package for the import

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode; // the imports
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; //the imports
import com.qualcomm.robotcore.hardware.DcMotor; //the imports
import com.qualcomm.robotcore.hardware.DcMotorSimple; //the imports

@TeleOp(name = "rotate", group = "Linear Opmode") //@TeleOp(name="MyTeleOpMode", group="Linear Opmode")
public class testDrive extends LinearOpMode {  // the class

    @Override
    public void runOpMode() throws InterruptedException {
        // Declare the four drivetrain motors
        DcMotor frontLeftMotor = hardwareMap.dcMotor.get("m1");  // Declare the four drivetrain motors
        DcMotor backLeftMotor = hardwareMap.dcMotor.get("m2");  // Declare the four drivetrain motors
        DcMotor frontRightMotor = hardwareMap.dcMotor.get("m3");  // Declare the four drivetrain motors
        DcMotor backRightMotor = hardwareMap.dcMotor.get("m4");  // Declare the four drivetrain motors

        // vvvv-x2 Reverse the left side motors because they face the opposite direction
        // Note: Check your specific physical gearing; sometimes the right side needs reversing instead.
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");  // for the drivers station
        telemetry.update(); // the driver station will update so it can take more commands

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // Y stick is reversed by default on controllers (up is negative), so we negate it
            double y = -gamepad2.left_stick_y; // Forward and Backward
            double x = gamepad2.left_stick_x;  // Strafe Left and Right
          //  double rx = gamepad2.right_stick_x; // Turn Left and Right
            
            double drive  = -gamepad2.left_stick_y; // Forward/Backward
            double strafe = gamepad2.left_stick_x;  // Left/Right sideways
            // old code >>> double rotate = gamepad2.right_stick_x; // Rotation / turning
            
            double frontLeftPower  = drive + strafe; // + rotate;
            double backLeftPower   = drive - strafe; //+ rotate;
            double frontRightPower = drive - strafe; // - rotate;
            double backRightPower  = drive + strafe; // - rotate;

            // Mecanum wheel kinematics math matrix
       //   double frontLeftPower = y + x + rx;
      //     double backLeftPower = y - x + rx;
        //   double frontRightPower = y - x - rx;
       //    double backRightPower = y + x - rx;

            // Normalize the power values if any exceed 1.0 to maintain proportional speed
            double max = Math.max(Math.abs(frontLeftPower), Math.abs(backLeftPower));
            max = Math.max(max, Math.abs(frontRightPower));
   // old code >>>>> max =http;//192.168.43.1:8080/java/editor.html?/src/org/firstinspires/ftc/teamcode/testDrive.java Math.max(max, Math.abs(backRightPower));

            if (max > 1.0) {
                frontLeftPower /= max;  //makes the wheels have a limit for hp
                backLeftPower /= max; //makes the wheels have a limit for hp
                frontRightPower /= max; //makes the wheels have a limit for hp
                backRightPower /= max; //makes the wheels have a limit for hp
            }

            // Send calculated power vectors to the wheels
            frontLeftMotor.setPower(frontLeftPower); //setting power for this wheel
            backLeftMotor.setPower(backLeftPower); //setting power for this wheel
            frontRightMotor.setPower(frontRightPower); //setting power for this wheel
            backRightMotor.setPower(backRightPower); //setting power for this wheel

            // Optional telemetry output for debugging wheel speeds
            telemetry.addData("Front Left Power", frontLeftPower); // for driverstation
            telemetry.addData("Back Left Power", backLeftPower); // for driverstation
            telemetry.addData("Front Right Power", frontRightPower); // for driverstation
            telemetry.addData("Back Right Power", backRightPower); // for driverstation
            telemetry.update(); // to update the driverstaion
        }
    }
}
