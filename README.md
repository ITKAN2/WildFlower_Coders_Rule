package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
//import edu.first.ftc.hardware.Servo;

@TeleOp(name = "alL", group = "Linear Opmode")
//@TeleOp(name="MyTeleOpMode", group="Linear Opmode")


public class testDrive extends LinearOpMode {
    private Servo myServo;
    
     // Define servo positions mapped from degrees to the 0.0 - 1.0 range
    // Assuming a standard 180-degree servo: 0 degrees = 0.0, 90 degrees = 0.5
    private static final double POSITION_0_DEG = 0.0;
    private static final double POSITION_90_DEG = 0.5;

    @Override
    public void runOpMode() throws InterruptedException {
@@ -20,12 +28,17 @@ public void runOpMode() throws InterruptedException {
        DcMotor frontRightMotor = hardwareMap.dcMotor.get("m3");
        DcMotor backRightMotor = hardwareMap.dcMotor.get("m4");
        DcMotor testMotor = hardwareMap.dcMotor.get("int1");
        Servo myServo = hardwareMap.servo.get("servo1");
        


        // Reverse the left side motors because they face the opposite direction
        // Note: Check your specific physical gearing; sometimes the right side needs reversing instead.
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        // Set an initial position before the match starts
        myServo.setPosition(0.0);
       // .setPosition(POSITION_90_DEG_DEG);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
@@ -84,10 +97,21 @@ public void runOpMode() throws InterruptedException {
                // Stop if neither is pressed
                testMotor.setPower(0.0);
            }
            
              // Check if the 'y' button on Gamepad 1 is pressed
            if (gamepad2.y) {
                
              //   telemetry.addData("servo1", myServo.getPosition());
                myServo.setPosition(0.9);
              //  myServo.setPosition(0.0);
             //   telemetry.addData("servo1", myServo.getPosition());
            } else {
                myServo.setPosition(0.0);
            }

            // Optional telemetry output for debugging wheel speeds
            telemetry.addData("Front Left Power", frontLeftPower);
            telemetry.addData("Back Left Power", backLeftPower);
            // Optional telemetry output for debugging wheel speeds
            telemetry.addData("Front Right Power", frontRightPower);
            telemetry.addData("Back Right Power", backRightPower);
            telemetry.update();
