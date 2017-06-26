package org.usfirst.frc.team5892.HEROcode.sensormap;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Uses reflections to automate writing {@link getAllSensors}. While easier to maintain, it may use more memory and/or processing power. I don't really know how reflections work.
 * 
 * @author Kai Page
 */
public class ReflectiveSensorArray extends SensorArray {
	
	Sensor[] sensors;
	
	public ReflectiveSensorArray() {
		Field[] fields = this.getClass().getDeclaredFields();
		ArrayList<Sensor> sensors = new ArrayList<>();
		for (Field f : fields) {
			if (Sensor.class.isAssignableFrom(f.getType())) {
				try {
					sensors.add(new ReflectedSensor(f.get(this)));
				} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException | NullPointerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public final Sensor[] getAllSensors() {
		return sensors;
	}
	
	private class ReflectedSensor extends Sensor {

		public ReflectedSensor(Object original) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NullPointerException {
			super((String) Sensor.class.getMethod("getName")
					.invoke(original),
					() -> {
				try {
					return (Double) Sensor.class.getMethod("getValue").invoke(original);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| NoSuchMethodException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} return 0;
			});
		}
		
	}

}
