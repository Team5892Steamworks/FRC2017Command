package org.usfirst.frc.team5892.robot.triggers;

import edu.wpi.first.wpilibj.buttons.Trigger;

public class TriggerConglomerator extends Trigger {

	Trigger[] triggers;
	Operator operator;

	public TriggerConglomerator(Trigger[] triggers_, Operator operator_) {
		triggers = triggers_;
		operator = operator_;
	}

	@Override
	public boolean get() {
		switch (operator) {
		case AND:
			for (Trigger trig : triggers) {
				if (!trig.get())
					return false;
			}
			return true;
		case OR:
			for (Trigger trig : triggers) {
				if (trig.get())
					return true;
			}
			return false;
		}
		return false;
	}

	public enum Operator {
		AND, OR;
	}

}
