package org.usfirst.frc.team5892.robot.commands.autonomous;

import org.usfirst.frc.team5892.robot.Robot;

import edu.wpi.first.wpilibj.Counter;

public class EncoderAccess {
	private static final Counter leftWheel = new Counter(Robot.map.encoderLeft);
	private static final Counter rightWheel = new Counter(Robot.map.encoderRight);
	
	static double getLeft() {
		return leftWheel.get();
	}
	
	static double getRight() {
		return rightWheel.get();
	}
	
	static void resetLeft() {
		leftWheel.reset();
	}
	
	static void resetRight() {
		rightWheel.reset();
	}
	
	static void resetBoth() {
		leftWheel.reset();
		rightWheel.reset();
	}
}