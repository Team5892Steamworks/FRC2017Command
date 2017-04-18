
package org.usfirst.frc.team5892.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5892.robot.commands.ExampleCommand;
import org.usfirst.frc.team5892.robot.commands.autonomous.*;
import org.usfirst.frc.team5892.robot.subsystems.Accelerometer;
import org.usfirst.frc.team5892.robot.subsystems.Agitator;
import org.usfirst.frc.team5892.robot.subsystems.Drive;
import org.usfirst.frc.team5892.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team5892.robot.subsystems.SDOutputSubsystem;
import org.usfirst.frc.team5892.robot.subsystems.Shooter;
//import org.usfirst.frc.team5892.robot.subsystems.ShooterSpeedSubsystem;

public class Robot extends IterativeRobot {

	//public static final boolean INCLUDE_LULZ_AUTONOMI = false;
	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem(); 

	public static OI oi;
	public static RobotMapB map;
	public static Drive drive;
	public static Agitator agitator;
	//public static Shooter shooterSpeedSubsystem;
	public static Accelerometer accelerometer;
	public static SDOutputSubsystem sdout;
	Command autonomousCommand;
	SendableChooser<Command> chooser;

	@Override
	public void robotInit() {
		
		// Initialize RobotMap
		map = new PracticeBot();
		
		// Initialize subsystems
		agitator = new Agitator(); agitator.enable();
		drive = new Drive();
		sdout = new SDOutputSubsystem();
		//shooterSpeedSubsystem = new ShooterSpeedSubsystem();
		//shooterSpeedSubsystem = new Shooter(1.0, 0.0, 0.0, 0.05, 1.0); // p, i, d, period, feedforward
		
		// Initialize OI
		oi = new OI();
		
		// Initialize autonomi <- totally a word
		chooser = new SendableChooser<>();
		chooser.addDefault("Do Nothing", new ExampleCommand());
		chooser.addObject("Test Movement", new DriveForwardsAndSpinAuto());
		/*chooser.addObject("Score a Gear (Sit from Right)", new ScoreGearAuto(false, Position.RIGHT));
		chooser.addObject("Score a Gear (Continue from Right)", new ScoreGearAuto(true, Position.RIGHT));
		chooser.addObject("Score a Gear (Sit from Left)", new ScoreGearAuto(false, Position.LEFT));
		chooser.addObject("Score a Gear (Continue from Left)", new ScoreGearAuto(true, Position.LEFT));*/
		chooser.addObject("Score Gear with Encoders (Sit from Left)", new EncoderScoreGearAuto(false, Position.LEFT));
		chooser.addObject("Score Gear with Encoders (Sit from Right)", new EncoderScoreGearAuto(false, Position.RIGHT));
		chooser.addObject("Score Gear with Encoders (Shoot from Left)", new EncoderScoreGearAuto(true, Position.LEFT));
		chooser.addObject("Score Gear with Encoders (Shoot from Right)", new EncoderScoreGearAuto(true, Position.RIGHT));
		chooser.addObject("Score Gear from Middle (Experimental Ver.)", new EncoderDriveStraightAuto());
		chooser.addObject("Score Gear from Middle", new BoringForwardsAuto());
		chooser.addObject("Measure Encoders", new MeasureEncodersAuto());
		chooser.addObject("Try out vision!!!", new DoubleBoilerAlign());
		chooser.addObject("Gear spike visoin", new VisionGearTestAuto());
		
		chooser.addObject("Vision boiler shoote test", new VisionShootTestAuto());
//		chooser.addObject("Test Encoders", new EncoderAuto());
		/*if (INCLUDE_LULZ_AUTONOMI) {
			chooser.addObject("360 No Scope (Lulz)", new _360NoScopeAuto());
		}*/
		SmartDashboard.putData("Autonomous mode!!!!!!!!!", chooser);
		
		// Initialize CameraServer
		UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture(0);
        camera1.setResolution(160, 120);
        camera1.setExposureManual(1);
        
        /*UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture(1);
        camera2.setResolution(160, 120);*/

        CameraServer.getInstance().getVideo();
        CameraServer.getInstance().putVideo("Blur", 160, 120);
		
		//chooser.addObject("My Auto", new MyAutoCommand());
        //SmartDashboard.putData(Scheduler.getInstance());
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
		drive.set_base(1);
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
		drive.set_base(1);
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
