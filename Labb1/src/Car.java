import java.awt.*;

public abstract class Car implements Movable {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

    protected double x = 0;
    protected double y = 0;
    protected double angle = 0; // Radians
    protected double turnSpeed; // Radians

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    protected abstract double speedFactor();

    protected abstract void incrementSpeed(double amount);
    protected abstract void decrementSpeed(double amount);

    public void gas(double amount){
        amount = Math.max(0, Math.min(amount, 1));
        incrementSpeed(amount);
    }

    public void brake(double amount){
        amount = Math.max(0, Math.min(amount, 1));
        decrementSpeed(amount);
    }

    @Override
    public void turnLeft() {
        angle += turnSpeed;
        angle %= (Math.PI * 2);
    }

    @Override
    public void turnRight() {
        angle -= turnSpeed;
        angle %= (Math.PI * 2);
    }

    @Override
    public void move() {
        x += currentSpeed*Math.cos(angle);
        y += currentSpeed*Math.sin(angle);
    }
}
