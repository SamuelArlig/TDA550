import java.awt.*;

public class Scania extends Car {

    private static final double MAX_BED_ANGLE = 70.0 * Math.PI / 180.0;
    private static final double UNLOAD_ANGLE = 60.0 * Math.PI / 180.0;
    private static final double MAX_LOAD = 10000;

    /** Bed angle radians */
    private double bedAngle;
    private double loadWeight;

    /**
     * Create a gray Scania truck
     */
    public Scania(){
        modelName = "Scania";
        nrDoors = 2;
        color = Color.gray;
        enginePower = 660;
        turnSpeed = 0.07;
        loadWeight = 0;

        stopEngine();
    }

    /**
     * Starts the engine of the car
     */
    @Override
    public void startEngine(){
        if(bedAngle == 0){
            super.startEngine();
        }
    }

    /**
     * Returns the speed factor of the car
     * @return the speed factor of the car
     */
    @Override
    protected double speedFactor() {
        if(bedAngle != 0){
            return 0;
        }
        return enginePower*0.01/(loadWeight + 1);
    }

    /**
     * Loads the truck with weight, up to its max load.
     * @param weight is the weight of the load.
     */
    public void load(double weight){
        loadWeight += weight;
        loadWeight = Math.min(loadWeight, MAX_LOAD);
    }

    /**
     * Unloads the truck, down to a minimum of 0
     * @param weight is the weight to be unloaded
     */
    public void unload(double weight){
        loadWeight -= weight;
        loadWeight = Math.max(loadWeight, 0);
    }

    /**
     * Raises the bed angle by amount, unloads if bed angle is greater than unload angle.
     * @param radians
     */
    public void raiseBed(double radians){
        if(getCurrentSpeed() != 0){
            return;
        }

        bedAngle += radians;
        bedAngle = Math.min(bedAngle, MAX_BED_ANGLE);


        if(bedAngle > UNLOAD_ANGLE){
            unload(MAX_LOAD);
        }
    }

    /**
     * Lowers the bed angle by radians
     * @param radians is the angle by which to lower the bed, in radians.
     */
    public void lowerBed(double radians){
        bedAngle -= radians;
        bedAngle = Math.max(bedAngle, 0);
    }

    /**
     *Returns bed angle of truck bed.
     * @return bed a angle of truck bed.
     */
    public double getBedAngle(){
        return bedAngle;
    }
}
