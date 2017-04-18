package org.usfirst.frc.team5892.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITable;

import org.usfirst.frc.team5892.robot.Robot;

/**
 *
 */
public class VisionGearAlignRotate extends Command {
	ITable table;
	static final double TARGET_RATIO = 1;
	static final double TOLERANCE = .05;
	static final double ROTATE_SPEED = .4;
	
	double dir = 0;
	
	public VisionGearAlignRotate() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
		table = NetworkTable.getTable("GRIP").getSubTable("gearContours");
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double area[] = table.getNumberArray("area", new double[]{-2, -2});
	    double centerX[] = table.getNumberArray("centerX", new double[]{-2, -2});
	    double maxarea[] = new double[]{0, 0};
	    int indices[] = new int[2];
	    
	    if (area.length > 2) {
	    	for (int i=0;i<area.length;i++) {
	    		if (area[i] > maxarea[0]) {
	    			maxarea[1] = maxarea[0];
	    			maxarea[0] = area[i];
	    			indices[1] = indices[0];
	    			indices[0] = i;
	    		} else if (area[i] > maxarea[1]) {
	    			maxarea[1] = area[i];
	    			indices[i] = i;
	    		}
	    	}
	    	if (centerX[indices[0]] > centerX[indices[1]]) {
	    		int temp = indices[0];
	    		indices[0] = indices[1];
	    		indices[1] = temp;
	    	}
	    } else if (area.length == 2) {
	    	if (centerX[0] < centerX[1]) indices = new int[]{0, 1};
	    	else indices = new int[]{1, 0};
	    } else cancel();
	    
	    if (area[indices[0]] > area[indices[1]]) dir = -1;
	    else if (area[indices[1]] < area[indices[0]]) dir = 1;
	    else dir = 0;
	    
	    Robot.drive.mecanumDrive(0, 0, dir * ROTATE_SPEED);
	    
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return (dir > TARGET_RATIO - TOLERANCE &&
			   dir < TARGET_RATIO + TOLERANCE) ||
			   Robot.oi.pilot.getRawButton(5);
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
