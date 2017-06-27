package org.usfirst.frc.team5892.HEROcode.sensormap;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Uses reflections to automate writing {@link getAllSensors}. While easier to maintain, it may use more memory and/or processing power.
 * <br><br>
 * Also it doesn't work yet because I have no idea how to use reflections. :(
 * 
 * @author Kai Page
 * @deprecated Crashes the freaking robot. Nope.
 */
// TODO make it work????????
@Deprecated
public abstract class ReflectiveSensorArray extends SensorArray {
	
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
