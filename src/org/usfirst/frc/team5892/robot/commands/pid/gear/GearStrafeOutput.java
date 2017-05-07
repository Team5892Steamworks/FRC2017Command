package org.usfirst.frc.team5892.robot.commands.pid.gear;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

class GearStrafeOutput implements PIDOutput {
    
	GearStrafeOutput() {}
	
	GearStrafeOutput(GearVisionPIDCommand backcompat) {}
	
	@Override
	public void pidWrite(double output) {
		Robot.drive.mecanumDrive(0, 0, -output);
        SmartDashboard.putNumber("Gear Strafe PID Output", output);
        //System.out.println("Boiler PID Output: " + output);
	}
	
}