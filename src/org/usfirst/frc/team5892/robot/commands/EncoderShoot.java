package org.usfirst.frc.team5892.robot.commands;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5892.robot.Robot;

/**
 *
 */
public class EncoderShoot extends Command {
	static final double kP = 0.9;
	double lastSpeed, target;
	double duration = -1;
	static Victor flywheel = new Victor(Robot.map.flywheel.port);
	static Victor feeder = new Victor(Robot.map.feeder.port);
	private static Counter encoder/* = new Counter()*/;
	
	public EncoderShoot(double speed) {
		// Use requires() here to declare subsystem dependencies
		//requires(Robot.exampleSubsystem);
		target = speed;
	}
	
	public EncoderShoot(double speed, double duration_) {
		this(speed);
		duration = duration_;
	}
	
	private double getEncoder() {
		double ret = encoder.get();
		encoder.reset();
		return ret;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		flywheel.set(1);
		lastSpeed = encoder.get();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
