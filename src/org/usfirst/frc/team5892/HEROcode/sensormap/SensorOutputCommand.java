package org.usfirst.frc.team5892.HEROcode.sensormap;

import java.lang.reflect.Field;
import java.util.ArrayList;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The command used to automatically put sensors on the SmartDashboard. I have no idea how it works, and I <em>wrote</em> the dang thing. As far as I'm concerned, java.lang.reflect is powered by wizardry.
 * 
 * @author Kai Page
 */
class SensorOutputCommand extends Command {
    
	/** The array of sensors outputted by this command. */
	SensorArray parent;
	/** The array of sensors outputted by this command, in another sense of the word "array." */
	Sensor[] sensors;
	
	SensorOutputCommand(SensorArray parent) {
		this.parent = parent;
		requires(parent);
		setRunWhenDisabled(true);
		setInterruptible(false);
	}
	
	@Override
	protected void initialize() {
		Field[] fields = parent.getClass().getDeclaredFields();
		ArrayList<Sensor> sensors = new ArrayList<>();
		for (Field f : fields) {
			if (Sensor.class.isAssignableFrom(f.getType())) {
				try {
					sensors.add((Sensor) f.get(parent));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		this.sensors = (Sensor[]) sensors.toArray();
	}
	
	@Override
	protected void execute() {
		for (Sensor s : sensors) {
			SmartDashboard.putNumber(s.getName(), s.getValue());
		}
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

}
