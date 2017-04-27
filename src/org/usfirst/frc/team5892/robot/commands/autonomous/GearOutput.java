package org.usfirst.frc.team5892.robot.commands.autonomous;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

class GearOutput implements PIDOutput {

	@Override
	public void pidWrite(double output) {
		Robot.drive.mecanumDrive(output, 0, 0);
        SmartDashboard.putNumber("Gear PID Output", output);
        //System.out.println("PID Output: " + output);
	}
	
}