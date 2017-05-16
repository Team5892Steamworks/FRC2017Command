package org.usfirst.frc.team5892.robot.commands;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;

/**
 *
 */
public class VisionRegShoot extends Command {
	
	static final double BASE_POWER = 1;
	static final double PER_PIXEL = -0.025;
	
	double power;
	
	ITable table;
	
	public VisionRegShoot() {
		// Use requires() here to declare subsystem dependencies
		//requires(Robot.exampleSubsystem);
		table = NetworkTable.getTable("GRIP").getSubTable("boilerContours");
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
	    
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double ydiff;
		double centerY[] = table.getNumberArray("centerY", new double[]{-2, -2});
	    if (centerY.length > 2) {
	    	double area[] = table.getNumberArray("area", new double[]{-2, -2});
	    	//double ys[] = table.getNumberArray("centerY", new double[]{-2, -2});
	    	double points[] = new double[2];
	    	double maxArea[] = new double[]{-1, -1};
	    	for (int i=0;i<area.length && i<centerY.length/* && i<ys.length*/;i++) {
	    		//if (ys[i] < 90) {
		    		if (area[i] > maxArea[0]) {
		    			maxArea[1] = maxArea[0]; points[1] = points[0];
		    			maxArea[0] = area[i];
		    			points[0] = centerY[i];
		    		} else if (area[i] > maxArea[1]) {
		    			maxArea[1] = area[i]; points[1] = centerY[i];
		    		}
	    		//}
	    	}
	    	ydiff = Math.abs(points[0] - points[1]);
	    } else if (centerY.length == 2) {
	    	ydiff = Math.abs(centerY[0] - centerY[1]);
	    } else {
	    	ydiff = 0;
	    }
	    
	    power = BASE_POWER + ydiff * PER_PIXEL;
	    SmartDashboard.putNumber("ydiff", ydiff);
	    SmartDashboard.putNumber("power", power);
		Robot.flywheel.set(-power);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.flywheel.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.flywheel.set(0);
	}
}
