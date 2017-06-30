package org.usfirst.frc.team5892.robot.commands;

import org.usfirst.frc.team5892.robot.subsystems.LightControl;

import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SerialWrite extends InstantCommand {
    
	public SerialWrite() {
		SmartDashboard.putNumber("Serial Output", 0x10);
		setRunWhenDisabled(true);
	}
	
	@Override
	protected void execute() {
		LightControl.writeSingleByte((byte) SmartDashboard.getNumber("Serial Output", 0x10));
	}

}
