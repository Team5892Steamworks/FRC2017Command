package org.usfirst.frc.team5892.robot.subsystems;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PneumaticSubsystem extends Subsystem {
    
	private final class SDOutput extends Command {
		
		SDOutput(PneumaticSubsystem parent) {
			setRunWhenDisabled(true);
			setInterruptible(false);
			requires(parent);
		}
		
		@Override
		protected void execute() {
			SmartDashboard.putBoolean("Compressor", compressor.enabled());
		}

		@Override
		protected boolean isFinished() {
			return false;
		}
	}

	public Compressor compressor;

    public Solenoid gearPush;
	
	public PneumaticSubsystem(int compressorPort) {
		compressor = new Compressor(compressorPort);
        compressor.setClosedLoopControl(true);
        gearPush = new Solenoid(Robot.map.gearPushPort);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new SDOutput(this));
	}

}
