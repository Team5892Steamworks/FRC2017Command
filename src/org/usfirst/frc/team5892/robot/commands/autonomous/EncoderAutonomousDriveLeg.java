package org.usfirst.frc.team5892.robot.commands.autonomous;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class EncoderAutonomousDriveLeg extends AutonomousDriveLeg {
	
	public static Counter leftWheel = new Counter(Robot.map.encoderLeft);
	public static Counter rightWheel = new Counter(Robot.map.encoderRight);
	double leftAtStart, rightAtStart;
	double leftTarget, rightTarget;
    
	public EncoderAutonomousDriveLeg(double xAxis_, double yAxis_, double twist_, double target) {		
		super(xAxis_, yAxis_, twist_, -1);
		leftAtStart = leftWheel.get(); rightAtStart = rightWheel.get();
		leftTarget = target; rightTarget = target;
	}
	
	public EncoderAutonomousDriveLeg(double xAxis_, double yAxis_, double twist_, double leftTarget_, double rightTarget_) {
		super(xAxis_, yAxis_, twist_, -1);
		leftTarget = leftTarget_; rightTarget = rightTarget_;
	}
	
	@Override
	protected void initialize() {
		super.initialize();
		leftWheel.reset(); rightWheel.reset();
		leftAtStart = leftWheel.get(); rightAtStart = rightWheel.get();
	}
	
	@Override
	protected void execute() {
		super.execute();
		SmartDashboard.putNumber("Left Encoder", leftWheel.get());
		SmartDashboard.putNumber("Right Encoder", rightWheel.get());
	}
	
	@Override
	protected boolean isFinished() {
		return leftWheel.get() - leftAtStart > leftTarget &&
			   rightWheel.get() - rightAtStart > rightTarget;
	}
    
}
