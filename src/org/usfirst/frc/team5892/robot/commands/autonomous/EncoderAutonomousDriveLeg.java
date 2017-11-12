package org.usfirst.frc.team5892.robot.commands.autonomous;

import org.usfirst.frc.team5892.robot.Robot;

public class EncoderAutonomousDriveLeg extends AutonomousDriveLeg {
	
	double leftTarget, rightTarget;
    
	public EncoderAutonomousDriveLeg(double xAxis_, double yAxis_, double twist_, double target) {		
		super(xAxis_, yAxis_, twist_, -1);
		leftTarget = target; rightTarget = target;
	}
	
	public EncoderAutonomousDriveLeg(double xAxis_, double yAxis_, double twist_, double target, double duration_) {
		super(xAxis_, yAxis_, twist_, duration_);
		leftTarget = target; rightTarget = target;
	}
	
	@Override
	protected void initialize() {
		super.initialize();
		Robot.sensors.resetEncoders();
	}
	
	@Override
	protected void execute() {
		super.execute();
		/*SmartDashboard.putNumber("Left Encoder", Robot.sensors);
		SmartDashboard.putNumber("Right Encoder", EncoderAccess.getRight());*/
	}
	
	@Override
	protected boolean isFinished() {
		if (Robot.sensors.encoderLeft.getValue() > leftTarget) {
			System.out.println("Encoders finished: left encoder triggered!");
			return true;
		}
		if (Robot.sensors.encoderRight.getValue() > rightTarget) {
			System.out.println("Encoders finished: right encoder triggered!");
			return true;
		}
		return //(Robot.sensors.encoderLeft.getValue() > leftTarget ||
			    //Robot.sensors.encoderRight.getValue() > rightTarget) ||
			   (duration > 0 && timeSinceInitialized() > duration);
	}
    
}
