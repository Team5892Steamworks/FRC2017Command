package org.usfirst.frc.team5892.HEROcode.sensormap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The command used to automatically put sensors on the SmartDashboard.
 * 
 * @author Kai Page
 */
class SensorOutputCommand extends Command {
    SensorArray parent;
    Sensor[] sensors;
	
	SensorOutputCommand(SensorArray parent) {
		this.parent = parent;
		requires(parent);
		setRunWhenDisabled(true);
		setInterruptible(false);
	}
	
	@Override
	protected void initialize() {
		sensors = parent.getAllSensors();
	}
	
	@Override
	protected void execute() {
		for (Sensor s : parent.getAllSensors()) {
			SmartDashboard.putNumber(s.getName(), s.getValue());
		}
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

}
