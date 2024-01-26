// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Arm;
import frc.robot.Subsystems.Lights;

public class ArmControlCommand extends CommandBase {
  Arm m_arm;
  DoubleSupplier m_forward;
  DoubleSupplier m_outerForward;
  DoubleSupplier m_innerForward;
  DoubleSupplier m_armRotation;
  DoubleSupplier m_clawSpeeeeed;


 // double realRightSpeed;
 // double realLeftSpeed;
  /** Creates a new DrivingCommand. */
  public ArmControlCommand(Arm arm, DoubleSupplier forwardValue, DoubleSupplier outerForwardValue, DoubleSupplier innerForwardValue,
      DoubleSupplier armRotationValue ,DoubleSupplier clawValue ) {
    m_arm = arm;
    m_forward = forwardValue;
    m_outerForward = outerForwardValue;
    m_innerForward = innerForwardValue;
    m_armRotation = armRotationValue;
    m_clawSpeeeeed = clawValue;

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
    double realOuterForwardSpeed = m_outerForward.getAsDouble();
    double realInnerForwardSpeed = m_innerForward.getAsDouble();
    double realArmRotationSpeed = m_armRotation.getAsDouble();
    double realClawSpeed = m_clawSpeeeeed.getAsDouble();

    m_arm.ArmControl(realForwardSpeed);
    m_arm.OuterArmControl(realOuterForwardSpeed);
    m_arm.innerArmControl(realInnerForwardSpeed);
    m_arm.armRotationControl(realArmRotationSpeed);
    m_arm.ClawControl(realClawSpeed);
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
