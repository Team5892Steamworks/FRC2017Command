package org.usfirst.frc.team5892.robot.oi;

public class JoyStkPilot extends Controller implements Pilot {
    public JoyStkPilot(int port) {
		super(port);
	}

	@Override
	public double xAxis() {
		return stick.getRawAxis(0);
	}

	@Override
	public double yAxis() {
		return stick.getRawAxis(1);
	}

	@Override
	public double twist() {
		return stick.getRawAxis(4);
	}

	@Override
	public boolean loSpeed() {
		return stick.getRawAxis(2) > 0.7;
	}
	
	@Override
	public boolean gearPneum() {
		return stick.getRawAxis(3) > 0.7;
	}

}
