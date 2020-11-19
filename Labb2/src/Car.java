import java.awt.*;

/**
 * A generic car that can be accelerated, decelerated and steered
 */
public abstract class Car implements Movable {
    /** Number of doors on the car */
    private int nrDoors;
    /** Engine power of the car */
    private double enginePower;
    /** The current speed of the car */
    private double currentSpeed;
    /** Color of the car */
    private Color color;
    /** The car model name */
    private String modelName;
    /** The car size */
    private int size;

    /** The car's x position */
    private double x = 0;
    /** The car's y position */
    private double y = 0;
    /** The car's angle in radians */
    private double angle = 0;
    /** How fast the car turns in radians */
    private double turnSpeed;


    private boolean isEngineOn = false;

    /**
     * Creates a car with the specified parameters
     * @param nrDoors the number of doors on the car
     * @param enginePower the engine power of the car
     * @param color the color of the car
     * @param modelName the model name of the car
     * @param turnSpeed the turn speed of the car, in radians
     * @param size size class of the car
     */
    protected Car(int nrDoors, double enginePower, Color color, String modelName, double turnSpeed,int size ){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.turnSpeed = turnSpeed;
        this.size = size;

        stopEngine();
    }


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
     * Check if the cars engine is turned on
     * @return true if engine is on
     */
    public boolean isEngineOn(){
        return isEngineOn;
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
     * Returns the size of the car
     *
     * @return the size of the car
     */
    public int getSize(){
        return size;
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
     * Get the model name
     * @return model name
     */
    public String getModelName(){
        return  modelName;
    }

    /**
     * Get the car's turn speed
     * @return turn speed
     */
    public double getTurnSpeed(){
        return  turnSpeed;
    }

    /**
     * Get the car's angle
     * @return current angle in radians
     */
    public double getAngle(){
        return angle;
    }

    /**
     * Set the car's angle
     * @param angle new angle in radians
     */
    public void setAngle(double angle){
        this.angle = angle;
    }

    /**
     * Set the car's x position
     * @return x position
     */
    public double getX() {
        return x;
    }

    /**
     * Set the car's y position
     * @return y position
     */
    public double getY() {
        return y;
    }

    /**
     * Sets the position of the car
     * @param x x position
     * @param y y position
     */
    public void setPosition(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * Get the distance to another car
     * @param other The other car
     * @return the distance between the two cars
     */
    public double distanceTo(Car other){
        double dx = x - other.getX();
        double dy = y - other.getY();

        return Math.sqrt(dx * dx + dy * dy);
    }


    /**
     * Starts the engine of the car.
     *
     */
    public void startEngine(){
        isEngineOn = true;
    }

    /**
     * Stops the engine of the car
     */
    public void stopEngine(){
        isEngineOn = false;
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
        if(!isEngineOn){
            return;
        }

        if(amount < 0 || amount > 1){
            return;
        }

        incrementSpeed(amount);
    }

    /**
     * Decrease the speed of the car
     *
     * @param amount amount to decrement speed, must be between 0 and 1.
     */
    public void brake(double amount){
        if(amount < 0 || amount > 1){
            return;
        }
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
        setPosition(x + currentSpeed*Math.cos(angle), y + currentSpeed*Math.sin(angle));
    }
}
