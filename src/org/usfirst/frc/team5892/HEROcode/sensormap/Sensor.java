package org.usfirst.frc.team5892.HEROcode.sensormap;

/**
 * A sensor that, if part of a {@link SensorArray}, will automatically be put on the SmartDashboard. Convenient!
 * 
 * @author Kai Page
 */
public class Sensor {
	/** The name of the sensor on the SmartDashboard. */
    protected String name;
    /** The method called to get the value of the sensor. */
    protected SensorGetter getter;
    
    public Sensor(String name, SensorGetter getter) {
    	this.name = name;
    	this.getter = getter;
    }
    
    /** Get the name of the sensor. */
    public String getName() { return name; }
    /** Get the current value of the sensor. */
    public double getValue() { return getter.getValue(); }
}
