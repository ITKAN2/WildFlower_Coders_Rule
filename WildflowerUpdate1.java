package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Wildflower Main", group = "TeleOp")
public class Wildflowermain extends LinearOpMode {

    private DcMotor intake;
    private DcMotor transfr;
    private DcMotor shootr;

    private DcMotor fr;
    private DcMotor br;
    private DcMotor bl;
    private DcMotor fl;

    @Override
    public void runOpMode() throws InterruptedException {

        // ==========================
        // Hardware Mapping
        // ==========================
        fr = hardwareMap.get(DcMotor.class, "fr");
        br = hardwareMap.get(DcMotor.class, "br");
        bl = hardwareMap.get(DcMotor.class, "bl");
        fl = hardwareMap.get(DcMotor.class, "fl");

        intake = hardwareMap.get(DcMotor.class, "intak");
        transfr = hardwareMap.get(DcMotor.class, "transfer");
        shootr = hardwareMap.get(DcMotor.class, "shooter");

        // ==========================
        // Motor Directions
        // ==========================
        fr.setDirection(DcMotorSimple.Direction.REVERSE);
        br.setDirection(DcMotorSimple.Direction.REVERSE);

        fl.setDirection(DcMotorSimple.Direction.FORWARD);
        bl.setDirection(DcMotorSimple.Direction.FORWARD);

        // ==========================
        // Brake Mode
        // ==========================
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // ==========================
        // Drive Mode
        // ==========================
        fr.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        br.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Shooter Toggle Variables
        boolean shooterOn = false;
        boolean previousY = false;

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            // =====================================
            // Mecanum Drive (SWYFT Drive V3)
            // =====================================
            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x * 1.1;
            double rx = gamepad1.right_stick_x;

            double denominator =
                    Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);

            double flPower = (y + x + rx) / denominator;
            double blPower = (y - x + rx) / denominator;
            double frPower = (y - x - rx) / denominator;
            double brPower = (y + x - rx) / denominator;

            fl.setPower(flPower);
            bl.setPower(blPower);
            fr.setPower(frPower);
            br.setPower(brPower);

            // =====================================
            // Intake + Transfer Together
            // =====================================

            if (gamepad2.a) {

                intake.setPower(1.0);
                transfr.setPower(1.0);

            }
            else if (gamepad2.b) {

                intake.setPower(-1.0);
                transfr.setPower(-1.0);

            }
            else {

                intake.setPower(0.0);
                transfr.setPower(0.0);

            }

            // =====================================
            // Shooter Toggle
            // Press Y once = ON
            // Press Y again = OFF
            // =====================================

            if (gamepad2.y && !previousY) {
                shooterOn = !shooterOn;
            }

            previousY = gamepad2.y;

            if (shooterOn) {
                shootr.setPower(1.0);
            } else {
                shootr.setPower(0.0);
            }

            // =====================================
            // Telemetry
            // =====================================

            telemetry.addData("FL", "%.2f", flPower);
            telemetry.addData("BL", "%.2f", blPower);
            telemetry.addData("FR", "%.2f", frPower);
            telemetry.addData("BR", "%.2f", brPower);

            telemetry.addData("Shooter", shooterOn ? "ON" : "OFF");
            telemetry.addData("Intake", intake.getPower());
            telemetry.addData("Transfer", transfr.getPower());

            telemetry.update();
        }
    }
}
