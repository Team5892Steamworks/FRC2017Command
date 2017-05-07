package org.usfirst.frc.team5892.robot.commands.pid.gear;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5892.HEROcode.pid.HEROicPIDController;
import org.usfirst.frc.team5892.robot.Robot;

/**
 *
 */
public class HEROicGearCommand extends Command {
	
	private HEROicGearController strafeControl;
	Preferences prefs;
	
	double setpoint;
	
	/*double strafe;
	double rotate;*/
	
	public HEROicGearCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
		strafeControl = new HEROicGearController();
		prefs = Preferences.getInstance();
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		strafeControl.setPID(prefs.getDouble("Gear Kp", HEROicGearController.Kp), 
				             prefs.getDouble("Gear Ki", HEROicGearController.Ki),
				             prefs.getDouble("Gear Kd", HEROicGearController.Kd));
		setpoint = prefs.getDouble("Gear Setpoint", GearStrafeVisionPIDController.CAMERA_X_CENTER);
		strafeControl.setSetpoint(setpoint);
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
		return timeSinceInitialized() > 1 && strafeControl.getLastInput() == setpoint;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		strafeControl.disable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
	
	private class HEROicGearController extends HEROicPIDController {
		
		public static final double Kp = 0.0052;
		public static final double Ki = 0.00075;
		public static final double Kd = 0.068;
		
		private GearStrafeInput stuff = new GearStrafeInput(); // Yeah... I'm too lazy to copy-paste all of the stuff for pidGet().
	    private GearStrafeOutput morestuff = new GearStrafeOutput(); // Ditto for pidWrite().
		
		public HEROicGearController() {
			super(Kp, Ki, Kd);
		}

		@Override
		public double getPIDInput() {
			return stuff.pidGet();
		}

		@Override
		public void usePIDOutput(double output) {
			morestuff.pidWrite(output);
		}

	}
}
