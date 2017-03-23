package org.usfirst.frc.team5892.robot;

public abstract class RobotMapB {
	public MotorMap[] driveTrain;
	public MotorMap agitator;
	public MotorMap intake;
	public MotorMap flywheel;
	public MotorMap feeder;
	public MotorMap winch;
	
    public class MotorMap {
    	public final int port;
    	public final boolean inverted;
    	
    	MotorMap(int port_, boolean inverted_) {
    		port = port_;
    		inverted = inverted_;
    	}
    }
}
