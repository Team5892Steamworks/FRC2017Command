package org.usfirst.frc.team5892.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

@Deprecated
public class ParallelInlineCommandGroup extends CommandGroup {
    public ParallelInlineCommandGroup(Entry... entries) {
    	for (Entry e : entries) {
    		if (e.parallel) addParallel(e.command);
    		else addSequential(e.command);
    	}
    }
    
    public class Entry {
    	Command command;
    	boolean parallel;
    	
    	public Entry(Command command, boolean parallel) {
    		this.command = command;
    		this.parallel = parallel;
    	}
    }
}
