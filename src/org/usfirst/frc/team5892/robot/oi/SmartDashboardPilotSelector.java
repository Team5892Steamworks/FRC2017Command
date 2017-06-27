package org.usfirst.frc.team5892.robot.oi;

import org.usfirst.frc.team5892.HEROcode.inline.InlineTrigger;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardPilotSelector implements Pilot {
    
	private SendableChooser<Pilot> chooser;
	private Pilot selected;
	
	public SmartDashboardPilotSelector() {
		chooser = new SendableChooser<>();
		chooser.addDefault("Joystick", new JoyStkPilot(1));
		chooser.addObject("Single Flight Stick", new FlightStkPilot(3));
		chooser.addObject("Dual Flight Stick", new DualFlightStkPilot(4, 3));
		SmartDashboard.putData("Pilot Selector", chooser);
		selected = chooser.getSelected();
		new InlineTrigger(() -> DriverStation.getInstance().isEnabled()).whenActive(new SetSelected(this));
	}
	
	@Override
	public double xAxis() {
		return selected.xAxis();
	}

	@Override
	public double yAxis() {
		return selected.yAxis();
	}

	@Override
	public double twist() {
		return selected.twist();
	}

	@Override
	public boolean loSpeed() {
		return selected.loSpeed();
	}

	@Override
	public boolean gearPneum() {
		return selected.gearPneum();
	}
	
	private class SetSelected extends Command {
		
		SmartDashboardPilotSelector parent;
        
		SetSelected(SmartDashboardPilotSelector parent) {
			this.parent = parent;
		}
		
		@Override
		protected void initialize() {
			parent.selected = parent.chooser.getSelected();
		}
		
		@Override protected boolean isFinished() { return true; }
		
	}

}
