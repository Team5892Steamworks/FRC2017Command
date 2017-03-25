package org.usfirst.frc.team5892.robot;

public abstract class RobotMapB {
	public MotorMap[] driveTrain;
	public ControlSetup[] controlSetup;
	public MotorMap agitator;
	public MotorMap intake;
	public MotorMap flywheel;
	public MotorMap feeder;
	public MotorMap winch;
	public int encoderLeft;
	public int encoderRight;
	
    public class MotorMap {
    	public final int port;
    	public final boolean inverted;
    	
    	MotorMap(int port_, boolean inverted_) {
    		port = port_;
    		inverted = inverted_;
    	}
    }
    
    public enum ControlSetup {
    	xAxis,
    	yAxis,
    	twist;
    	
    	public boolean inverted = false;
    	
    	protected void setInverted(boolean inverted_) {
    		inverted = inverted_;
    	}
    }
}
