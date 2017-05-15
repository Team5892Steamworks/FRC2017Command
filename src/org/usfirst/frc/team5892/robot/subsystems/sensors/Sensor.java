package org.usfirst.frc.team5892.robot.subsystems.sensors;

class Sensor {
    String name;
    ValueGetter getter;
	
    Sensor(String name, ValueGetter getter) {
    	this.name = name;
    	this.getter = getter;
    }
    
    double getValue() {
    	return getter.getValue();
    }
}
