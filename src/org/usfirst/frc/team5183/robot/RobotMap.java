package org.usfirst.frc.team5183.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class RobotMap {
	/*
	 * With these values, you are able to configure the robot through the code, such as settings for the robot
	 */

	// PWM Channels
	// MOTOR_ [left or right] [front or back]
	public final static Spark MOTORS_L = new Spark(0); //Left side motors on channel 0
	public final static Spark MOTORS_R = new Spark(1); //Right side motors on channel 1'
	
	
	// Controller Interfaces
	public final static XboxController m_ctrl = new XboxController(0); //Xbox Controller on port 0 of the DS
	// Axis raw numbers - don't touch these
	public static final int L_X_AXIS = 0;
	public static final int L_Y_AXIS = 1;
	public static final int L_TRIG = 2;
	public static final int R_TRIG = 3;
	public static final int R_X_AXIS = 4;
	public static final int R_Y_AXIS = 5;
	
	
	// Robot Driving Config
	/** SIM Specs
	 * Gear Box Ratio: 10.71:1
	 * No load RPM: 5,310
	 */
	public final static DifferentialDrive DRIVE = new DifferentialDrive(MOTORS_L, MOTORS_R); //Motor order for the robot drive class
	public final static double MAXOUTPUT = 0.9;
	public final static double AUTON_MAX_SPEED_F = 0.5; // Max auton speed forward
	public final static double AUTON_MAX_SPEED_R = -0.5; // Max auton speed backwards
	
	
	// Pneumatics - give them some slack, their just kinda bloated

	// Measurements - USE THESE FOR FINE TUNING THE ROBOT AND HAVE MOVEMENT PERSISTANCE
}
