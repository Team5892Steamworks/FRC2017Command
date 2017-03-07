package org.usfirst.frc.team5892.robot.triggers;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class BatteryVoltageTrigger extends Trigger {
	private double min;
	
	public BatteryVoltageTrigger(double min_) {
		min = min_;
	}
	
	@Override
	public boolean get() {
		// TODO Auto-generated method stub
		//double voltage = DriverStation.getInstance().getBatteryVoltage();
		return DriverStation.getInstance().getBatteryVoltage() < min;
	}

}
