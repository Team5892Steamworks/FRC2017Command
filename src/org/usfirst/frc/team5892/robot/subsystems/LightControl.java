package org.usfirst.frc.team5892.robot.subsystems;

import org.usfirst.frc.team5892.HEROcode.inline.InlineTrigger;
import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LightControl extends Subsystem {
	
	// Alliance codes
	public static final byte redAlliance =  0x11; // (=> 0x77)
	public static final byte blueAlliance = 0x12; // (=> 0x3b)
	public static final byte badAlliance =  0x1f; // (=> 0x70)
	
	// Vision codes
	public static final byte yesVision =    0x13; // (=> 0x76)
	public static final byte noVision =     0x14; // (=> 0x1d)
	
	// Endgame codes
	public static final byte yesEndgame =   0x15; // (=> 0x75)
	public static final byte noEndgame =    0x16; // (=> 0x3a)
    
	private static SerialPort serial = new SerialPort(9600, Port.kOnboard);
	
	public LightControl() {
		new InlineTrigger(() -> DriverStation.getInstance().isOperatorControl() && 
				DriverStation.getInstance().getMatchTime() < 30).whenActive(new InstantCommand() {
			@Override protected void execute() {Robot.lights.setEndGame(true);}
		});
	}
	
	@Override protected void initDefaultCommand() {}
	
	public static void writeSingleByte(byte b) {
		serial.write(new byte[]{b}, 1);
	}
	
	public void setAlliance(DriverStation.Alliance alliance) {
		switch (alliance) {
		case Red: writeSingleByte(redAlliance); return;
		case Blue: writeSingleByte(blueAlliance); return;
		default: writeSingleByte(badAlliance);
		}
	}
	
	public void setVision(boolean isVision) {
		writeSingleByte(isVision ? yesVision : noVision);
	}
	
	public void setEndGame(boolean isEnd) {
		writeSingleByte(isEnd ? yesEndgame : noEndgame);
	}

}
