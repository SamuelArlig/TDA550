import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

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

    @Override
    protected void incrementSpeed(double amount){
        amount = Math.max(0, amount);
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }
    @Override
    protected void decrementSpeed(double amount){
        amount = Math.max(0, amount);
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }
}
