package org.usfirst.frc.team5892.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5892.robot.Robot;
import org.usfirst.frc.team5892.robot.RobotMapB;

/**
 *
 */
public class AutonomousDriveLeg extends Command {
	
	double xAxis;
	double yAxis;
	double twist;
	double duration;
	
	public AutonomousDriveLeg(double xAxis_, double yAxis_, double twist_, double duration_) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
		xAxis = -xAxis_;
		yAxis = -yAxis_;
		twist = -twist_;
        duration = duration_;
	}
    
	private int inv(RobotMapB.ControlSetup config) {
		return config.inverted ? -1 : 1;
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.drive.mecanumDrive(xAxis * inv(Robot.map.controlSetup[0]),
                                 yAxis * inv(Robot.map.controlSetup[1]),
                                 twist * inv(Robot.map.controlSetup[2]));
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.drive.mecanumDrive(xAxis * inv(Robot.map.controlSetup[0]),
                                 yAxis * inv(Robot.map.controlSetup[1]),
                                 twist * inv(Robot.map.controlSetup[2]));
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return timeSinceInitialized() >= duration;
	}

	// Called once after isFinished returns true
	@Override
	protected final void end() {
		Robot.drive.mecanumDrive(0, 0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected final void interrupted() {
	}
}