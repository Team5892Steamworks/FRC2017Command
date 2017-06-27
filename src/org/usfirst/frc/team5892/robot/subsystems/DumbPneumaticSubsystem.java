package org.usfirst.frc.team5892.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

@Deprecated
public class DumbPneumaticSubsystem extends Subsystem {
    
	public Compressor compressor;
	public int numPorts;
	public Solenoid[] solenoids;
	
	public DumbPneumaticSubsystem(int compressorPort, int numPorts) {
		compressor = new Compressor(compressorPort);
		compressor.setClosedLoopControl(true);
		solenoids = new Solenoid[numPorts];
	}
	
	@Override protected void initDefaultCommand() {}
	
	public void actuateSolenoid(int port, boolean state) {
		if (port < 0 || port > numPorts) return;
		if (solenoids[port] == null) solenoids[port] = new Solenoid(port);
		solenoids[port].set(state);
	}
	
	public void stopCompressor() {
		compressor.stop();
	}
	
	public void resetCompressor() {
		compressor.start();
	}

}
