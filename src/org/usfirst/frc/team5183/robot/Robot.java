// @author Ethan A. -- Lead Programmer -- Team 5183, Gaylord Devil Bots

package org.usfirst.frc.team5183.robot;

import org.usfirst.frc.team5183.robot.RobotMap;
import org.usfirst.frc.team5183.robot.auton.*;
import org.usfirst.frc.team5183.robot.commands.Motors;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {
    
	private int mode = 1; // initialize default mode
	private SendableChooser<Object> autoCommand;
	SendableChooser<Object> chooser = new SendableChooser<>();
	public Compressor c = new Compressor(0);
	Motors M = new Motors();
    
	@Override
	public void robotInit() {
        RobotMap.init();
        // Robot-Wide initialization code
		RobotMap.MOTORS_L.enableDeadbandElimination(true);
		RobotMap.MOTORS_R.enableDeadbandElimination(true);
		RobotMap.MOTORS_L.setSafetyEnabled(true);
		RobotMap.MOTORS_R.setSafetyEnabled(true);
		RobotMap.MOTORS_L.setExpiration(0.1);
		RobotMap.MOTORS_R.setExpiration(0.1);
		
		RobotMap.MOTORS_L.setInverted(true);
		
		// Auton Selection Configuration
		chooser.addDefault("Start Default Auton", 0); // default start auton option
		chooser.addObject("Start Left Auton", 1); // left start auton option
		chooser.addObject("Start Center Auton", 2); // center start auton option
		chooser.addObject("Start Right Auton", 3); // right start auton option
		SmartDashboard.putData("Autonomous Mode Chooser", chooser);
		//TODO GET THE SELECTION FOR STARTING POSITION FROM THE SMART DASHBOARD AND MAKE IT WORK
		
		// boolean enabled = c.enabled();
		// double current = c.getCompressorCurrent();
	}

	@Override
	public void robotPeriodic() {
	} 
	
	@Override
	public void autonomousInit() {
		// autonomous initialization code
		mode = (int) chooser.getSelected();
    	M.turn(0.1, 30, "cc");
    	M.stopAll();
	}

	@Override
	public void autonomousPeriodic() {
		// called periodically during autonomous
		switch(mode) {
		case 1:
			// Left Auton
			M.move(.5, .5, 1);
			mode = 99;
			break;
		case 2:
			// Center Auton
			M.move(.5, .5, 1);
			mode = 99;
			break;
		case 3:
			// Right Auton
			M.move(.5, .5, 1);
			mode = 99;
			break;
		case 99:
			// fall back so it does not repeat an auton mode
			break;
		case 0:
			// Default Auton
			M.move(.5, .5, 1);
			mode = 99;
			break;
		default:
			M.move(.5, .5, 1);
			mode = 99;
			break;
		}
	}

    @Override
    public void teleopInit() {
    	Motors M = new Motors();
    	M.stopAll();
    }

	@Override
	public void teleopPeriodic() {
		// called periodically during operator control
        Scheduler.getInstance().run();
		Motors.driveTrain(2, 0);
		if(RobotMap.m_ctrl.getYButton()) {
			RobotMap.MOTOR_CLIMB1.set(RobotMap.CLIMB_SPEED);
			RobotMap.MOTOR_CLIMB2.set(-RobotMap.CLIMB_SPEED);
			Motors.driveTrain(2, 0); 
		} else if(RobotMap.m_ctrl.getXButton()) {
			RobotMap.MOTOR_CLIMB1.set(-RobotMap.CLIMB_SPEED);
			RobotMap.MOTOR_CLIMB2.set(RobotMap.CLIMB_SPEED);
			Motors.driveTrain(2, 0);
		} else {
			RobotMap.MOTOR_CLIMB1.set(0);
			RobotMap.MOTOR_CLIMB2.set(0);
			Motors.driveTrain(2, 0);
		}
		
		if(RobotMap.lift == 0 && RobotMap.m_ctrl.getBumperPressed(Hand.kLeft)) {
			RobotMap.piston1.set(DoubleSolenoid.Value.kForward);
			Motors.driveTrain(2, 0.33);
			RobotMap.lift = 1;
		} else if(RobotMap.lift == 1 && RobotMap.m_ctrl.getBumperPressed(Hand.kLeft)) {
			RobotMap.piston1.set(DoubleSolenoid.Value.kReverse);
			Motors.driveTrain(2, 0);
			RobotMap.lift = 0;
		} else {
			Motors.driveTrain(2, 0);
		}
		
		if(RobotMap.m_ctrl.getBumper(Hand.kRight)) {
			RobotMap.piston2.set(DoubleSolenoid.Value.kForward);
			Motors.driveTrain(2, 0.5); // drive that is slowed down when grabbing the power cube
		} else {
			RobotMap.piston2.set(DoubleSolenoid.Value.kReverse);
			Motors.driveTrain(2, 0);
		}
	}
	
    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }
    
	@Override
	public void testPeriodic() {
		// called periodically during test mode
	}
}
// TODO get auton selector to work
