// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Arm;

public class OuterArmControlCommand extends CommandBase {
  Arm m_arm;
  DoubleSupplier m_forward;
 // double realRightSpeed;
 // double realLeftSpeed;
  /** Creates a new DrivingCommand. */
  public OuterArmControlCommand(Arm arm, DoubleSupplier forwardValue) {
    m_arm = arm;
    m_forward = forwardValue;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double realForwardSpeed = m_forward.getAsDouble();
    m_arm.OuterArmControl(realForwardSpeed);
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
