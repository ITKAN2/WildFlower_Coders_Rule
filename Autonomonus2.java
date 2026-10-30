package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "Wildflower Auto", group = "Competition")
public class WildflowerAuto extends LinearOpMode {

        fl = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");
        intak = hardwareMap.get(DcMotor.class, "intak");
        transfer = hardwareMap.get(DcMotor.class, "transfer");
        shooter = hardwareMap.get(DcMotor.class, "shooter");


while (opModeIsActive()) {

telemetry.addLine("It is running!");
        telemetry.update();

      // fl.setPower(1.0);   
     //  fr.setPower(1.0);     
      // bl.setPower(1.0);     
     //  br.setPower(1.0); 
     double forwardPower = 1.0;
     double backwardPower = -1.0;
        intak.setPower(forwardPower);
        transfer.setPower(forwardPower);
        bl.setPower(forwardPower);
        br.setPower(forwardPower);
        fr.setPower(forwardPower);
        fl.setPower(forwardPower);
     sleep.(2000)
        intak.setPower(forwardPower);
        transfer.setPower(forwardPower);
        bl.setPower(backwardPower);
        br.setPower(forwardPower);
        fr.setPower(backwardPower);
        fl.setPower(forwardPower);
     sleep.(1000)
        intak.setPower(forwardPower);
        transfer.setPower(forwardPower);
        bl.setPower(backwardPower);
        br.setPower(backwardPower);
        fr.setPower(backwardPower);
        fl.setPower(backwardPower);
     sleep.(1000)
        intak.setPower(forwardPower);
        transfer.setPower(forwardPower);
        shooter.setPower(forwardPower);
