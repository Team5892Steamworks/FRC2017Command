package org.usfirst.frc.team5892.robot.commands.autonomous;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

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
	
	public EncoderStraighten(double speed, double timeout) {
		this(speed);
		setTimeout(timeout);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		delta = Robot.sensors.encoderRight.getValue() - Robot.sensors.encoderLeft.getValue();
		target = Robot.sensors.encoderLeft.getValue() + delta / 2;
		Robot.drive.mecanumDrive(0, 0, twist * (delta > 0 ? 1 : -1));
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		System.out.println((delta > 0 ? "Left: " + Robot.sensors.encoderLeft.getValue() : 
				                       " Right: " + Robot.sensors.encoderRight.getValue()) +
				                       " Target: " + target +
				                       " Finished: " + isFinished());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if (isTimedOut()) return true;
		if (delta > 0) return Robot.sensors.encoderLeft.getValue() >= target;
		else           return Robot.sensors.encoderRight.getValue() >= target;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.drive.mecanumDrive(0, 0, 0);
	}
}
