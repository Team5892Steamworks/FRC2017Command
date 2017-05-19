package org.usfirst.frc.team5892.robot.commands.pid.gear;

import org.usfirst.frc.team5892.HEROcode.pid.HEROicPIDController;
import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;

/**
 *
 */
public class HEROicGearAlignCommand extends Command {
	
	private HEROicGearController strafeControl;
	Preferences prefs;
	ITable table;
	
	static final double Kp = 0.0095;
	static final double Ki = 0.013;
	static final double Kd = 0.089;
	
	static final double CAMERA_X_CENTER = 80;
	static final double TOLERANCE = 0.5;
	
	double setpoint;
	
	public HEROicGearAlignCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
		strafeControl = new HEROicGearController();
		prefs = Preferences.getInstance();
		table = NetworkTable.getTable("GRIP").getSubTable("gearContours");
	}
	
	public HEROicGearAlignCommand(double timeout) {
		this();
		setTimeout(timeout);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		strafeControl.setPID(prefs.getDouble("Gear Kp", Kp), 
				             prefs.getDouble("Gear Ki", Ki),
				             prefs.getDouble("Gear Kd", Kd));
		setpoint = prefs.getDouble("Gear Setpoint", CAMERA_X_CENTER);
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
		return isTimedOut() || (timeSinceInitialized() > 1 && setpoint - TOLERANCE <= strafeControl.getLastInput() &&
				strafeControl.getLastInput() <= setpoint + TOLERANCE);
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
		
		public HEROicGearController() {
			super(Kp, Ki, Kd);
		}

		@Override
		public double getPIDInput() {
			double input;
			double centerX[] = table.getNumberArray("centerX", new double[]{-2, -2});
		    if (centerX.length > 2) {
		    	double area[] = table.getNumberArray("area", new double[]{-2, -2});
		    	double points[] = new double[2];
		    	double maxArea[] = new double[]{-1, -1};
		    	for (int i=0;i<area.length && i<centerX.length;i++) {
		    		if (area[i] > maxArea[0]) {
		    			maxArea[1] = maxArea[0]; points[1] = points[0];
		    			maxArea[0] = area[i];
		    			points[0] = centerX[i];
		    		} else if (area[i] > maxArea[1]) {
		    			maxArea[1] = area[i]; points[1] = centerX[i];
		    		}
		    	}
		    	input = (points[0] + points[1]) / 2;
		    } else if (centerX.length == 2) {
		    	input = (centerX[0] + centerX[1]) / 2;
		    } else if (centerX.length == 1) {
		    	input = centerX[0];
		    } else {
		    	input = 80; //cancel();
		    }
		    SmartDashboard.putNumber("Gear PID Input", input);
		    return input;
		}

		@Override
		public void usePIDOutput(double output) {
			Robot.drive.mecanumDrive(0, 0, -output);
	        SmartDashboard.putNumber("Gear PID Output", output);
		}

	}
}
