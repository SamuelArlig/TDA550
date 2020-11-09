import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;
    
    public Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        turnSpeed = 0.1;
        stopEngine();
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    @Override
    protected void incrementSpeed(double amount){
        amount = Math.max(0, amount);
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    @Override
    protected void decrementSpeed(double amount){
        amount = Math.max(0, amount);
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }


    public boolean IsTurboOn(){
        return turboOn;
    }
}
