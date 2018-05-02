/**
 * 
 */
package org.usfirst.frc.team5183.robot.commands;

import org.usfirst.frc.team5183.robot.RobotMap;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.AnalogGyro;

public class Motors {
	/*
	 * this command class is designed for commands for using the motors.
	 * these commands are for drive train movement only.
	 */
	
	public static void driveTrain(double a, double less) {
		/* This is the teleop drive train for the robot 
		 * this is a exponential curve... i believe... 
		 * @param a - this is the value to determine the how aggressive the curve for movement curve.
		 * @param a 	a <= 1		this is a linear acceleration
		 * @param a 	1<a<=2		this is the exponential curve. lower the value of a, more aggressive the curve
		 * 
		 *  @param less -  */
		if(1<a && a<=2) {
			/* this is the exponential curve */
			RobotMap.DRIVE.arcadeDrive(-1*(((java.lang.Math.pow(a, RobotMap.m_ctrl.getRawAxis(RobotMap.R_X_AXIS)))-(1.0 + less))), java.lang.Math.pow(a, RobotMap.m_ctrl.getRawAxis(RobotMap.L_Y_AXIS))-(1.0 + less));
		} else if(a<=1) {
			/* this defaults to a normal linear acceleration */
			RobotMap.DRIVE.arcadeDrive(-RobotMap.m_ctrl.getRawAxis(RobotMap.R_X_AXIS), RobotMap.m_ctrl.getRawAxis(RobotMap.L_Y_AXIS));
		} else {
			/* this is the default drive. set as squared imports */
			RobotMap.DRIVE.arcadeDrive(-RobotMap.m_ctrl.getRawAxis(RobotMap.R_X_AXIS), RobotMap.m_ctrl.getRawAxis(RobotMap.L_Y_AXIS), true);
		}
	}
	
	public void move(double left, double right, double time) {
		/* this is  command used to move the robot on a timer
		 * @param left - sets to move the left side motors
		 * @param right - sets to move the right side motors
		 * @param time - sets amount of wait time in seconds
		 */
		
		RobotMap.MOTORS_L.set(left);
		RobotMap.MOTORS_R.set(right);
		Timer.delay(time);
		stopMove();
	}
	
	public void turn(double speed, double angle, String clock) {
		/* this command is for turning the robot. 
		 * @param speed - how fast the robot should move
		 * @param angle - what angle the robot should stop at
		 * @param clock - "c" or "cc". 'c' for clockwise or 'cc' for counter-clockwise
		 */
		Motors M = new Motors();
		M.stopMove();
		if(clock == "c") {
			RobotMap.MOTORS_L.set(speed);
			RobotMap.MOTORS_R.set(speed);
		}else if(clock == "cc") {
			RobotMap.MOTORS_L.set(-speed);
			RobotMap.MOTORS_R.set(-speed);
		}else { //DEFAULT CLOCKWISE
			RobotMap.MOTORS_L.set(-speed);
			RobotMap.MOTORS_R.set(-speed);
		}
	}
	private void stopMove() {
		/* this is to stop the robot in its tracks */
		RobotMap.MOTORS_L.set(0);
		RobotMap.MOTORS_R.set(0);
	}
	public void stopEtc() {
		RobotMap.MOTOR_CLIMB1.set(0);
		RobotMap.MOTOR_CLIMB2.set(0);
		RobotMap.MOTOR_LIFT.set(0);
		RobotMap.MOTOR_HOOK.set(0);
		RobotMap.MOTOR_ARM.set(0);
	}
	
	public void stopAll() {
		/* this will force all motors to stop moving */
		RobotMap.MOTORS_L.set(0);
		RobotMap.MOTORS_R.set(0);
		RobotMap.MOTOR_CLIMB1.set(0);
		RobotMap.MOTOR_CLIMB2.set(0);
		RobotMap.MOTOR_LIFT.set(0);
		RobotMap.MOTOR_HOOK.set(0);
		RobotMap.MOTOR_ARM.set(0);
	}
}
