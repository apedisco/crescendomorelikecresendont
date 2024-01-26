// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//import com.ctre.phoenixpro.signals.NeutralModeValue;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  public WPI_TalonFX ArmMotor;
  public WPI_TalonFX OuterArmMotor;
  public WPI_TalonSRX innerArmMotor;
  public WPI_TalonFX armRotationMotor;
  public WPI_TalonSRX clawMotor;
  public WPI_TalonSRX gripMotor;
  //public WPI_TalonFX ShootingMotor;
  //public WPI_TalonFX ShootingMotor2;
  public CANSparkFlex ShootingMotor;
  public CANSparkFlex ShootingMotor2;
  public WPI_TalonFX Drive;
  public CANSparkFlex IntakeMotorBottom;
  public CANSparkFlex IntakeMotorTop;
  public CANSparkFlex StagingMotorBottom;
  public CANSparkFlex StagingMotorTop;
  /** Creates a new SwerveDrivetrain. */
  public Arm() {
    try {
      ArmMotor = new WPI_TalonFX(4);
    } catch (Exception e) {
      System.out.println("arm motor not detected");
      
    }
    try {
      OuterArmMotor = new WPI_TalonFX(5);
    } catch (Exception e) {
     System.out.println("outer arm motor not detected");
    }
    try {
      innerArmMotor = new WPI_TalonSRX(6);
    } catch (Exception e) {
      System.out.println("inner arm motor not detected");
    }
    try {
      armRotationMotor = new WPI_TalonFX(7);
    } catch (Exception e) {
      System.out.println("rotator arm motor not detected");
    }
    try{
      clawMotor = new WPI_TalonSRX(8);
    }
    catch(Exception e){
      System.out.println("no claw");
    }
    try{
      gripMotor = new WPI_TalonSRX(9);
    }
    catch(Exception e){
      System.out.println("no claw");
    }
    try{
        Drive = new WPI_TalonFX(3);
    }
    catch(Exception e){
      System.out.println("Something");
    }
    try{
      IntakeMotorBottom = new CANSparkFlex(1, MotorType.kBrushless);
    }
    catch(Exception e){
      System.out.println("Missing Left Shooting Motor");
    }
    try{
      IntakeMotorTop = new CANSparkFlex(2, MotorType.kBrushless);
    }
    catch(Exception e){
      System.out.println("Missing Right Shooting Motor");
    }
    try{
      StagingMotorBottom = new CANSparkFlex(3, MotorType.kBrushless);
    }
    catch(Exception e){
      System.out.println("Missing Bottom Staging Motor");
    }
    try{
      StagingMotorTop = new CANSparkFlex(4, MotorType.kBrushless);
    }
    catch(Exception e){
      System.out.println("Missing Top Staging Motor");
    }
   // ArmMotor.setInverted(true);
   //OuterArmMotor.setInverted(true);
    innerArmMotor.setInverted(true);
    innerArmMotor.setNeutralMode(NeutralMode.Coast);
    armRotationMotor.setInverted(true);
    //ShootingMotor.setNeutralMode;
    //ShootingMotor2.
  }

  public void ArmControl(double armSpeed){
     double newArmSpeed = (armSpeed-(armSpeed*0.4));
    ArmMotor.set(newArmSpeed);

  }

  public void ClawControl(double clawSpeed){
  // switch ((int)clawSpeed) {
   //  case 0:
   double newClawSpeed = (clawSpeed-(clawSpeed*0.2));

       clawMotor.set(newClawSpeed);
      //  break;
    //case 180:
    //clawMotor.set(-1);
     // default:
      //clawMotor.set(0);
       // break;
    //}
    
  }
  public void ClawIn(){
    gripMotor.set(0.8);
  }

  public void ClawOut(){
    gripMotor.set(-0.8);
  }
  public void ClawStop(){
    gripMotor.set(0);
  }
  public void IntakeIn(){
    IntakeMotorBottom.set(.2);
    IntakeMotorTop.set(.2);
  }
  public void IntakeOff(){
   // IntakeMotorBottom.set(0);
    //IntakeMotorTop.set(0);
  }
  public void StagingIn(){
    StagingMotorBottom.set(.15);
    StagingMotorTop.set(-.15);
  }
  public void StagingOff(){
    StagingMotorBottom.set(0);
    StagingMotorTop.set(0);
  }
  public void DriveOn(){
    Drive.set(1);
  }
  public void DriveOff(){
    Drive.set(0);
  }
  /* 
  public void HangOn(){
    HangMotor1.set(.5);
    HangMotor2.set(.9);
  }
  public void HangOff(){
    HangMotor1.set(0);
    HangMotor2.set(0);
  }
*/

 

  public void OuterArmControl(double outerArmSpeed){
    double newArmSpeedOuter = (outerArmSpeed-(outerArmSpeed*0.6));
    OuterArmMotor.set(newArmSpeedOuter);
  }

  public void innerArmControl(double innerArmSpeed ){
    double newArmSpeedInner = (innerArmSpeed-(innerArmSpeed*0));
    innerArmMotor.set(newArmSpeedInner);
  }

  public void armRotationControl(double rotationSpeed ){
    double newRotationSpeed = (rotationSpeed-(rotationSpeed*0.7));
    armRotationMotor.set(newRotationSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
