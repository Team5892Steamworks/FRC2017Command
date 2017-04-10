package org.usfirst.frc.team5892.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5892.robot.commands.*;
import org.usfirst.frc.team5892.robot.triggers.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	public Joystick pilot = new Joystick(1);
	public Joystick copilot = new Joystick(2);
	
	public Button intake = new JoystickButton(pilot, 6);
	public Button shooter = new JoystickButton(copilot, 2);
	public Button agitator_rv = new JoystickButton(copilot, 3);
	public Trigger agitator_da = new AnalogAxisTrigger(copilot, 3);
	
	public Button winch_rev = new JoystickButton(copilot, 5);
	public Button winch_fwd = new JoystickButton(copilot, 6);
	
	public Trigger dpad_up = new POVTrigger(copilot, 0);
	public Trigger intake_cp = new AnalogAxisTrigger(copilot, 2);
	//public Trigger light = new AnalogAxisTrigger(copilot, 3);
	
	public Trigger sec30 = new MatchTimeTrigger(30);
	public Trigger sec15 = new MatchTimeTrigger(15);
	
	//public Trigger batt_low = new BatteryVoltageTrigger(7.2);
	
	//public Button agitate = new JoystickButton(copilot, 1);
	
	public OI(){
		shooter.whileActive(new shooter());
		
		//shooter.whileActive(new PControlShoot());
		
		//shooter.whileActive(new ShootBall(40000));
		//intake.whileActive(new intake());
		intake_cp.whileActive(new intake());
		
		//agitator_rv.whenPressed(new ReverseAgitator());
		agitator_da.whileActive(new EnableAgitator());
		
		winch_rev.whileActive(new ActivateWinch(-1));
		winch_fwd.whileActive(new ActivateWinch(1));
		
		sec30.whenActive(new RumbleController(0.2));
		sec15.whenActive(new MultRumble(2));
		
		//light.whileActive(new ActivateFlashlight());
		//batt_low.whileActive(new DecreaseDriveBase(0.02));
		
/*		shooter.whileHeld(new shooter());

		agitate.whileHeld(new agitator());

		intake.whileActive(new intake()); */


	}
}