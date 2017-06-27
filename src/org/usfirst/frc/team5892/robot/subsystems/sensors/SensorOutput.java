package org.usfirst.frc.team5892.robot.subsystems.sensors;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

@Deprecated
class SensorOutput extends Command {
    
	Sensor[] sensors;
	
	SensorOutput(Sensor[] sensors) {
		//requires(Robot.sensors); lol this was a thing?
		this.sensors = sensors;
		setRunWhenDisabled(true);
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
