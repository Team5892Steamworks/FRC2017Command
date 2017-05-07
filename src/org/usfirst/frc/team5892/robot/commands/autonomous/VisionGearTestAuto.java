package org.usfirst.frc.team5892.robot.commands.autonomous;

import org.usfirst.frc.team5892.robot.commands.pid.gear.GearVisionPIDCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class VisionGearTestAuto extends CommandGroup{
    public VisionGearTestAuto() {
    	addSequential(new GearVisionPIDCommand());
    	addSequential(new AutonomousDriveLeg(0, 0.2, 0, 0.75));
    }
}
