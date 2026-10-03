package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Gamepad Motor Control", group = "Linear OpMode")
public class LOL extends LinearOpMode {

    // Declare the motor variable
    private DcMotor testMotor = null;

    @Override
    public void runOpMode() {
        // Initialize the motor using the name configured on the driver station
        testMotor = hardwareMap.get(DcMotor.class, "int1");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the driver to press PLAY
        waitForStart();

        // Run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            
            // Check if the 'A' button on Gamepad 1 is pressed
            if (gamepad2.a) {
                // Spin the motor at full power
                testMotor.setPower(1.0);
            } else {
                // Stop the motor when the button is released
                testMotor.setPower(0.0);
            }

            // Send feedback back to the driver station
            telemetry.addData("Motor Power", testMotor.getPower());
            telemetry.update();
        }
        
          while (opModeIsActive()) {
            
            // Check if the 'A' button on Gamepad 1 is pressed
            if (gamepad2.b) {
                // Spin the motor at full power
                testMotor.setPower(-1.0);
            } else {
                // Stop the motor when the button is released
                testMotor.setPower(0.0);
            }

            // Send feedback back to the driver station
            telemetry.addData("Motor Power", testMotor.getPower());
            telemetry.update();
      }
    }
}
