import java.awt.*;

public abstract class Truck extends Car {
    /** Maximum bed angle - degrees */
    private double maxBedAngle;

    /** Bed angle - degrees */
    private double bedAngle = 0.0;

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

    public double getBedAngle(){
        return bedAngle;
    }

    public double getMaxBedAngle(){
        return maxBedAngle;
    }

    protected void setBedAngle(double degrees){
        if (getCurrentSpeed() != 0) {
            return;
        }
        this.bedAngle = Math.max(0, Math.min(maxBedAngle, degrees));
    }
}
