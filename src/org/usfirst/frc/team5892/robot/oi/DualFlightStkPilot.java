package org.usfirst.frc.team5892.robot.oi;

import edu.wpi.first.wpilibj.Joystick;

public class DualFlightStkPilot implements Pilot {
    
	protected Joystick stick_l;
	protected Joystick stick_r;
	
	public DualFlightStkPilot(int port_l, int port_r) {
		stick_l = new Joystick(port_l);
		stick_r = new Joystick(port_r);
	}
	
	@Override
	public double xAxis() {
		return stick_l.getRawAxis(0);
	}

	@Override
	public double yAxis() {
		return stick_l.getRawAxis(1);
	}

	@Override
	public double twist() {
		return stick_r.getRawAxis(0);
	}

	@Override
	public boolean loSpeed() {
		return stick_l.getRawButton(2) || stick_r.getRawButton(2);
	}
	
	@Override
	public boolean gearPneum() {
		return stick_l.getRawButton(1) || stick_r.getRawButton(1);
	}

}
