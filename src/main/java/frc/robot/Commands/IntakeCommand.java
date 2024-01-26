// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Arm;
import frc.robot.Subsystems.DrivetrainSubsystem;

public class IntakeCommand extends CommandBase {
  DrivetrainSubsystem m_drivetrain;
  Arm m_arm;
  /** Creates a new ShooterCommand. */
  public IntakeCommand(Arm arm, DrivetrainSubsystem drivetrain) {
    m_drivetrain = drivetrain;
    m_arm = arm;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_arm); 
    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //m_arm.IntakeIn();
    //m_arm.StagingIn();
   m_drivetrain.autonStop();

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_arm.IntakeOff();
    m_arm.StagingOff();
    m_drivetrain.autonLock();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
