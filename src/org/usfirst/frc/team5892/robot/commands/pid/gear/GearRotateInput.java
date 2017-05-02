package org.usfirst.frc.team5892.robot.commands.pid.gear;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

class GearRotateInput implements PIDSource {
	
	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		return PIDSourceType.kDisplacement;
	}

	@Override
	public double pidGet() {
		double input = Robot.ahrs.getAngle();
		SmartDashboard.putNumber("Gear Rotate PID Input", input);
		return input;
	}
	
}