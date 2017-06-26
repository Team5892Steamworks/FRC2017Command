package org.usfirst.frc.team5892.robot.oi;

public class FlightStkCopilot extends Controller implements Copilot {
    public FlightStkCopilot(int port) {
		super(port);
	}

	@Override
	public boolean shooter() {
		return stick.getRawButton(1);
	}

	@Override
	public boolean shooter_lo() {
		return stick.getRawAxis(3) < -.7;
	}

	@Override
	public boolean feeder() {
		return stick.getRawAxis(3) < -.7 && !stick.getRawButton(11);
	}

	@Override
	public boolean winch_fwd() {
		return stick.getRawButton(3);
	}

	@Override
	public boolean winch_rev() {
		return stick.getRawButton(4);
	}

}
