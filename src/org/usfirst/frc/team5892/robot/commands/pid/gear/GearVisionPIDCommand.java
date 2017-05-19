package org.usfirst.frc.team5892.robot.commands.pid.gear;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
@Deprecated
public class GearVisionPIDCommand extends Command {
	
	private static GearStrafeVisionPIDController strafeControl;
	Preferences prefs;
	
	/*double strafe;
	double rotate;*/
	
	public GearVisionPIDCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
		strafeControl = new GearStrafeVisionPIDController(this);
		prefs = Preferences.getInstance();
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		strafeControl.setPID(prefs.getDouble("Gear Kp", GearStrafeVisionPIDController.Kp), 
				             prefs.getDouble("Gear Ki", GearStrafeVisionPIDController.Ki),
				             prefs.getDouble("Gear Kd", GearStrafeVisionPIDController.Kd));
		strafeControl.setSetpoint(prefs.getDouble("Gear Setpoint", GearStrafeVisionPIDController.CAMERA_X_CENTER));
		strafeControl.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		//Robot.drive.mecanumDrive(strafe, 0, rotate);
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
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
