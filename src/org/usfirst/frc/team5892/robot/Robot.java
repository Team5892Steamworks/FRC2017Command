
package org.usfirst.frc.team5892.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5892.robot.commands.ExampleCommand;
import org.usfirst.frc.team5892.robot.commands.autonomous.DriveForwardsAndSpinAuto;
import org.usfirst.frc.team5892.robot.subsystems.Agitator;
import org.usfirst.frc.team5892.robot.subsystems.Drive;
import org.usfirst.frc.team5892.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team5892.robot.subsystems.ShooterPControlSubsystem;
import org.usfirst.frc.team5892.robot.subsystems.ShooterSpeedSubsystem;
//import org.usfirst.frc.team5892.robot.subsystems.ShooterSpeedSubsystem;

public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem(); 

	public static OI oi;
	public static RobotMap map;
	public static Drive drive;
	public static Agitator agitator;
	public static ShooterSpeedSubsystem shooterSpeedSubsystem;
	public static ShooterPControlSubsystem shooterPControl;
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	@Override
	public void robotInit() {
		
		// Initialize RobotMap
		map = new RobotMap();
		
		// Initialize subystems
		agitator = new Agitator(); agitator.enable();
		drive = new Drive();
		//shooterSpeedSubsystem = new ShooterSpeedSubsystem();
		shooterPControl = new ShooterPControlSubsystem();
		
		// Initialize OI
		oi = new OI();
		
		// Initialize autonomouses <- totally a word
		chooser.addDefault("Default Auto", new ExampleCommand());
		chooser.addObject("Drive Forwards and Spin", new DriveForwardsAndSpinAuto());
		SmartDashboard.putData("Auto mode", chooser);
		
		
		//chooser.addObject("My Auto", new MyAutoCommand());
	}
	@Override
	public void disabledInit() {
	}
	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
	@Override
	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
