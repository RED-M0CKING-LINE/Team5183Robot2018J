// @author Ethan A. -- Lead Programmer -- Team 5183, Gaylord Devil Bots

package org.usfirst.frc.team5183.robot;

import org.usfirst.frc.team5183.robot.RobotMap;
import org.usfirst.frc.team5183.robot.commands.Auton;
import org.usfirst.frc.team5183.robot.commands.Motors;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {
    
	private int mode = 1; // initialize default mode
	private SendableChooser<Object> autoCommand;  //TODO make getters and setters
	SendableChooser<Object> chooser = new SendableChooser<>();
	public Compressor c = new Compressor(0);
	Motors M = new Motors();
    
	public SendableChooser<Object> getAutoCommand() {
		return autoCommand;
	}

	public void setAutoCommand(SendableChooser<Object> autoCommand) {
		this.autoCommand = autoCommand;
	}

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
		chooser.addDefault("default", 0); // default start auton option
		chooser.addObject("left", 1); // left start auton option
		chooser.addObject("center", 2); // center start auton option
		chooser.addObject("right", 3); // right start auton option
		SmartDashboard.putData("Autonomous Mode Chooser", chooser);
		
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
    	M.stopAll();
	}

	@Override
	public void autonomousPeriodic() {
		// called periodically during autonomous
		Auton auto = new Auton();
		switch(mode) {
		case 1:
			// Left Auton
			mode = 99;
			auto.autonStartDefault();
			mode = 99;
			break;
		case 2:
			// Center Auton
			mode = 99;
			auto.autonStartDefault();
			mode = 99;
			break;
		case 3:
			// Right Auton
			auto.autonStartDefault();
			mode = 99;
			break;
		case 99:
			// fall back so it does not repeat an auton mode
			break;
		case 0:
			// Default Auton
			mode = 99;
			auto.autonStartDefault();
			mode = 99;
			break;
		default:
			mode = 99;
			M.move(.5, .5, 3);
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
		} // climbing motors
		if(RobotMap.mlift == 0 && RobotMap.m_ctrl.getTriggerAxis(Hand.kLeft) > 30) {
			RobotMap.MOTOR_LIFT.set(-RobotMap.LIFT_SPEED);
			Motors.driveTrain(2, 0.33);
		} else if(RobotMap.mlift == 1 && RobotMap.m_ctrl.getTriggerAxis(Hand.kLeft) > 30) {
			RobotMap.MOTOR_LIFT.set(RobotMap.LIFT_SPEED);
			Motors.driveTrain(2, 0.33);
		} // pully system lift
		
		if(RobotMap.plift == 0 && RobotMap.m_ctrl.getBumperPressed(Hand.kLeft)) {
			RobotMap.piston1.set(DoubleSolenoid.Value.kForward);
			Motors.driveTrain(2, 0.33);
			RobotMap.plift = 1;
		} else if(RobotMap.plift == 1 && RobotMap.m_ctrl.getBumperPressed(Hand.kLeft)) {
			RobotMap.piston1.set(DoubleSolenoid.Value.kReverse);
			Motors.driveTrain(2, 0);
			RobotMap.plift = 0;
		} // pneumatic piston lift
		if(RobotMap.m_ctrl.getBumper(Hand.kRight)) {
			RobotMap.piston2.set(DoubleSolenoid.Value.kForward);
			Motors.driveTrain(2, 0.5); // drive that is slowed down when grabbing the power cube
		} else {
			RobotMap.piston2.set(DoubleSolenoid.Value.kReverse);
			Motors.driveTrain(2, 0);
		} // grabber
		if(RobotMap.m_ctrl.getTriggerAxis(Hand.kRight) > 30) {
			RobotMap.MOTOR_ARM.set(.2);
		} else if(RobotMap.m_ctrl.getBumper(Hand.kRight)) {
			RobotMap.MOTOR_ARM.set(-.2);
		} // arm
		if(RobotMap.m_ctrl.getAButton()) {
			RobotMap.MOTOR_HOOK.set(RobotMap.HOOK_SPEED);
		} else if(RobotMap.m_ctrl.getBButton()) {
			RobotMap.MOTOR_HOOK.set(-RobotMap.HOOK_SPEED);
		} // hook
		if(RobotMap.m_ctrl.getBackButton()) {
			M.stopEtc();
		} // emergency stop
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

