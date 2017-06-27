package org.usfirst.frc.team5892.robot.oi;

public class FlightStkCopilot extends Controller implements Copilot {
    public FlightStkCopilot(int port) {
		super(port);
	}

	@Override
	public boolean shooter() {
		return stick.getRawButton(4);
	}

	@Override
	public boolean shooter_lo() {
		return stick.getRawButton(5);
	}

	@Override
	public boolean feeder() {
		return stick.getRawButton(3);
	}

	@Override
	public boolean winch_fwd() {
		return stick.getPOV(0) == 0;
	}

	@Override
	public boolean winch_rev() {
		return stick.getPOV(0) == 180;
	}

}
