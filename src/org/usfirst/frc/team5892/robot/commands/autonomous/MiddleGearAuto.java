package org.usfirst.frc.team5892.robot.commands.autonomous;

import org.usfirst.frc.team5892.robot.commands.ActivateFeeder;
import org.usfirst.frc.team5892.robot.commands.PrintSomething;
import org.usfirst.frc.team5892.robot.commands.PushGear;
import org.usfirst.frc.team5892.robot.commands.shooter;
import org.usfirst.frc.team5892.robot.commands.pid.boiler.HEROicBoilerAlignCommand;

import edu.wpi.first.wpilibj.DriverStation;

public class MiddleGearAuto extends EncoderAuto {
	private void sequenceStuff(int dir) {
		addParallel(new shooter(.5));
		addSequential(new PrintSomething(DriverStation.getInstance().getAlliance()));
		addSequential(new EncoderAutonomousDriveLeg(0, 0.3, 0, 525));
		addSequential(new AutonomousWaitLeg(0.5));
		addSequential(new EncoderStraighten(0.4, 2));
		addSequential(new EncoderAutonomousDriveLeg(0, 0.25, 0, 10));
		addSequential(new PushGear(true));
		addSequential(new EncoderAutonomousDriveLeg(0, -0.3, 0, 200));
		
		// Shooting
		addSequential(new EncoderAutonomousDriveLeg(0, 0, dir*-.4, 400));
		//addSequential(new PrintSomething("Pew pew pew"));
		addParallel(new HEROicBoilerAlignCommand());
		addSequential(new ActivateFeeder());
	}

	public MiddleGearAuto() {
		this(DriverStation.getInstance().getAlliance());
	}
	
    public MiddleGearAuto(DriverStation.Alliance alliance) {
    	int dir;
    	switch (alliance) {
		case Red: dir = -1; break;
		case Blue: dir = 1; break;
		default: dir = 0;
		}
		sequenceStuff(dir);
    }
}
