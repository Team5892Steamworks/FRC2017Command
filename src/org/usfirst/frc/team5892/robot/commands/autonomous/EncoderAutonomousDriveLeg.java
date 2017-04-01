package org.usfirst.frc.team5892.robot.commands.autonomous;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
		EncoderAccess.resetBoth();
	}
	
	@Override
	protected void execute() {
		super.execute();
		SmartDashboard.putNumber("Left Encoder", EncoderAccess.getLeft());
		SmartDashboard.putNumber("Right Encoder", EncoderAccess.getRight());
	}
	
	@Override
	protected boolean isFinished() {
		return (EncoderAccess.getLeft() > leftTarget &&
			    EncoderAccess.getRight() > rightTarget) ||
			   (duration > 0 && timeSinceInitialized() > duration);
	}
    
}
