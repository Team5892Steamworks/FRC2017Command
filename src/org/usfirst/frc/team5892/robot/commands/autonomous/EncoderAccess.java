package org.usfirst.frc.team5892.robot.commands.autonomous;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.Counter;

public interface EncoderAccess {
	public static Counter leftWheel = new Counter(Robot.map.encoderLeft);
	public static Counter rightWheel = new Counter(Robot.map.encoderRight);
}