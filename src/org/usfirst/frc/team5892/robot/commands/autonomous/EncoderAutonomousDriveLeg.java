package org.usfirst.frc.team5892.robot.commands.autonomous;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.Counter;

public class EncoderAutonomousDriveLeg extends AutonomousDriveLeg {
	
	static Counter leftWheel = new Counter(Robot.map.encoderLeft);
	static Counter rightWheel = new Counter(Robot.map.encoderRight);
	final double leftAtStart, rightAtStart;
	double leftTarget, rightTarget;
    
	public EncoderAutonomousDriveLeg(double xAxis_, double yAxis_, double twist_, double target) {		
		super(xAxis_, yAxis_, twist_, -1);
		leftAtStart = leftWheel.getDistance(); rightAtStart = rightWheel.getDistance();
		leftTarget = target; rightTarget = target;
	}
	
	public EncoderAutonomousDriveLeg(double xAxis_, double yAxis_, double twist_, double leftTarget_, double rightTarget_) {
		super(xAxis_, yAxis_, twist_, -1);
		leftAtStart = leftWheel.getDistance(); rightAtStart = rightWheel.getDistance();
		leftTarget = leftTarget_; rightTarget = rightTarget_;
	}
	
	@Override
	protected boolean isFinished() {
		return leftWheel.getDistance() - leftAtStart > leftTarget &&
			   rightWheel.getDistance() - rightAtStart > rightTarget;
	}
    
}
