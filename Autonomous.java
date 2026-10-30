package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "Wildflower Auto XDrive", group = "Competition")
public class WildflowerAuto extends LinearOpMode {

    private DcMotor fl;
    private DcMotor fr;
    private DcMotor bl;
    private DcMotor br;

    private DcMotor intak;
    private DcMotor transfer;
    private DcMotor shooter;

    @Override
    public void runOpMode() throws InterruptedException {

        fl = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");

        intak = hardwareMap.get(DcMotor.class, "intak");
        transfer = hardwareMap.get(DcMotor.class, "transfer");
        shooter = hardwareMap.get(DcMotor.class, "shooter");

        fr.setDirection(DcMotorSimple.Direction.REVERSE);
        br.setDirection(DcMotorSimple.Direction.REVERSE);

        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addLine("XDrive Auto Ready");
        telemetry.update();

        waitForStart();

        if (isStopRequested()) return;

        intak.setPower(1.0);
        transfer.setPower(1.0);

        // Forward
        fl.setPower(0.8);
        fr.setPower(0.8);
        bl.setPower(0.8);
        br.setPower(0.8);
        sleep(2000);
        stopDrive();

        sleep(250);

        // Strafe Right (X-Drive)
        fl.setPower(0.8);
        fr.setPower(-0.8);
        bl.setPower(-0.8);
        br.setPower(0.8);
        sleep(1000);
        stopDrive();

        sleep(250);

        // Back Up
        fl.setPower(-0.8);
        fr.setPower(-0.8);
        bl.setPower(-0.8);
        br.setPower(-0.8);
        sleep(1000);
        stopDrive();

        sleep(250);

        // Shoot
        shooter.setPower(1.0);
        sleep(3000);

        transfer.setPower(1.0);
        sleep(1500);

        shooter.setPower(0);
        transfer.setPower(0);
        intak.setPower(0);

        stopDrive();

        telemetry.addLine("Autonomous Complete");
        telemetry.update();
    }

    private void stopDrive() {
        fl.setPower(0);
        fr.setPower(0);
        bl.setPower(0);
        br.setPower(0);
    }
}
