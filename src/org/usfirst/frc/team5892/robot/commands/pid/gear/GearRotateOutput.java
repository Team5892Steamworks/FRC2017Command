package org.usfirst.frc.team5892.robot.commands.pid.gear;

//import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

class GearRotateOutput implements PIDOutput {
    
	GearVisionPIDCommand parent;
	
	GearRotateOutput(GearVisionPIDCommand parent) {
		this.parent = parent;
	}
	
	@Override
	public void pidWrite(double output) {
		//Robot.drive.mecanumDrive(-output, 0, 0);
		parent.rotate = output;
        SmartDashboard.putNumber("Gear Rotate PID Output", output);
        //System.out.println("Boiler PID Output: " + output);
	}
	
}