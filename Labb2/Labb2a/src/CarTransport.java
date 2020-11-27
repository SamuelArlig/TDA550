import java.awt.*;
import java.util.LinkedList;

/**
 * A truck that can load and transport other cars
 */
public class CarTransport extends Truck implements Loadable<Car> {
    /** Ordered list of cars currently loaded */
    private LinkedList<Car> carList;
    /** Max number of cars the transport is able to carry */
    private int capacity;
    /** Maximum distance between transport and car at which the car can be loaded */
    private static final double LOAD_DISTANCE = 5;
    /** Maximum car size that the transport can load */
    private static final int MAX_SIZE = 1;
    /** Distance from the transport along y-axis at which cars are unloaded */
    private static final double UNLOAD_RELATIVE_Y = 2;

    /**
     * Creates a cyan car transport with a specified capacity
     * @param capacity number of cars the transport can hold at once
     */
    protected CarTransport(int capacity){
        super(110,2, 660, Color.CYAN, "Transporty McTransportFace", 0.01);
        this.carList = new LinkedList<>();

        this.capacity = capacity;
    }

    /**
     * Returns the speed factor of the car
     *
     * @return the speed factor of the car
     */
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.001/ carList.size();
    }

    /**
     * Loads a car if it is not the transport itself, it does not exceed the max size class,
     * there is space on the transport, the ramp is down, the car is not already loaded, and it is within the loading distance
     * @param item the car to be loaded
     * @return true if the car was loaded successfully
     */
    @Override
    public boolean load(Car item) {
        if(item == this){
            return false;
        }
        if(item.getSize() > MAX_SIZE){
            return false;
        }
        if(carList.size() >= capacity){
            return false;
        }
        if(!isRampDown()){
            return false;
        }
        if(carList.contains(item)){
            return false;
        }

        if(distanceTo(item) <= LOAD_DISTANCE){
            carList.add(item);
            return true;
        }
        return false;
    }

    /**
     * Unloads a car near the transport
     * @param car car to be unloaded
     * @return the unloaded car if the transport is non-empty, the ramp is down,
     * the car to be unloaded is at the back of the transport, and the car is on the transport, otherwise null
     */
    @Override
    public Car unload(Car car) {
        if(carList.size() == 0){
            return null;
        }
        if(!isRampDown()){
            return null;
        }
        if(carList.getLast() != car){
            return null;
        }
        if(!carList.contains(car)){
            return null;
        }

        carList.remove(car);
        car.setPosition(getX(), getY() + UNLOAD_RELATIVE_Y);
        return car;
    }

    /**
     * Sets current position of the transport and all cars currently loaded
     * @param x x position
     * @param y y position
     */
    @Override
    public void setPosition(double x, double y){
        super.setPosition(x, y);
        for(Car car : carList){
            car.setPosition(getX(), getY());
        }
    }

    /** Raises the ramp to the raised position at angle = 0*/
    public void raiseRamp() {
        setBedAngle(0);
    }

    /** Lowers the ramp to the lowered position at max angle */
    public void lowerRamp() {
        setBedAngle(getMaxBedAngle());
    }

    /**
     * Returns whether the ramp is lowered or not
     * @return whether the ramp is lowered
     */
    public boolean isRampDown(){
        return getBedAngle() == getMaxBedAngle();
    }

    /**
     * Returns number of cars currently loaded
     * @return number of cars currently loaded
     */
    public int getLoadedCarCount(){
        return carList.size();
    }
}
