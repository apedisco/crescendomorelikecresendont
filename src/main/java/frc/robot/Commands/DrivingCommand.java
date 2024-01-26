// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.ThomasTheTankEngine;

public class DrivingCommand extends CommandBase {
  ThomasTheTankEngine m_tank;
  DoubleSupplier m_left;
  DoubleSupplier m_right;
 // double realRightSpeed;
 // double realLeftSpeed;
  /** Creates a new DrivingCommand. */
  public DrivingCommand(ThomasTheTankEngine drive, DoubleSupplier left, DoubleSupplier right) {
    m_tank = drive;
    m_left = left;
    m_right = right;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_tank);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double realLeftSpeed = m_left.getAsDouble();
   // realLeftSpeed = realLeftSpeed - (realLeftSpeed*0.4);
    double realRightSpeed = m_right.getAsDouble();
   // realRightSpeed = realRightSpeed - (realRightSpeed*0.4);
    m_tank.Drive(realLeftSpeed, realRightSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
