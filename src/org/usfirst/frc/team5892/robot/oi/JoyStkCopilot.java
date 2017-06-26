package org.usfirst.frc.team5892.robot.oi;

public class JoyStkCopilot extends Controller implements Copilot {
    public JoyStkCopilot(int port) {
		super(port);
	}

	@Override
	public boolean shooter() {
		return stick.getRawButton(2);
	}
	
	@Override
	public boolean shooter_lo() {
		return stick.getRawButton(4);
	}

	@Override
	public boolean feeder() {
		return stick.getPOV(0) >= 0;
	}

	@Override
	public boolean winch_fwd() {
		return stick.getRawButton(5);
	}

	@Override
	public boolean winch_rev() {
		return stick.getRawButton(6);
	}

}
