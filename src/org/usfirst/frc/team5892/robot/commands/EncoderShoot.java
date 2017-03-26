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
	double lastSpeed, lastPower, targetSpeed;
	double duration = -1;
	static Victor flywheel = new Victor(Robot.map.flywheel.port);
	static Victor feeder = new Victor(Robot.map.feeder.port);
	private static Counter encoder/* = new Counter()*/;
	
	public EncoderShoot(double speed) {
		// Use requires() here to declare subsystem dependencies
		//requires(Robot.exampleSubsystem);
		targetSpeed = speed;
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
		flywheel.set(Robot.map.flywheel.inverted ? -1 : 1);
		lastPower = 1;
		//lastSpeed = encoder.get();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double speed = getEncoder();
		double spdP = targetSpeed / speed;
		double power = lastPower + kP * (spdP * lastPower - lastPower);
		if (power > 1) power = 1;
		if (power < .1) power = .1;
		lastPower = power;
		flywheel.set(power * (Robot.map.flywheel.inverted ? -1 : 1));
		
		if (speed > 0.8 * targetSpeed || timeSinceInitialized() > 1) feeder.set(Robot.map.flywheel.inverted ? -1 : 1);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return duration > 0 && timeSinceInitialized() >= duration;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		flywheel.set(0);
		feeder.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		flywheel.set(0);
		feeder.set(0);
	}
}
