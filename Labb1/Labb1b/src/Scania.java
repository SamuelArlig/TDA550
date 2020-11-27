import java.awt.*;

/**
 * A Scania
 * Has:
 * 2 doors
 * 660 engine power
 * 0.07 radians turn speed
 * A bed that can be raised and lowered
 */
public class Scania extends Truck {

    /**
     * Create a gray Scania truck
     */
    public Scania() {
        super(70, 2, 660, Color.gray, "Scania", 0.07);

        stopEngine();
    }



    /**
     * Returns the speed factor of the car
     *
     * @return the speed factor of the car
     */
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.001;
    }

    /**
     * Raises the bed angle by amount
     *
     * @param radians the angle to raise the bed, in radians
     */
    public void raiseBed(double radians) {
        setBedAngle(getBedAngle() + radians);
    }

    /**
     * Lowers the bed angle by radians
     *
     * @param radians is the angle by which to lower the bed, in radians.
     */
    public void lowerBed(double radians) {
        setBedAngle(getBedAngle() - radians);
    }
}

