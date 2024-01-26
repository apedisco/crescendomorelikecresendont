// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class ThomasTheTankEngine extends SubsystemBase {

  public WPI_TalonFX frontLeftMotor;
  public WPI_TalonFX backLeftMotor;
  public WPI_TalonFX frontRightMotor;
  public WPI_TalonFX backRightMotor;
  public MotorControllerGroup rightDrive;
  public MotorControllerGroup leftDrive;
  public DifferentialDrive drivetrain;
  public boolean damperApplied = true;
  public WPI_TalonFX swerveMotorAngle;
  public WPI_TalonFX swerveMotorDrive;


  /** Creates a new ThomasTheTankEngine. */
  public ThomasTheTankEngine() {
    try {
      frontLeftMotor = new WPI_TalonFX(18);
    } catch (Exception e) {
      System.out.println("front left drive motor error");
    }
    
    try {
      backLeftMotor = new WPI_TalonFX(19);
    } catch (Exception e) {
      System.out.println("back left drive motor error");
    }
    
    try {
      frontRightMotor = new WPI_TalonFX(2);      
    } catch (Exception e) {
      System.out.println("front right drive motor error");
    }
    
    try {
      backRightMotor = new WPI_TalonFX(8);     
    } catch (Exception e) {
      System.out.println("back right drive motor error");
    }

    frontLeftMotor.setInverted(true);
    backLeftMotor.setInverted(true);

    rightDrive = new MotorControllerGroup(frontRightMotor, backRightMotor);
    leftDrive = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
    drivetrain = new DifferentialDrive(leftDrive, rightDrive);
  }

  public void ChangeDamper(){
    damperApplied = !damperApplied;
  }

  public void Drive(double leftSpeed, double rightSpeed){
    if(damperApplied){
      leftSpeed = leftSpeed-(leftSpeed*0.6);
      rightSpeed = rightSpeed-(rightSpeed*0.6);
    }

    drivetrain.tankDrive(leftSpeed, rightSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}