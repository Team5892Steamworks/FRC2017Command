package org.usfirst.frc.team5892.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5892.robot.Robot;

/**
 *
 */
public class EncoderStraighten extends Command {
	double delta, target, twist;
	public EncoderStraighten(double speed) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
		twist = speed;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		delta = EncoderAccess.getRight() - EncoderAccess.getLeft();
		target = EncoderAccess.getLeft() + delta / 2;
		Robot.drive.mecanumDrive(0, 0, twist * (delta > 0 ? 1 : -1));
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		System.out.println((delta > 0 ? "Left: " + EncoderAccess.getLeft() : 
				                       " Right: " + EncoderAccess.getRight()) +
				                       " Target: " + target +
				                       " Finished: " + isFinished());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if (delta > 0) return EncoderAccess.getLeft() >= target;
		else           return EncoderAccess.getRight() >= target;
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
