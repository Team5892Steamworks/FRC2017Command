package org.usfirst.frc.team5892.robot.subsystems;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
@Deprecated
public class SDOutputSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	class SDOutputCommand extends Command {
		
		@Override
		protected void execute() {
			/*SmartDashboard.putNumber("Left Encoder", EncoderAutonomousDriveLeg.leftWheel.getDistance());
			SmartDashboard.putNumber("Right Encoder", EncoderAutonomousDriveLeg.rightWheel.getDistance());*/
		}

		@Override
		protected boolean isFinished() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
}
