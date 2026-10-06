package org.firstinspires.ftc.teamcode;  // for the imports

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode; // an imports
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; // an imports
import com.qualcomm.robotcore.hardware.Servo; // an imports

@TeleOp(name = "Servo", group = "TeleOp")
public class Flower extends LinearOpMode {   // the class

    // Declare the servo object
    private Servo myServo;

    // Define servo positions mapped from degrees to the 0.0 - 1.0 range
    // Assuming a standard 180-degree servo: 0 degrees = 0.0, 90 degrees = 0.5
    private static final double POSITION_0_DEG = 0.0;
    private static final double POSITION_90_DEG = 0.5;

    @Override
    public void runOpMode() {
        // Initialize the servo from the hardware map
        // Ensure "testServo" matches the name configured on your driver station
        myServo = hardwareMap.get(Servo.class, "testServo");

        // Set an initial position before the match starts
        myServo.setPosition(POSITION_90_DEG);

        telemetry.addData("Status", "Initialized. Waiting for start..."); // for the Driver Station
        telemetry.update(); // update driver station

        waitForStart();

        // Run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            
            // Check if the 'X' button on Gamepad 1 is pressed
            if (gamepad1.x) {
                myServo.setPosition(POSITION_0_DEG);
            } else {
                myServo.setPosition(POSITION_90_DEG);
            }

            // Send feedback to the Driver Station
            telemetry.addData("Servo Position", myServo.getPosition()); // for the Driver Station
            telemetry.addData("X Button Pressed", gamepad1.x); // for the Driver Station
            telemetry.update(); // update the Driver Station
        }
    }
}
