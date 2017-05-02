package org.usfirst.frc.team5892.robot.commands.pid.gear;

import edu.wpi.first.wpilibj.PIDController;

class GearStrafeVisionPIDController extends PIDController {
	
	static final double CAMERA_X_CENTER = 80;
	static final double TOLERANCE = 1;
	
    static final double Kp = 0.02;
    static final double Ki = 0.05;
    static final double Kd = 0.0;
    
    public GearStrafeVisionPIDController(GearVisionPIDCommand parent) {
    	super(Kp, Ki, Kd, new GearStrafeInput(), new GearStrafeOutput(parent));
    	setSetpoint(CAMERA_X_CENTER);
    	setInputRange(0, 160);
    	setOutputRange(-1, 1);
    	setAbsoluteTolerance(TOLERANCE);
    }
}
