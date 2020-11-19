import java.awt.*;


/**
 * Abstract truck with a bed that can be tilted up and down only when the truck is standing still
 * The truck can't start its engine if the bed angle != 0
 */
public abstract class Truck extends Car {
    /** Maximum bed angle - degrees */
    private double maxBedAngle;

    /** Bed angle - degrees */
    private double bedAngle = 0.0;

    /**
     * Creates a Truck with the specified parameters and size 2
     * @param maxBedAngle Max angle which truckbed can be raised
     * @param nrDoors the number of doors of the truck
     * @param enginePower the enginepower of the truck
     * @param color the color of the truck
     * @param modelName the model name of the car
     * @param turnSpeed the turn speed of the car
     */
    protected Truck(double maxBedAngle, int nrDoors, double enginePower, Color color, String modelName, double turnSpeed){
        super(nrDoors, enginePower, color, modelName, turnSpeed,2);

        this.maxBedAngle = maxBedAngle;
    }

    /**
     * Starts the engine of the car
     */
    @Override
    public void startEngine() {
        if (getBedAngle() == 0) {
            super.startEngine();
        }
    }

    /**
     * Get the current bed angle
     * @return the current bed angle
     */
    public double getBedAngle(){
        return bedAngle;
    }

    /**
     * Get the maximum bed angle
     * @return the maximum bed angle
     */
    public double getMaxBedAngle(){
        return maxBedAngle;
    }

    /**
     * Set the current bed angle
     * Bed angle can only change when the truck is standing still
     * @param degrees the new bed angle
     */
    protected void setBedAngle(double degrees){
        if (getCurrentSpeed() != 0) {
            return;
        }
        this.bedAngle = Math.max(0, Math.min(maxBedAngle, degrees));
    }
}
