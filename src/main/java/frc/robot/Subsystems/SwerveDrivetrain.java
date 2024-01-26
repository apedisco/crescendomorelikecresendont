// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveDrivetrain extends SubsystemBase {
  private final double MAX_VOLTAGE = 4.95;
  public WPI_TalonFX swerveMotorAngle;
  public WPI_TalonFX swerveMotorDrive;
  public PIDController pidcontroller;
  /** Creates a new SwerveDrivetrain. */
  public SwerveDrivetrain() {

  }

  public void WheelControl(int angleMotor, int speedmotor, int encoder){
    swerveMotorAngle = new WPI_TalonFX(angleMotor);
    swerveMotorDrive = new WPI_TalonFX(speedmotor);
    pidcontroller = new PIDController(0, 0, 0);
   // VecBuilder
  //  pidcontroller = new PIDController(encoder, angleMotor, speedmotor, encoder)
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
