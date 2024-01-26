
// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Commands.*;
import frc.robot.Subsystems.*;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
//import edu.wpi.first.wpilibj.Solenoid;
//import frc.robot.Commands.DefaultDriveCommand;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.Subsytems.DrivetrainSubsystem;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

   public Cannon m_pneumatics;
 // private final DrivetrainSubsystem m_drivetrainSubsystem = new DrivetrainSubsystem();
  public boolean CommandLoop = false;

  
  
  public ThomasTheTankEngine m_drivetrain;
  public Arm m_arm;
  
  public DrivingCommand m_DrivingCommand;
  public ArmControlCommand m_ArmCommand;
  //public DrivetrainSubsystem m_drivetrainSubsystem;


  public XboxController m_driveController;
  public XboxController m_driveController2;
  public Joystick m_armControl;
  public Joystick m_OuterArmControl;
  public Joystick m_HangControl;
  
  



  // The robot's subsystems and commands are defined here...
  private final DrivetrainSubsystem m_drivetrainSubsystem = new DrivetrainSubsystem();
  
 

  private final Joystick m_controller = new Joystick(0);
  private final Joystick m_clawController = new Joystick(2);
  private final Joystick m_clawController2 = new Joystick(3);


  private final XboxController m_xbox = new XboxController(1);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    
    m_driveController = new XboxController(0);
        m_armControl = new Joystick(1);
        m_OuterArmControl = new Joystick(2);
        m_HangControl = new Joystick(3);
       
        
        
       // m_pneumatics = new Cannon();
    
        
    
    
        //compressor.enableDigital();
        //compressor.disable();
    
       
       
        m_drivetrain = new ThomasTheTankEngine();
        
        m_DrivingCommand = new DrivingCommand(m_drivetrain, () -> m_driveController.getLeftY(),() -> m_driveController.getRightY());
        m_arm = new Arm();
    
    
        m_ArmCommand = new ArmControlCommand(m_arm, () -> m_armControl.getY(), () ->m_OuterArmControl.getY(), () -> m_OuterArmControl.getX(), 
              () -> m_armControl.getTwist() ,() -> m_armControl.getX());
    
        
        m_arm.setDefaultCommand(m_ArmCommand);
        m_drivetrain.setDefaultCommand(m_DrivingCommand);
    
       // m_DrivingCommand = new DrivingCommand(m_drivetrain, () -> m_driveController.getLeftY(),() -> m_driveController.getRightY());
   
   


   

    configureButtonBindings();

    // Set up the default command for the drivetrain.
    // The controls are for field-oriented driving:
    // Left stick Y axis -> forward and backwards movement
    // Left stick X axis -> left and right movement
    // Right stick X axis -> rotation

     m_drivetrainSubsystem.setDefaultCommand(new DefaultDriveCommand(
            m_drivetrainSubsystem,
            () -> -modifyAxis(m_controller.getY()) * DrivetrainSubsystem.MAX_VELOCITY_METERS_PER_SECOND ,
           () -> -modifyAxis(m_controller.getX()) * DrivetrainSubsystem.MAX_VELOCITY_METERS_PER_SECOND,
            () -> -modifyAxis(m_controller.getTwist()) * DrivetrainSubsystem.MAX_ANGULAR_VELOCITY_RADIANS_PER_SECOND*0.25
    ));

  

  

    // Configure the button bindings
  }


 

  // /**
  //  * Use this method to define your button->command mappings. Buttons can be created by
  //  * instantiating a {@link GenericHID} or one of its subclasses ({@link
  //  * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
  //  * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
  //  */
  private void configureButtonBindings() {
    final JoystickButton drivingVariableSpeedButton = new JoystickButton(m_driveController,
         Constants.XBOX_BUTTON.XBOX_LEFT_SHOULDER_BUTTON.getValue());
    
         final JoystickButton GoInButton = new JoystickButton(m_OuterArmControl, 3);
         final JoystickButton GoOutButton = new JoystickButton(m_OuterArmControl, 4);
         final JoystickButton ShootButton = new JoystickButton(m_OuterArmControl, 5);
         final JoystickButton DriveButton = new JoystickButton(m_OuterArmControl, 2);
         final JoystickButton StagingButton = new JoystickButton(m_armControl, 2);
        //final JoystickButton StagingButton = new JoystickButton(m_OuterArmControl, 2);
         final JoystickButton IntakeButton = new JoystickButton(m_OuterArmControl, 1);
        // final JoystickButton HangButton = new JoystickButton(m_HangControl, 1);
    
        drivingVariableSpeedButton.onTrue(new ToggleDrivespeedCommand(m_drivetrain));
        GoInButton.whileTrue(new ClawGripCommand(m_arm));
        GoOutButton.whileTrue(new ClawUngripCommand(m_arm));
        ShootButton.whileTrue(new IntakeCommand(m_arm,m_drivetrainSubsystem));
        DriveButton.whileTrue(new DriveCommand(m_arm));
        //IntakeButton Boolean = new IntakeButton(CommandLoop = true);
        IntakeButton.whileTrue(new IntakeCommand(m_arm,m_drivetrainSubsystem));
        StagingButton.whileTrue(new StagingCommand(m_arm));
       // HangButton.whileTrue(new HangCommand(m_arm));


  }

  




  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return Commands.print("No autonomous command configured");
  }

  private static double deadband(double value, double deadband) {
    if (Math.abs(value) > deadband) {
      if (value > 0.0) {
        return (value - deadband) / (1.0 - deadband);
      } else {
        return (value + deadband) / (1.0 - deadband);
      }
    } else {
      return 0.0;
    }
  }

  private static double modifyAxis(double value) {
    // Deadband
    value = deadband(value, 0.2);
    //first 0.05

    // Square the axis
    value = Math.copySign(value * value, value);

    return value;
  }
}


