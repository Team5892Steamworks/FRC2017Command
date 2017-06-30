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
	public boolean shooter_static() {
		return stick.getRawButton(4);
	}

	@Override
	public boolean feeder() {
		return stick.getPOV(0) >= 0;
	}

	@Override
	public boolean boiler_align() {
		return stick.getRawButton(3);
	}

	@Override
	public boolean winch_fwd() {
		return stick.getRawAxis(3) > 0.7;
	}

	@Override
	public boolean winch_rev() {
		return stick.getRawAxis(2) > 0.7;
	}

}
