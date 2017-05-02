package org.usfirst.frc.team5892.robot.commands.pid.gear;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;

class GearStrafeInput implements PIDSource {
    
	ITable table;
	
	GearStrafeInput() {
		table = NetworkTable.getTable("GRIP").getSubTable("gearContours");
	}
	
	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		return PIDSourceType.kDisplacement;
	}

	@Override
	public double pidGet() {
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
	    SmartDashboard.putNumber("Gear Strafe PID Input", input);
	    //System.out.println("Boiler PID Input: " + input);
	    return input;
	}
	
}