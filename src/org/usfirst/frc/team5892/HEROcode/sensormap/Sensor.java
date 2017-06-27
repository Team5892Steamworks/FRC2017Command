package org.usfirst.frc.team5892.HEROcode.sensormap;

/**
 * A sensor that will automatically put its output on the {@link SmartDashboard}.
 * 
 * @author Kai Page
 */
// TODO add LiveWindow support
public class Sensor {
    protected String name;
    protected SensorGetter getter;
    
    public Sensor(String name, SensorGetter getter) {
    	this.name = name;
    	this.getter = getter;
    	SensorOutputCommand.sensors.add(this);
    }
    
    /** Get the name of the sensor. */
    public String getName() { return name; }
    /** Get the current value of the sensor. */
    public double getValue() { return getter.getValue(); }
    
}
