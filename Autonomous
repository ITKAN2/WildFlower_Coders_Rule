package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "Wildflower Auto", group = "Competition")
public class WildflowerAuto extends LinearOpMode {

    // Drive motors
    private DcMotor fl;
    private DcMotor fr;
    private DcMotor bl;
    private DcMotor br;

    // Mechanisms
    private DcMotor intake;
    private DcMotor transfer;
    private DcMotor shooter;

    // Power settings
    private static final double DRIVE_POWER = 0.65;
    private static final double STRAFE_POWER = 0.60;
    private static final double SHOOTER_POWER = 1.0;

    @Override
    public void runOpMode() {

        //
        // Hardware Mapping
        //
        fl = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");

        intake = hardwareMap.get(DcMotor.class, "intak");
        transfer = hardwareMap.get(DcMotor.class, "transfer");
        shooter = hardwareMap.get(DcMotor.class, "shooter");

        //
        // Drive motor directions
        //
        fr.setDirection(DcMotorSimple.Direction.REVERSE);
        br.setDirection(DcMotorSimple.Direction.REVERSE);

        fl.setDirection(DcMotorSimple.Direction.FORWARD);
        bl.setDirection(DcMotorSimple.Direction.FORWARD);

        //
        // Brake when power is removed
        //
        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addLine("Wildflower Auto Ready");
        telemetry.update();

        waitForStart();

        if (!opModeIsActive()) return;

        //
        // Move away from wall
        //
        telemetry.addLine("Driving Forward");
        telemetry.update();

        driveForward(DRIVE_POWER);
        sleep(2000);
        stopDrive();

        //
        // Give shooter time to get up to speed
        //
        telemetry.addLine("Spinning Shooter");
        telemetry.update();

        shooter.setPower(SHOOTER_POWER);
        sleep(2500);

        //
        // Feed rings/game pieces
        //
        telemetry.addLine("Feeding Shooter");
        telemetry.update();

        intake.setPower(1.0);
        transfer.setPower(1.0);

        sleep(2000);

        intake.setPower(0);
        transfer.setPower(0);
        shooter.setPower(0);

        //
        // Move to parking area
        //
        telemetry.addLine("Strafing");
        telemetry.update();

        strafeRight(STRAFE_POWER);
        sleep(1200);
        stopDrive();

        //
        // Final adjustment
        //
        driveForward(0.5);
        sleep(1000);
        stopDrive();

        telemetry.addLine("Auto Complete");
        telemetry.update();
    }

    // -----------------------------
    // Drive Helpers
    // -----------------------------

    private void driveForward(double power) {
        fl.setPower(power);
        fr.setPower(power);
        bl.setPower(power);
        br.setPower(power);
    }

    private void strafeRight(double power) {
        fl.setPower(power);
        fr.setPower(-power);
        bl.setPower(-power);
        br.setPower(power);
    }

    private void stopDrive() {
        fl.setPower(0);
        fr.setPower(0);
        bl.setPower(0);
        br.setPower(0);
    }
}
