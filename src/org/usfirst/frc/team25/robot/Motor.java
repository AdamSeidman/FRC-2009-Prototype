package org.usfirst.frc.team25.robot;

import edu.wpi.first.wpilibj.Victor;

public class Motor extends Victor {
	
	private final boolean inverted;
	
	public Motor(int channel) {
		super(channel);
		inverted = false;
	}

	public Motor(int channel, boolean inverted) {
		super(channel);
		this.inverted = inverted;
	}
	
	public void set(double speed) {
		if(inverted)
			speed *= -1.0;
		super.set(speed);
	}
	
	public double get() {
		double val = super.get();
		if(inverted)
			val *= -1.0;
		return val;
	}
	
}
