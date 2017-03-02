package org.usfirst.frc.team5892.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5892.robot.commands.ActivateWinch;
import org.usfirst.frc.team5892.robot.commands.DisableAgitator;
import org.usfirst.frc.team5892.robot.commands.ExampleCommand;

import org.usfirst.frc.team5892.robot.commands.ReverseAgitator;
import org.usfirst.frc.team5892.robot.commands.ShootBall;
import org.usfirst.frc.team5892.robot.commands.intake;


import org.usfirst.frc.team5892.robot.commands.intake;

import org.usfirst.frc.team5892.robot.commands.shooter;

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
	public Button agitator_da = new JoystickButton(copilot, 4);
	
	public Button winch_pos = new JoystickButton(copilot, 5);
	public Button winch_neg = new JoystickButton(copilot, 6);
	
	//public Button agitate = new JoystickButton(copilot, 1);
	
	public OI(){
		//shooter.whileActive(new shooter());
		
		//shooter.whileActive(new PControlShoot());
		
		
		intake.whileActive(new intake());
		
		agitator_rv.whenPressed(new ReverseAgitator());
		agitator_da.whileActive(new DisableAgitator());
		
		winch_pos.whileActive(new ActivateWinch(0.2));
		winch_neg.whileActive(new ActivateWinch(-.2));
		
/*		shooter.whileHeld(new shooter());

		agitate.whileHeld(new agitator());

		intake.whileActive(new intake()); */


	}
}