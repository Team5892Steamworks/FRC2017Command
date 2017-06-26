package org.usfirst.frc.team5892.robot.oi;

public class FlightStkPilot extends Controller implements Pilot {
    public FlightStkPilot(int port) {
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
		return stick.getRawAxis(2);
	}

	@Override
	public boolean loSpeed() {
		return stick.getRawButton(2);
	}
	
	@Override
	public boolean gearPneum() {
		return stick.getRawButton(1);
	}

}
