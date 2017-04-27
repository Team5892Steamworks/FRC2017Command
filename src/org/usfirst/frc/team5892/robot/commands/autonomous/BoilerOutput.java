package org.usfirst.frc.team5892.robot.commands.autonomous;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

class BoilerOutput implements PIDOutput {

	@Override
	public void pidWrite(double output) {
		Robot.drive.mecanumDrive(0, 0, -output);
        SmartDashboard.putNumber("Boiler PID Output", output);
        //System.out.println("Boiler PID Output: " + output);
	}
	
}