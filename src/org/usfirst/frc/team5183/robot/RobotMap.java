package org.usfirst.frc.team5183.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class RobotMap {
	/*
	 * With these values, you are able to configure the robot through the code, such as settings for the robot
	 */

	// PWM Channels
	/** MOTOR_ [left or right] [front or back] **/
	public static Spark MOTORS_L; //Left side motors on channel 0
	public static Spark MOTORS_R; //Right side motors on channel 1
	public static Spark MOTOR_CLIMB1; //Motor for climbing motor 1 on channel 2
	public static Spark MOTOR_CLIMB2; //Motor for climbing motor 2 on channel 3
	public static Spark MOTOR_LIFT;
	
	// Gyro
	public static AnalogGyro gyro;
	
	// Controller Interfaces
	public static XboxController m_ctrl; //Xbox Controller on port 0 of the DS
	/** Axis raw numbers - don't touch these **/
	public static final int L_X_AXIS = 0;
	public static final int L_Y_AXIS = 1;
	public static final int L_TRIG = 2;
	public static final int R_TRIG = 3;
	public static final int R_X_AXIS = 4;
	public static final int R_Y_AXIS = 5;
	
	
	// Robot Driving Config
	/** CIM Motor Specs
	 * Gear Box Ratio: 10.71:1
	 * No load RPM: 5,310
	 */
	public static DifferentialDrive DRIVE; //Motor order for the robot drive class
	public static double MAXOUTPUT;
	public static double AUTON_MAX_SPEED_F; // Max auton speed forward
	public static double AUTON_MAX_SPEED_R; // Max auton speed backwards
	
	public static double CLIMB_SPEED;
	
	// Pneumatics - give them some slack, their just kinda bloated
	public static Compressor compressor;
	public static DoubleSolenoid piston1;
	public static DoubleSolenoid piston2;
	public static int lift;
	
	
	public static void init() {
		/** this method initializes all of the variables for the entire robot system **/
		
		m_ctrl = new XboxController(0);
		MOTORS_L = new Spark(0); //Left side motors on channel 0
		MOTORS_R = new Spark(1); //Right side motors on channel 1
		MOTOR_CLIMB1 = new Spark(2); //Motor for climbing motor 1 on channel 2
		MOTOR_CLIMB2 = new Spark(3); //Motor for climbing motor 2 on channel 3
		MOTOR_LIFT = new Spark(4); //Motor fir the lift system to lift the cube. On channel 4
		gyro = new AnalogGyro(0);
		DRIVE = new DifferentialDrive(MOTORS_L, MOTORS_R);
		MAXOUTPUT = 0.9;
		AUTON_MAX_SPEED_F = 0.5;
		AUTON_MAX_SPEED_R = -0.5;
		CLIMB_SPEED = 1;
		compressor = new Compressor(0); // what else would this be?
		piston1 = new DoubleSolenoid(0, 0, 1); // solenoid for the lift
		piston2 = new DoubleSolenoid(0, 2, 3); // piston for grabber on the lift system
		lift = 0; //lift starts down  
	}
}
