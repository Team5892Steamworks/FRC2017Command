package org.usfirst.frc.team5892.HEROcode.sensormap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An array of sensors used by your robot. Helpful for organization, and by defining {@link getAllSensors}, you can automatically have all of them put on the SmartDashboard.
 * 
 * @author Kai Page
 */
public abstract class SensorArray extends Subsystem {
    
	SensorOutputCommand soc;
	
	@Override
	protected void initDefaultCommand() {
		soc = new SensorOutputCommand(this);
        setDefaultCommand(soc);
	}
	
	public abstract Sensor[] getAllSensors();

}
