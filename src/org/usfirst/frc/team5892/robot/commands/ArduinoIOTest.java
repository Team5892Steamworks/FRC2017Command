package org.usfirst.frc.team5892.robot.commands;

import edu.wpi.first.wpilibj.SerialPort;
//import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
@Deprecated
public class ArduinoIOTest extends Command {
	static SerialPort serial/* = new SerialPort(9600, SerialPort.Port.kOnboard)*/;
	public ArduinoIOTest() {
		// Use requires() here to declare subsystem dependencies
		//requires(Robot.exampleSubsystem);
		
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		serial.write(new byte[]{2}, 1);
		//serial.flush();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		serial.write(new byte[]{1}, 1);
		//serial.flush();
	}
}
