package org.usfirst.frc.team5892.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public abstract class EncoderAuto extends CommandGroup {
	
	static final double distToBaseline = linearInch(75.3);
	static final double ratio = 5.25 / 8;
	
	protected static final double linearInch(double inches) {
		return oldToNew(15 * inches / Math.PI);
	}
	
	protected static final double linearFoot(double feet) {
		return oldToNew(180 * feet / Math.PI);
	}
	
	protected static final double oldToNew(double oldDist) {
		return oldDist * ratio;
	}

}
