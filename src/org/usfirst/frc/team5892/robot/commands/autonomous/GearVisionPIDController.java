package org.usfirst.frc.team5892.robot.commands.autonomous;

import edu.wpi.first.wpilibj.PIDController;

public class GearVisionPIDController extends PIDController {
	
	static final double CAMERA_X_CENTER = 80;
	static final double TOLERANCE = 2;
	
    static final double Kp = 0.015;
    static final double Ki = 0.001;
    static final double Kd = 0.0;
    
    public GearVisionPIDController() {
    	super(Kp, Ki, Kd, new GearInput(), new GearOutput());
    	setSetpoint(CAMERA_X_CENTER);
    	setInputRange(0, 160);
    	setOutputRange(-1, 1);
    	setAbsoluteTolerance(TOLERANCE);
    }
}
