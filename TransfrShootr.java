// add this to code 

if (gamepad2.y) {
    transf_motor.setPower(1.0);
} else {
    transf_motor.setPower(0.0);
}

  // and also add this too

transf_motor = hardwareMap.get(DcMotor.class, "transf motor");

//oh and don't forget about these!!


shootr = hardwareMap.get(DcMotor.class, "shootr motor");


if (gamepad2.y) {
    shootr.setPower(1.0);
} else {
    shootr.setPower(0.0);
}

