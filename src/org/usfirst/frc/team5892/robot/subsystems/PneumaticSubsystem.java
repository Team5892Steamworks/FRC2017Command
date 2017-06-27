package org.usfirst.frc.team5892.robot.subsystems;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PneumaticSubsystem extends Subsystem {
    
	public Compressor compressor;

    public Solenoid gearPush;
	
	public PneumaticSubsystem(int compressorPort) {
		compressor = new Compressor(compressorPort);
        compressor.setClosedLoopControl(true);
        gearPush = new Solenoid(Robot.map.gearPushPort);
	}
	
	@Override protected void initDefaultCommand() {}

}
