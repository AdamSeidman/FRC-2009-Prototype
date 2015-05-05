package org.usfirst.frc.team25.robot;

public class AutonController {

	private static AutonController m_instance;
	private int m_step;
	private final Prototype m_robot;

	public AutonController() {
		m_step = 0;
		m_robot = Prototype.getInstance();
	}

	public static AutonController getInstance() {
		if (m_instance == null) {
			m_instance = new AutonController();
		}
		return m_instance;
	}

	public void reset() {
		m_step = 0;
	}

	public void setToFrontAndShoot() {
		if (m_step == 0) {
			m_step++;
		} else if (m_step == 1) {
			double closerLimit = (m_robot.getTwistPot() >= Constants.ROTATION_HALFWAY ? Constants.ROTATION_MAXIMUM
					: Constants.ROTATION_MINIMUM);
			if (!m_robot.tiltGoto(Constants.TILT_MINIMUM, 0.5)
					&& !m_robot.twistGoto(closerLimit, 0.8)) {
				m_robot.setEverythingToZero();
				m_step++;
			}
		} else {
			m_robot.setShooterSpeed(1.0);
		}
	}
	
	public void funWhileShooting() {
		if(m_step == 0) {
			m_step++;
		} else if(m_step == 1) {
			if(!m_robot.tiltGoto(Constants.TILT_MINIMUM, 0.5)) {
				m_robot.setEverythingToZero();
				m_step++;
			}
		} else if(m_step == 2) {
			m_robot.setShooterSpeed(1.0);
			m_step++;
		} else if(m_step == 3) {
			if(!m_robot.twistGoto(Constants.ROTATION_MAXIMUM, 0.5)) {
				m_robot.setRotationSpeed(0.0);
				m_step++;
			}
		} else {
			if(!m_robot.twistGoto(Constants.ROTATION_MINIMUM, 0.5)) {
				m_robot.setRotationSpeed(0.0);
				m_step--;
			}
		}
	}
	
}
