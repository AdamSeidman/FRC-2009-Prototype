package org.usfirst.frc.team25.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;

public class Potentiometer extends AnalogPotentiometer {

	public final boolean inverted;
	public double minimum = 0.0, maximum = 5.0;
	public double minSpot = 0.0, maxSpot = 5.0;
	
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
		if(minSpot != 0.0 || maxSpot != 5.0)
			limitFixes();
		val = ((val / 5.0) * (maximum - minimum)) + minimum;
		return val;
	}
	
	public void limitFixes() {
		if(minSpot > maxSpot) {
			double temp = minSpot;
			minSpot = maxSpot;
			maxSpot = temp;
		}
		if(maxSpot > 5.0)
			maxSpot = 5.0;
		if(minSpot < 0.0)
			minSpot = 0.0;
		double rangeFor1 = (maximum - minimum) / (maxSpot - minSpot);
		minimum -= (rangeFor1 * minSpot);
		maximum += (5.0 - maxSpot) * rangeFor1;
		minSpot = 0.0;
		maxSpot = 5.0;
		System.out.println("1-range: " + rangeFor1);
		System.out.println("min: " + minimum);
		System.out.println("max: " + maximum);
	}
	
}
