package org.usfirst.frc.team25.robot;

public class OI {

	private static OI m_instance;
	private final Prototype m_robot;
	private final ModifiableJoystick m_joystick;
	private boolean m_autonSequenceEnabled = false;
	private double m_rotationAutonValue, m_tiltAutonValue;
	private double m_lastThrottleValue = -10.0;

	public OI() {
		m_robot = Prototype.getInstance();
		m_joystick = new ModifiableJoystick(Constants.JOYSTICK_PORT);
		m_joystick.throttleMinimum = Constants.TILT_MINIMUM;
		m_joystick.throttleMaximum = Constants.TILT_MAXIMUM;
	}

	public static OI getInstance() {
		if (m_instance == null) {
			m_instance = new OI();
		}
		return m_instance;
	}
	
	public void printStats() {
		System.out.println("Rotation Pot Value: " + m_robot.getTwistPot());
		System.out.println("Tilt Pot Value: " + m_robot.getTiltPot());
		System.out.println("Joystick Twist: " + m_joystick.getTwist());
		System.out.println("Joystick Throttle: " + m_joystick.getThrottle());
		System.out.println("POV: " + getPOV() + "\n");
	}
	
	public void enableTeleopControls() {
		printStats();
	}
	
	public void AenableTeleopControls() {
		if (getTrigger()) {
			m_lastThrottleValue = getThrottle();
			m_autonSequenceEnabled = true;
			m_rotationAutonValue = (m_robot.getTwistPot() >= Constants.ROTATION_HALFWAY ? Constants.ROTATION_MAXIMUM
					: Constants.ROTATION_MINIMUM);
			m_tiltAutonValue = Constants.TILT_MINIMUM;
		}

		if (getButton(3)) {
			m_robot.setEverythingToZero();
			m_autonSequenceEnabled = false;
			return;
		}

		if (m_autonSequenceEnabled) {
			m_autonSequenceEnabled = (m_robot.tiltGoto(m_tiltAutonValue, 1.0) || m_robot
					.twistGoto(m_rotationAutonValue, 1.0));
			return;
		}

		if (m_robot.getTiltPot() > m_lastThrottleValue + 0.25
				|| m_robot.getTiltPot() < m_lastThrottleValue - 0.25) {
			m_lastThrottleValue = -10.0;
			m_robot.tiltGoto(getThrottle(), Constants.TILT_SPEED);
		} else {
			m_robot.setTiltSpeed(0.0);
		}

		if (getPOV() % 360 == 0) {
			m_robot.setShooterSpeed(1.0);
		} else if (getPOV() == 180) {
			m_robot.setShooterSpeed(-1.0);
		} else {
			m_robot.setShooterSpeed(0.0);
		}

		if (m_robot.getTwistPot() <= Constants.ROTATION_MINIMUM
				|| m_robot.getTwistPot() >= Constants.ROTATION_MAXIMUM) {
			m_robot.setRotationSpeed(0.0);
		} else {
			m_robot.setRotationSpeed(getTwist());
		}
	}

	public void setLastThrottleValue(double value) {
		m_lastThrottleValue = value;
	}
	
	public boolean getTrigger() {
		return m_joystick.getTrigger();
	}

	public boolean getButton(int button) {
		return m_joystick.getButton(button);
	}

	public double getThrottle() {
		return m_joystick.getThrottle();
	}

	public double getTwist() {
		double tval = m_joystick.getTwist();
		if (Math.abs(tval) < Constants.JOYSTICK_DEADBAND)
			return 0.0;
		return tval;
	}

	public int getPOV() {
		return m_joystick.getPOV();
	}

}
