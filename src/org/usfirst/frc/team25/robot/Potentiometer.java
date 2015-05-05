package org.usfirst.frc.team25.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;

public class Potentiometer extends AnalogPotentiometer {

	public final boolean inverted;
	
	public Potentiometer(int channel) {
		super(channel);
		inverted = false;
	}

	public Potentiometer(int channel, boolean inverted) {
		super(channel);
		this.inverted = inverted;
	}
	
	public double get() {
		double val = super.get();
		if(inverted)
			val = 5.0 - val;
		return val;
	}
	
}
