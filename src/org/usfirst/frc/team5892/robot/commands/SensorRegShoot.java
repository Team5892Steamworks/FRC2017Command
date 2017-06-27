package org.usfirst.frc.team5892.robot.commands;

import org.usfirst.frc.team5892.robot.commands.pid.boiler.BoilerVisionPIDCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

@Deprecated
public class SensorRegShoot extends CommandGroup {
    public SensorRegShoot() {
    	addParallel(new BoilerVisionPIDCommand());
    	addParallel(new UltrasonicShoot());
    }
}
