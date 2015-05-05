package org.usfirst.frc.team25.robot;

public class Prototype {

	private static Prototype m_instance;
	private final Motor m_tilt;
	private final Motor m_rotation;
	private final Motor m_shooter;
	private final Potentiometer m_tiltPot;
	private final Potentiometer m_twistPot;
	
	public Prototype() {
		m_tilt = new Motor(Constants.TILT_PWM, Constants.TILT_INVERTED);
		m_rotation = new Motor(Constants.ROTATION_PWM, Constants.ROTATION_INVERTED);
		m_shooter = new Motor(Constants.SHOOTER_PWM, Constants.SHOOTER_INVERTED);
		m_tiltPot = new Potentiometer(Constants.TILT_POT_PWM, Constants.TILT_POT_INVERTED);
		m_twistPot = new Potentiometer(Constants.TWIST_POT_PWM, Constants.TWIST_POT_INVERTED);
	}
	
	public static Prototype getInstance() {
		if(m_instance == null) {
			m_instance = new Prototype();
		}
		return m_instance;
	}
	
	public void setRotationSpeed(double speed) {
		m_rotation.set(speed);
	}
	
	public void setTiltSpeed(double speed) {
		m_tilt.set(speed);
	}
	
	public void setShooterSpeed(double speed) {
		m_shooter.set(speed);
	}
	
	public double getTwistPot() {
		return m_twistPot.get();
	}
	
	public double getTiltPot() {
		return m_tiltPot.get();
	}
	
	public boolean twistGoto(double value, double speed) {
		speed = Math.abs(speed);
		if(m_twistPot.get() <= value + 0.1 && m_twistPot.get() >= value - 0.1) {
			m_rotation.set(0.0);
			return false;
		}
		if(m_twistPot.get() >= Constants.ROTATION_MAXIMUM || m_twistPot.get() <= Constants.ROTATION_MINIMUM) {
			m_rotation.set(0.0);
			return false;
		}
		if(value < m_twistPot.get())
			speed *= -1.0;
		if(m_twistPot.get() >= value - 0.5 || m_twistPot.get() <= value + 0.5)
			speed /= 2.0;
		m_rotation.set(speed);
		return true;
	}
	
	public boolean tiltGoto(double value, double speed) {
		speed = Math.abs(speed);
		if(m_tiltPot.get() <= value + 0.1 && m_tiltPot.get() >= value - 0.1) {
			m_tilt.set(0.0);
			return false;
		}
		if(m_tiltPot.get() >= Constants.TILT_MAXIMUM || m_tiltPot.get() <= Constants.TILT_MINIMUM) {
			m_tilt.set(0.0);
			return false;
		}
		if(value < m_tiltPot.get())
			speed *= -1.0;
		if(m_tiltPot.get() >= value - 0.5 || m_tiltPot.get() <= value + 0.5)
			speed /= 2.0;
		m_tilt.set(speed);
		return true;
	}
	
	public void setEverythingToZero() {
		m_tilt.set(0.0);
		m_rotation.set(0.0);
		m_shooter.set(0.0);
	}
	
}
