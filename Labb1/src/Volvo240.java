import java.awt.*;

/**
 * A Volvo240
 * Has:
 * 4 doors
 * 100 engine power
 * 0.1 radians turn speed
 */
public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    /**
     * Create a black Volvo240
     */
    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        turnSpeed = 0.1;
        stopEngine();
    }

    @Override
    protected double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

}
