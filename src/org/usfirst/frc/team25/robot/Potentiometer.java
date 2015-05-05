package org.usfirst.frc.team25.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;

public class Potentiometer extends AnalogPotentiometer {

	public final boolean inverted;
	public double minimum = 0.0, maximum = 5.0;
	
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
		if(minimum > maximum) {
			double temp = maximum;
			maximum = minimum;
			minimum = temp;
		}
		val = ((val / 5.0) * (maximum - minimum)) + minimum;
		return val;
	}
	
}
