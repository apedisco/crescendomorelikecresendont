// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lights extends SubsystemBase {
  int ledport = 0;
  int ledBufferSize = 200;
  private AddressableLED ledStrip;
  private AddressableLEDBuffer lightsBuffer= new AddressableLEDBuffer(ledBufferSize);
  /** Creates a new Camera. */
  public Lights() {
    try {
      ledStrip = new AddressableLED(ledport);
    } catch (Exception e) {
      System.out.println("no leds");
    }
    ledStrip.setLength(ledBufferSize);
  }

  public void setRGBs(int red, int green, int blue){
    for(int i = 0; i<ledBufferSize;i++){
      lightsBuffer.setRGB(i, red, green, blue);
      SmartDashboard.putNumber("light cycle", i);
    }

   ledStrip.setData(lightsBuffer);
   ledStrip.start();
   
    SmartDashboard.putBoolean("leds triggere", true);
  }

  public void setRGBBlue(){
    //lightsBuffer.setRGBs(0, 0, 255);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
