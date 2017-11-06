package org.usfirst.frc.team5892.robot.oi;

public class GuitarHeroCopilot extends Controller implements Copilot {

	public GuitarHeroCopilot(int port) {
		super(port);
	}

	// the shooter got gutted so i don't care
	@Override
	public boolean shooter() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean shooter_static() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean feeder() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean boiler_align() {
		// TODO Auto-generated method stub
		return false;
	}

	// h*ck yes
	@Override
	public boolean winch_fwd() {
		return stick.getRawButton(0) ||
				stick.getRawButton(1) ||
				stick.getRawButton(2) ||
				stick.getRawButton(3) ||
				stick.getRawButton(4) ||
				stick.getRawButton(5) ||
				//stick.getRawButton(6) || // need a reverse button, just in case
				stick.getRawButton(7) ||
				stick.getRawButton(8) ||
				stick.getRawButton(9) ||
				stick.getPOV(0) > -1 ||
				stick.getRawAxis(4) > -1;
	}

	@Override
	public boolean winch_rev() {
		return stick.getRawButton(6); // back
	}

}
