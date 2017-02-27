package org.usfirst.frc.team5892.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5892.robot.commands.ExampleCommand;
//import org.usfirst.frc.team5892.robot.commands.agitator;
import org.usfirst.frc.team5892.robot.commands.intake;


//import org.usfirst.frc.team5892.robot.commands.agitator;

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
	public Button X = new JoystickButton(pilot,1),
				  A = new JoystickButton(pilot,2),
				  B = new JoystickButton(pilot,3),
				  Y = new JoystickButton(pilot,4),
				  LB = new JoystickButton(pilot,5),
				  RB = new JoystickButton(pilot,6),
			      LT = new JoystickButton(pilot,7),
			      RT = new JoystickButton(pilot,8),
				  BACK = new JoystickButton(pilot,9),
				  START = new JoystickButton(pilot,10);
		
	public Joystick copilot = new Joystick(2);
	public Button cX = new JoystickButton(copilot,1),
					cA = new JoystickButton(copilot,2),
					cB = new JoystickButton(copilot,3),
					cY = new JoystickButton(copilot,4),
					cLB = new JoystickButton(copilot,5),
					cRB = new JoystickButton(copilot,6),
					cLT = new JoystickButton(copilot,7),
					cRT = new JoystickButton(copilot,8),
					cBACK = new JoystickButton(copilot,9),
					cSTART = new JoystickButton(copilot,10);
			
	
	public Button intake = new JoystickButton(pilot, 6);
	public Button shooter = new JoystickButton(copilot, 2);
	
	//Going to start renaming our button layout
	public Button a = new JoystickButton(pilot, 6),
			b = new JoystickButton(copilot, 2);
	
	
	//public Button agitate = new JoystickButton(copilot, 1);
	
	public OI(){
		shooter.whileActive(new shooter());
		
		intake.whileActive(new intake());
		
	shooter.whileHeld(new shooter());

		//agitate.whileHeld(new agitator());

		intake.whileActive(new intake()); 


	}
}