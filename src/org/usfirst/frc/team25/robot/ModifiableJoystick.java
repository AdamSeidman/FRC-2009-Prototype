package org.usfirst.frc.team25.robot;

import edu.wpi.first.wpilibj.Joystick;

public class ModifiableJoystick extends Joystick {

	private boolean[] disabledButtons;
	public double xMinimum = -1.0, xMaximum = 1.0, yMinimum = -1.0,
			yMaximum = 1.0, twistMinimum = -1.0, twistMaximum = 1.0,
			zMinimum = -1.0, zMaximum = 1.0, throttleMinimum = -1.0,
			throttleMaximum = 1.0;
	public boolean xInverted = false, yInverted = false, zInverted = false,
			twistInverted = false, throttleInverted = false;

	public ModifiableJoystick(int channel) {
		super(channel);
		disabledButtons = new boolean[100];
	}

	public boolean getButton(int button) {
		if (disabledButtons[button])
			return false;
		return super.getRawButton(button);
	}

	public boolean getEnabled(int button) {
		return !disabledButtons[button];
	}

	public void setEnabled(int button, boolean enabled) {
		disabledButtons[button] = !enabled;
	}
	
	public double x() {
		double xVal = super.getX();
		if(xInverted)
			xVal *= -1.0;
		if(xMinimum > xMaximum) {
			double temp = xMinimum;
			xMinimum = xMaximum;
			xMaximum = temp;
		}
		xVal = (((xVal + 1.0) / 2.0) * (xMaximum - xMinimum)) + xMinimum;
		return xVal;
	}

	public double y() {
		double yVal = super.getY();
		if(yInverted)
			yVal *= -1.0;
		if(yMinimum > yMaximum) {
			double temp = yMinimum;
			yMinimum = yMaximum;
			yMaximum = temp;
		}
		yVal = (((yVal + 1.0) / 2.0) * (yMaximum - yMinimum)) + yMinimum;
		return yVal;
	}
	
	public double z() {
		double zVal = super.getZ();
		if(zInverted)
			zVal *= -1.0;
		if(zMinimum > zMaximum) {
			double temp = zMinimum;
			zMinimum = zMaximum;
			zMaximum = temp;
		}
		zVal = (((zVal + 1.0) / 2.0) * (zMaximum - zMinimum)) + zMinimum;
		return zVal;
	}
	
	public double throttle() {
		double throttleVal = super.getThrottle();
		if(throttleInverted)
			throttleVal *= -1.0;
		if(throttleMinimum > throttleMaximum) {
			double temp = throttleMinimum;
			throttleMinimum = throttleMaximum;
			throttleMaximum = temp;
		}
		throttleVal = (((throttleVal + 1.0) / 2.0) * (throttleMaximum - throttleMinimum)) + throttleMinimum;
		return throttleVal;
	}
	
	public double twist() {
		double twistVal = super.getTwist();
		if(twistInverted)
			twistVal *= -1.0;
		if(twistMinimum > twistMaximum) {
			double temp = twistMinimum;
			twistMinimum = twistMaximum;
			twistMaximum = temp;
		}
		twistVal = (((twistVal + 1.0) / 2.0) * (twistMaximum - twistMinimum)) + twistMinimum;
		return twistVal;
	}
	
}
