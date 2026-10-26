// add this to code 

if (gamepad2.y) {
    transf_motor.setPower(1.0);
} else {
    transf_motor.setPower(0.0);
}

  // and also add this too

transf_motor = hardwareMap.get(DcMotor.class, "transf motor");
