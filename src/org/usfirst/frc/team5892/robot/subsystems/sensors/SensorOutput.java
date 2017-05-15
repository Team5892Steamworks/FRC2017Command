package org.usfirst.frc.team5892.robot.subsystems.sensors;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

class SensorOutput extends Command {
    
	Sensor[] sensors;
	
	SensorOutput(Sensor[] sensors) {
		this.sensors = sensors;
	}
	
	@Override
	protected void execute() {
		for (Sensor s : sensors) {
			SmartDashboard.putNumber(s.name, s.getValue());
		}
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

}
