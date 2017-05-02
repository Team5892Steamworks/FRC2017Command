package org.usfirst.frc.team5892.robot.commands.pid.gear;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5892.robot.Robot;

/**
 *
 */
public class GearVisionPIDCommand extends Command {
	
	private static GearStrafeVisionPIDController strafeControl;
	private static GearRotateVisionPIDController rotateControl;
	
	double strafe;
	double rotate;
	
	public GearVisionPIDCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
		strafeControl = new GearStrafeVisionPIDController(this);
		rotateControl = new GearRotateVisionPIDController(this);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		rotateControl.setSetpoint(Robot.ahrs.getAngle());
		strafeControl.enable();
		rotateControl.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.drive.mecanumDrive(strafe, 0, rotate);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return timeSinceInitialized() > 1 && strafeControl.onTarget();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		strafeControl.reset();
		rotateControl.reset();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
