package org.usfirst.frc.team5892.robot.subsystems;

//import org.usfirst.frc.team5892.HEROcode.inline.InlineTrigger;
//import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.I2C;
//import edu.wpi.first.wpilibj.SerialPort;
//import edu.wpi.first.wpilibj.SerialPort.Port;
//import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.command.Subsystem;

/// Next year: just use freaking NetworkTables.
/// We're sticking a Pi on anyway.
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
	
	// Rainbow codes
	public static final byte yesRainbow =   0x17; // (=> 0x74)
	public static final byte noRainbow =    0x18; // (=> 0xee | 0x0e) for some reason
    
	//private static I2C i2c = new I2C(I2C.Port.kOnboard, 5);
	/*private DriverStation.Alliance alliance;
	private boolean vision = false;
	private boolean endgame = false;
	private boolean rainbow = false;*/
	
	public LightControl() {
		/*new InlineTrigger(() -> DriverStation.getInstance().isOperatorControl() && 
				DriverStation.getInstance().getMatchTime() < 30).whenActive(new InstantCommand() {
			@Override protected void execute() {Robot.lights.setEndGame(true);}
		});*/
	}
	
	@Override
	protected void initDefaultCommand() {
		//setDefaultCommand(new I2CWrite(this));
	}
	
	public static void writeSingleByte(byte b) {
		//i2c.transaction(new byte[]{b}, 1, null, 0);
	}
	
	public void setAlliance(DriverStation.Alliance alliance) {
		/*switch (alliance) {
		case Red: writeSingleByte(redAlliance); break;
		case Blue: writeSingleByte(blueAlliance); break;
		default: writeSingleByte(badAlliance);
		}*/
	}
	
	public void setVision(boolean isVision) {
		//writeSingleByte(isVision ? yesVision : noVision);
	}
	
	public void setEndGame(boolean isEnd) {
		//writeSingleByte(isEnd ? yesEndgame : noEndgame);
	}
	
	public void setRainbow(boolean isRainbow) {
		//writeSingleByte(isRainbow ? yesRainbow : noRainbow);
	}
	
	/*private class I2CWrite extends Command {
		
		LightControl parent;
		
		I2CWrite(LightControl parent) {
			this.parent = parent;
			requires(parent);
		}
		
		@Override
		protected void execute() {
			byte[] out = new byte[4];
			
			switch (parent.alliance) {
			case Red: out[0] = redAlliance; break;
			case Blue: out[0] = blueAlliance; break;
			default: out[0] = badAlliance;
			}
			
			out[1] = parent.vision ? yesVision : noVision;
			
			out[2] = parent.endgame ? yesEndgame : noEndgame;
			
			out[3] = parent.rainbow ? yesRainbow : noRainbow;
			
			//i2c.transaction(out, 4, null, 0);
		}
		
		@Override
		protected boolean isFinished() {
			return false;
		}
	}*/

}
