package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Gamepad Motor Control", group = "Linear OpMode")
public class DI extends LinearOpMode {

    // Declare all motor variables
    private DcMotor testMotor = null;
    private DcMotor m1 = null;
    private DcMotor m2 = null;
    private DcMotor m3 = null;
    private DcMotor m4 = null;

    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize the test/intake motor
        testMotor = hardwareMap.get(DcMotor.class, "int1");

        // Initialize the 4 drivetrain motors
        m1 = hardwareMap.get(DcMotor.class, "m1");
        m2 = hardwareMap.get(DcMotor.class, "m2");
        m3 = hardwareMap.get(DcMotor.class, "m3");
        m4 = hardwareMap.get(DcMotor.class, "m4");
    
        // Set motor directions
        m1.setDirection(DcMotor.Direction.FORWARD);
        m2.setDirection(DcMotor.Direction.REVERSE);
        m3.setDirection(DcMotor.Direction.FORWARD);
        m4.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the driver to press PLAY
        waitForStart();
        if (isStopRequested()) return;

        double tgtPower = 0;

        // One single loop to run everything at the same time
        while (opModeIsActive()) {
            
            // --- CONTROLLER 1: Drivetrain Control ---
            tgtPower = -this.gamepad1.left_stick_y;
            
            m1.setPower(tgtPower);
            m2.setPower(tgtPower);
            m3.setPower(tgtPower);          
            m4.setPower(tgtPower);

            // --- CONTROLLER 2: Test/Intake Motor Control ---
            if (gamepad2.a) {
                // Spin forward if A is pressed
                testMotor.setPower(1.0);
            } else if (gamepad2.b) {
                // Spin backward if B is pressed
                testMotor.setPower(-1.0);
            } else {
                // Stop if neither is pressed
                testMotor.setPower(0.0);
            }

            // Send feedback back to the driver station
            telemetry.addData("Drive Power", tgtPower);
            telemetry.addData("Test Motor Power", testMotor.getPower());
            telemetry.update();
        }
    }
}
