package org.usfirst.frc.team5892.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

@Deprecated
public class InlineCommandGroup extends CommandGroup {
    public InlineCommandGroup(Command[] commands) {
    	for (Command cmd : commands) {
    		addSequential(cmd);
    	}
    }
}
