package org.usfirst.frc.team5892.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5892.robot.Robot;

/**
 *
 */
public class EncoderAutoDriveStraight extends Command {
	double power, target;
	double duration = -1;
	
	public EncoderAutoDriveStraight(double power_, double target_) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
		power = power_;
		target = target_;
	}
	
	public EncoderAutoDriveStraight(double power_, double target_, double timeout) {
		this(power_, target_);
		duration = timeout;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.drive.tankDrive(power, power);
		EncoderAccess.resetBoth();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double left = EncoderAccess.getLeft();
		double right = EncoderAccess.getRight();
		if (left > right) Robot.drive.tankDriveSafe(power * right / left, power);
		else if (right < left) Robot.drive.tankDriveSafe(power, power * left / right);
		else Robot.drive.tankDrive(power, power);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return (EncoderAccess.getLeft() > target &&
				EncoderAccess.getRight() > target) ||
			   (duration > 0 && timeSinceInitialized() > duration);
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
