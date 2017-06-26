package org.usfirst.frc.team5892.robot.subsystems.sensors;

@Deprecated
public class Sensor {
    String name;
    ValueGetter getter;
	
    Sensor(String name, ValueGetter getter) {
    	this.name = name;
    	this.getter = getter;
    }
    
    public double getValue() {
    	return getter.getValue();
    }
}
