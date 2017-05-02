package org.usfirst.frc.team5892.robot.commands.pid.gear;

import edu.wpi.first.wpilibj.PIDController;

class GearRotateVisionPIDController extends PIDController {
	
	static final double TOLERANCE = 1;
	
    static final double Kp = 0.02;
    static final double Ki = 0.05;
    static final double Kd = 0.0;
    
    public GearRotateVisionPIDController(GearVisionPIDCommand parent) {
    	super(Kp, Ki, Kd, new GearRotateInput(), new GearRotateOutput(parent));
    	setOutputRange(-1, 1);
    	setPercentTolerance(TOLERANCE);
    }
}
