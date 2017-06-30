
package org.usfirst.frc.team5892.robot;

import org.usfirst.frc.team5892.HEROcode.inline.ICGEntry;
import org.usfirst.frc.team5892.HEROcode.inline.InlineCommandGroup;
import org.usfirst.frc.team5892.robot.commands.*;
import org.usfirst.frc.team5892.robot.commands.autonomous.*;
import org.usfirst.frc.team5892.robot.commands.pid.gear.HEROicGearAlignCommand;
import org.usfirst.frc.team5892.robot.oi.*;
import org.usfirst.frc.team5892.robot.subsystems.*;
import org.usfirst.frc.team5892.robot.subsystems.sensors.HEROicSensorArray;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import com.kauailabs.navx.frc.AHRS;
//import org.usfirst.frc.team5892.robot.subsystems.ShooterSpeedSubsystem;

public class Robot extends IterativeRobot {

	//public static final boolean INCLUDE_LULZ_AUTONOMI = false;
	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem(); 

	public static org.usfirst.frc.team5892.robot.oi.OI oi;
	public static RobotMapB map;
	public static Drive drive;
	//public static Agitator agitator_s;
	//public static Shooter shooterSpeedSubsystem;
	public static Accelerometer accelerometer;
	public static HEROicSensorArray sensors;
	//public static SDOutputSubsystem sdout;
	Command autonomousCommand;
	SendableChooser<Command> chooser;
	
	public static Victor frontleft;
	public static Victor backleft;
	public static Victor frontright;
	public static Victor backright;
	
	public static Victor feeder;
	public static Victor flywheel;
	public static Victor winch;
	public static Victor agitator;
	public static Victor intake;
	
	public static PneumaticSubsystem pneumatics;
	public static LightControl lights; // i was going to call this "winkyblinky" but decided against it
	
	//public static AHRS ahrs;
	
	public static SendableChooser<Position> posChooser;
	public static SendableChooser<Command> afterChooser;

	@Override
	public void robotInit() {
		
		// Initialize RobotMap
		map = new CompetitionBot();
		
		// Initialize NavX
		//ahrs = new AHRS(SPI.Port.kMXP);
		
		// Initialize actuators
		frontleft = new Victor(map.driveTrain[0].port); frontleft.setInverted(map.driveTrain[0].inverted);
		backleft = new Victor(map.driveTrain[1].port); backleft.setInverted(map.driveTrain[1].inverted);
		frontright = new Victor(map.driveTrain[2].port); frontright.setInverted(map.driveTrain[2].inverted);
		backright = new Victor(map.driveTrain[3].port); backright.setInverted(map.driveTrain[3].inverted);
		
		feeder = new Victor(map.feeder.port); feeder.setInverted(map.feeder.inverted);
		flywheel = new Victor(map.flywheel.port); flywheel.setInverted(map.flywheel.inverted);
		winch = new Victor(map.winch.port); winch.setInverted(map.winch.inverted);
		agitator = new Victor(map.agitator.port); agitator.setInverted(map.agitator.inverted);
		intake = new Victor(map.intake.port); intake.setInverted(map.intake.inverted);
		
		pneumatics = new PneumaticSubsystem(0);
		
		// Initialize subsystems
		//agitator_s = new Agitator();
		drive = new Drive();
		sensors = new HEROicSensorArray();
		//sdout = new SDOutputSubsystem();
		//shooterSpeedSubsystem = new ShooterSpeedSubsystem();
		//shooterSpeedSubsystem = new Shooter(1.0, 0.0, 0.0, 0.05, 1.0); // p, i, d, period, feedforward
		lights = new LightControl();
		
		// Initialize OI
		oi = new org.usfirst.frc.team5892.robot.oi.OI(new JoyStkPilot(1), new JoyStkCopilot(2));
		
		// Initialize autonomi <- totally a word
		chooser = new SendableChooser<>();
		chooser.addDefault("Do Nothing", new ExampleCommand());
		/*chooser.addObject("Score a Gear (Sit from Right)", new ScoreGearAuto(false, Position.RIGHT));
		chooser.addObject("Score a Gear (Continue from Right)", new ScoreGearAuto(true, Position.RIGHT));
		chooser.addObject("Score a Gear (Sit from Left)", new ScoreGearAuto(false, Position.LEFT));
		chooser.addObject("Score a Gear (Continue from Left)", new ScoreGearAuto(true, Position.LEFT));*/
		chooser.addObject("Score Gear with Encoders (Sit from Left)", new EncoderScoreGearAuto(false, Position.LEFT));
		chooser.addObject("Score Gear with Encoders (Sit from Right)", new EncoderScoreGearAuto(false, Position.RIGHT));
		chooser.addObject("Score Gear with Encoders (Shoot from Left)", new EncoderScoreGearAuto(true, Position.LEFT));
		chooser.addObject("Score Gear with Encoders (Shoot from Right)", new EncoderScoreGearAuto(true, Position.RIGHT));
		chooser.addObject("Score Gear from Middle (Red Alliance)", new MiddleGearAuto(DriverStation.Alliance.Red));
		chooser.addObject("Score Gear from Middle (Blue Alliance)", new MiddleGearAuto(DriverStation.Alliance.Blue));
//		chooser.addObject("Test Encoders", new EncoderAuto());
		/*if (INCLUDE_LULZ_AUTONOMI) {
			chooser.addObject("360 No Scope (Lulz)", new _360NoScopeAuto());
		}*/
		SmartDashboard.putData("Autonomous mode!!!!!!!!!!!!!!!!!!!", chooser);
		
		/*
		posChooser.addDefault("Left", Position.LEFT);
		posChooser.addObject("Middle", Position.MIDDLE);
		posChooser.addObject("Right", Position.RIGHT);
		SmartDashboard.putData("Auto position", posChooser);
		
		afterChooser.addDefault("Do nothing", new ExampleCommand());
		SmartDashboard.putData("After auto", afterChooser);
		*/
		
		// Initialize CameraServer
		UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture(0);
        camera1.setResolution(160, 120);
        camera1.setExposureManual(1);
        
        UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture(1);
        camera2.setResolution(80, 60);
        camera2.setExposureManual(1);

        CameraServer.getInstance().getVideo();
        CameraServer.getInstance().putVideo("Blur", 160, 120);
		
		//chooser.addObject("My Auto", new MyAutoCommand());
        //SmartDashboard.putData(Scheduler.getInstance());
        
        // Initialize SmartDashboard commands
        SmartDashboard.putData("Emergency Winch Button", new ActivateWinch(1));
        
	}
	@Override
	public void disabledInit() {
		lights.setVision(false);
		lights.setEndGame(false);
		lights.setRainbow(false);
	}
	@Override
	public void disabledPeriodic() {
		lights.setAlliance(DriverStation.getInstance().getAlliance());
		Scheduler.getInstance().run();
	}
	@Override
	public void autonomousInit() {
		drive.set_base(1);
		lights.setVision(false);
		lights.setEndGame(false);
		lights.setRainbow(false);
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
		new ReverseAgitator().start();
		lights.setVision(false);
		lights.setEndGame(false);
		lights.setRainbow(false);
	}
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	@Override
	public void testInit() {
		lights.setVision(false);
		lights.setEndGame(false);
		lights.setRainbow(false);
	}
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
