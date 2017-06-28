package org.usfirst.frc.team5892.robot.commands.pid.boiler;

import org.usfirst.frc.team5892.HEROcode.pid.HEROicPIDController;
import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;

public class HEROicBoilerAlignCommand extends Command {
	
	private HEROicBoilerController control;
	ITable table;
	
	static final double CAMERA_X_CENTER = 75;
	
	public HEROicBoilerAlignCommand() {
		requires(Robot.drive);
		control = new HEROicBoilerController();
		table = NetworkTable.getTable("GRIP").getSubTable("boilerContours");
	}
	
	@Override
	protected void initialize() {
		control.enable();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void end() {
		control.disable();
	}
	
	private class HEROicBoilerController extends HEROicPIDController {
		
		public static final double Kp = 0.014;
		public static final double Ki = 0.0005;
		public static final double Kd = 0.0;
		
		public HEROicBoilerController() {
			super(Kp, Ki, Kd);
			setSetpoint(CAMERA_X_CENTER);
		}

		@Override
		public double getPIDInput() {
			double input;
			double centerX[] = table.getNumberArray("centerX", new double[]{-2, -2});
		    if (centerX.length > 2) {
		    	double area[] = table.getNumberArray("area", new double[]{-2, -2});
		    	//double ys[] = table.getNumberArray("centerY", new double[]{-2, -2});
		    	double points[] = new double[2];
		    	double maxArea[] = new double[]{-1, -1};
		    	for (int i=0;i<area.length && i<centerX.length/* && i<ys.length*/;i++) {
		    		//if (ys[i] < 90) {
			    		if (area[i] > maxArea[0]) {
			    			maxArea[1] = maxArea[0]; points[1] = points[0];
			    			maxArea[0] = area[i];
			    			points[0] = centerX[i];
			    		} else if (area[i] > maxArea[1]) {
			    			maxArea[1] = area[i]; points[1] = centerX[i];
			    		}
		    		//}
		    	}
		    	input = (points[0] + points[1]) / 2;
		    } else if (centerX.length == 2) {
		    	input = (centerX[0] + centerX[1]) / 2;
		    } else if (centerX.length == 1) {
		    	input = centerX[0];
		    } else {
		    	input = 80;
		    }
		    SmartDashboard.putNumber("Boiler PID Input", input);
		    return input;
		}

		@Override
		public void usePIDOutput(double output) {
			Robot.drive.mecanumDrive(0, 0, -output);
	        SmartDashboard.putNumber("Boiler PID Output", output);
		}
	}

}
