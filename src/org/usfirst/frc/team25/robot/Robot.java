package org.usfirst.frc.team25.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	OI m_OI;
	AutonController m_autonController;
	int m_autonPicked;
	SendableChooser m_autonChooser;
	
	public void robotInit() {
		m_OI = OI.getInstance();
		m_autonController = AutonController.getInstance();
		m_autonChooser = new SendableChooser();
		m_autonChooser.addDefault("Do Nothing (default)", 0);
		m_autonChooser.addObject("Move to Normal and Shoot", 1);
		SmartDashboard.putData("Choose Autonomous: ", m_autonChooser);
	}
	
	public void disabledInit() {

	}

	public void disabledPeriodic() {
		SmartDashboard.putData("Choose Autonomous: ", m_autonChooser);
	}

	public void autonomousInit() {
		m_autonController.reset();
		m_autonPicked = (int) m_autonChooser.getSelected();
	}

	public void autonomousPeriodic() {
		if(m_autonPicked == 1) {
			m_autonController.setToFrontAndShoot();
		}
	}

	public void teleopInit() {
		
	}

	public void teleopPeriodic() {
		m_OI.enableTeleopControls();
	}

	public void testInit() {

	}

	public void testPeriodic() {

	}
}
