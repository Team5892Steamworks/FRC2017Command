package org.usfirst.frc.team5892.robot.commands;


import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.RobotMapB;

import edu.wpi.first.wpilibj.command.Command;


public class mecanumDrive extends Command {
	
	public mecanumDrive() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
		
		
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}
	
	/*private int port(RobotMapB.ControlSetup config) {
		if (config == RobotMapB.ControlSetup.xAxis) return 0;
		else if (config == RobotMapB.ControlSetup.yAxis) return 1;
		else return 4;
	}
	
	private int inv(RobotMapB.ControlSetup config) {
		return config.inverted ? -1 : 1;
	}*/

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		/*double base = Robot.drive.get_base();
		SmartDashboard.putNumber("Drive Base Multiplier", base);*/
		double mult = Robot.oi.pilot.loSpeed() ? 0.65 : 1;
		// TODO Reverse 4 and 0 before competition and un-negate
		//Robot.drive.mecanumDrive(-Robot.oi.pilot.getRawAxis(4)*mult, -Robot.oi.pilot.getRawAxis(0)*mult, Robot.oi.pilot.getRawAxis(1)*mult);
		Robot.drive.mecanumDrive(Robot.oi.pilot.xAxis(), Robot.oi.pilot.yAxis(), Robot.oi.pilot.twist());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}

}
