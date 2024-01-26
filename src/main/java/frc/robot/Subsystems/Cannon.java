package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
//import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Cannon extends SubsystemBase{
    public Compressor compressor;
    public DoubleSolenoid valve;
    //public Solenoid valveS;


    public Cannon(){
        //compressor = new Compressor(1, PneumaticsModuleType.CTREPCM);
        valve = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
        //valveS = new Solenoid(PneumaticsModuleType.CTREPCM, 0);


        //compressor.enableDigital();
        //compressor.disable();

        valve.set(Value.kOff);
        valve.set(Value.kForward);
        valve.set(Value.kReverse);


        //boolean pressureSwitch = compressor.getPressureSwitchValue();
        //double current = compressor.getCurrent();
    }

    
    
    public void valveOpen(){
        valve.set(DoubleSolenoid.Value.kForward);
    }
    
    public void valveClose(){
        valve.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void disableValvesOperation(){
        valve.set(DoubleSolenoid.Value.kOff);
    }


}
