import java.awt.*;

/**
 * A generic car that can be accelerated, decelerated and steered
 */
public abstract class Car implements Movable {
    /** Number of doors on the car */
    protected int nrDoors;
    /** Engine power of the car */
    protected double enginePower;
    /** The current speed of the car */
    protected double currentSpeed;
    /** Color of the car */
    protected Color color;
    /** The car model name */
    protected String modelName;

    /** The car's x position */
    protected double x = 0;
    /** The car's y position */
    protected double y = 0;
    /** The car's angle in radians */
    protected double angle = 0;
    /** How fast the car turns in radians */
    protected double turnSpeed;

    /**
     * Returns the number of doors
     *
     * @return the number of doors on the car
     */
    public int getNrDoors(){
        return nrDoors;
    }
    /**
     * Returns the cars engine power
     *
     * @return the cars engine power
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Returns the cars current speed
     *
     * @return the cars current speed
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Returns the color of the car
     *
     * @return the color of the car
     */
    public Color getColor(){
        return color;
    }

    /**
     * Set the color of the car
     * @param clr the new {@code Color} for the car
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Starts the engine of the car.
     *
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Stops the engine of the car
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Returns the speed factor of the car
     * @return the speed factor of the car
     */
    protected abstract double speedFactor();

    /**
     * Increases the speed of the car by a factor amount
     * Can't increase speed over enginePower
     * @param amount amount to increase the speed, must be > 0
     */
    private void incrementSpeed(double amount){
        amount = Math.max(0, amount);
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /**
     * Decreases the speed of the car by amount * speedFactor
     * Can't decrease speed below 0
     * @param amount amount to decrease the speed, must be > 0
     */
    private void decrementSpeed(double amount){
        amount = Math.max(0, amount);
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    /**
     * Increases the speed of the car
     *
     * @param amount amount to increment speed, must be between 0 and 1.
     */
    public void gas(double amount){
        amount = Math.max(0, Math.min(amount, 1));
        incrementSpeed(amount);
    }

    /**
     * Decrease the speed of the car
     *
     * @param amount amount to decrement speed, must be between 0 and 1.
     */
    public void brake(double amount){
        amount = Math.max(0, Math.min(amount, 1));
        decrementSpeed(amount);
    }


    /**
     * Turn the car turnSpeed radians to the left
     */
    @Override
    public void turnLeft() {
        angle += turnSpeed;
        angle %= (Math.PI * 2);
    }

    /**
     * Turn the car turnSpeed radians to the right
     */
    @Override
    public void turnRight() {
        angle -= turnSpeed;
        angle %= (Math.PI * 2);
    }

    /**
     * Move the car currentSpeed units in its current direction
     */
    @Override
    public void move() {
        x += currentSpeed*Math.cos(angle);
        y += currentSpeed*Math.sin(angle);
    }
}
