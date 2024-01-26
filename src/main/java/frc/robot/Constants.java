package frc.robot;

public class Constants {
    
    public enum XBOX_BUTTON {
        XBOX_A_BUTTON(1), XBOX_B_BUTTON(2), XBOX_X_BUTTON(3), XBOX_Y_BUTTON(4), XBOX_LEFT_SHOULDER_BUTTON(5),
        XBOX_RIGHT_SHOULDER_BUTTON(6), XBOX_BACK_BUTTON(7), XBOX_START_BUTTON(8), XBOX_LEFT_INDEX_TRIGGER(9),
        XBOX_RIGHT_INDEX_TRIGGER(10);

        private final int value;

        XBOX_BUTTON(final int newValue){
            value = newValue;
        }

        public int getValue(){
            return value;
        }
    }

    public static final double DRIVETRAIN_TRACKWIDTH_METERS = .6731; 
    /**
     * The front-to-back distance between the drivetrain wheels.
     *
     * Should be measured from center to center.
     */
    public static final double DRIVETRAIN_WHEELBASE_METERS = .5726; 
    //public static final int DRIVETRAIN_PIGEON_ID = 0; 

    public static final int FRONT_LEFT_MODULE_DRIVE_MOTOR = 8; 
    public static final int FRONT_LEFT_MODULE_STEER_MOTOR = 12; 
    public static final int FRONT_LEFT_MODULE_STEER_ENCODER = 16;
    // public static final double FRONT_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(313.43); 
    public static final double FRONT_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(133.42); 

    public static final int FRONT_RIGHT_MODULE_DRIVE_MOTOR = 5; 
    public static final int FRONT_RIGHT_MODULE_STEER_MOTOR = 9; 
    public static final int FRONT_RIGHT_MODULE_STEER_ENCODER = 13;
    // public static final double FRONT_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(248.89);
    public static final double FRONT_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(68.8); 

    public static final int BACK_LEFT_MODULE_DRIVE_MOTOR = 7; 
    public static final int BACK_LEFT_MODULE_STEER_MOTOR = 11;
    public static final int BACK_LEFT_MODULE_STEER_ENCODER = 15; 
    // public static final double BACK_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(69.43);
    public static final double BACK_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(70.12);

    public static final int BACK_RIGHT_MODULE_DRIVE_MOTOR = 6;
    public static final int BACK_RIGHT_MODULE_STEER_MOTOR = 10; 
    public static final int BACK_RIGHT_MODULE_STEER_ENCODER = 14;
    // public static final double BACK_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(79.0125); 
    public static final double BACK_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(255.76); 

    public static final double DRIVE_SPEED_DAMPER = 0.9;
    public static final double DRIVE_ROTATION_DAMPER = 0.25;
}
