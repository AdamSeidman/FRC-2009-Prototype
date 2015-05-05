package org.usfirst.frc.team25.robot;

public abstract class Constants {

	public static final int ROTATION_PWM = 1;
	public static final int TILT_PWM = 2;
	public static final int SHOOTER_PWM = 3;
	
	public static final boolean ROTATION_INVERTED = false;
	public static final boolean TILT_INVERTED = false;
	public static final boolean SHOOTER_INVERTED = false;
	
	public static final int TILT_POT_PWM = 1;
	public static final int TWIST_POT_PWM = 2;
	
	public static final boolean TWIST_POT_INVERTED = false;
	public static final boolean TILT_POT_INVERTED = false;
	
	public static final double TILT_MINIMUM = 0.0;
	public static final double TILT_MAXIMUM = 0.0;
	
	public static final double ROTATION_MINIMUM = 0.0;
	public static final double ROTATION_MAXIMUM = 0.0;
	public static final double ROTATION_HALFWAY = (ROTATION_MINIMUM + ROTATION_MAXIMUM) / 2.0;
	
	public static final int JOYSTICK_PORT = 1;
	
	public static final double TILT_SPEED = 1.0;
	public static final double SHOOTER_SPEED = 1.0;
	
	public static final double JOYSTICK_DEADBAND = 0.2;
	
}
