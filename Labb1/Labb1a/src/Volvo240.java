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
        super(4, 100, Color.black, "Volvo240", 0.1);
    }

    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}
