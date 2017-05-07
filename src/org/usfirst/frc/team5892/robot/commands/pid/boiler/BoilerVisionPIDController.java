package org.usfirst.frc.team5892.robot.commands.pid.boiler;

import edu.wpi.first.wpilibj.PIDController;

class BoilerVisionPIDController extends PIDController {
	
	static final double CAMERA_X_CENTER = 90;
	static final double TOLERANCE = 2;
	
    static final double Kp = 0.014;
    static final double Ki = 0.0005;
    static final double Kd = 0.0;
    
    public BoilerVisionPIDController() {
    	super(Kp, Ki, Kd, new BoilerInput(), new BoilerOutput());
    	setSetpoint(CAMERA_X_CENTER);
    	setInputRange(0, 160);
    	setOutputRange(-1, 1);
    	setAbsoluteTolerance(TOLERANCE);
    }
}
