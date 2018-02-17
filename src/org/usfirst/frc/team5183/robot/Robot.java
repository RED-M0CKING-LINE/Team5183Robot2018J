// @author Ethan A. -- Lead Programmer -- Team 5183, Gaylord Devil Bots

package org.usfirst.frc.team5183.robot;

import org.usfirst.frc.team5183.robot.RobotMap;
import org.usfirst.frc.team5183.robot.auton.*;
import org.usfirst.frc.team5183.robot.commands.Motors;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {
    
	Command autonCommand;
	SendableChooser<Command> autonChooser;
	public Compressor c = new Compressor(0);
    
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
		autonChooser = new SendableChooser<Command>();
		autonChooser.addDefault("Start Default Auton", new autonStartDefault()); // default start auton option
		autonChooser.addObject("Start Left Auton", new autonStartLeft()); // left start auton option
		autonChooser.addObject("Start Center Auton", new autonStartCenter()); // center start auton option
		autonChooser.addObject("Start Right Auton", new autonStartCenter()); // right start auton option
		SmartDashboard.putData("Autonomous Mode Chooser", autonChooser);
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
		autonCommand = (Command) autonChooser.getSelected();
		autonCommand.start();
    	Motors M = new Motors();
    	M.turn(0.1, 30, "cc");
    	M.stopAll();
	}

	@Override
	public void autonomousPeriodic() {
		// called periodically during autonomous
		Scheduler.getInstance().run();
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
		Motors.driveTrain();
		if(RobotMap.m_ctrl.getYButton()) {
			RobotMap.MOTOR_CLIMB1.set(RobotMap.CLIMB_SPEED);
			RobotMap.MOTOR_CLIMB2.set(-RobotMap.CLIMB_SPEED);
			Motors.driveTrain();
		} else if(RobotMap.m_ctrl.getXButton()) {
			RobotMap.MOTOR_CLIMB1.set(-RobotMap.CLIMB_SPEED);
			RobotMap.MOTOR_CLIMB2.set(RobotMap.CLIMB_SPEED);
			Motors.driveTrain();
		} else {
			RobotMap.MOTOR_CLIMB1.set(0);
			RobotMap.MOTOR_CLIMB2.set(0);
			Motors.driveTrain();
		}
		
		if(RobotMap.m_ctrl.getAButton()) {
			RobotMap.piston1.set(DoubleSolenoid.Value.kForward);
			RobotMap.piston2.set(DoubleSolenoid.Value.kForward);
			Motors.driveTrain();
		} else {
			RobotMap.piston1.set(DoubleSolenoid.Value.kReverse);
			RobotMap.piston2.set(DoubleSolenoid.Value.kReverse);
			Motors.driveTrain();
		}
		
		if(RobotMap.m_ctrl.getBButton()) {
			RobotMap.piston3.set(DoubleSolenoid.Value.kForward);
			Motors.driveTrain();
		} else {
			RobotMap.piston3.set(DoubleSolenoid.Value.kReverse);
			Motors.driveTrain();
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
// TODO get pneumatics working, setup auton selection and make it work, and start Auton Configuration
