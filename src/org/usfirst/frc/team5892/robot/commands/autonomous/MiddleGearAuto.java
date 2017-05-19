package org.usfirst.frc.team5892.robot.commands.autonomous;

import org.usfirst.frc.team5892.HEROcode.pid.HEROicPIDController;
import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MiddleGearAuto extends Command {
	
	Controller control;
	
	public MiddleGearAuto() {
		control = new Controller();
	}
	
	@Override
	protected void initialize() {
		control.enable();
	}

	@Override
	protected boolean isFinished() {
		return Robot.sensors.encoderLeft.getValue() > 700;
	}
	
	@Override
	protected void end() {
		control.disable();
	}
	
	private class Controller extends HEROicPIDController {
		static final double Kp = 0.4;
		static final double Ki = 0.5;
		static final double Kd = 0.3;
		
		Controller() {
			super(Kp, Ki, Kd);
			setSetpoint(0);
		}

		@Override
		public double getPIDInput() {
			double value = Robot.sensors.encoderLeft.getValue() - Robot.sensors.encoderRight.getValue();
			SmartDashboard.putNumber("MIddle AUto PID Inpiut", value);
			return value;
		}

		@Override
		public void usePIDOutput(double output) {
			Robot.drive.mecanumDrive(0, 0.3, output);
		}
	}

}
