import java.awt.*;

/**
 * A Saab95
 * Has:
 * 2 doors
 * 125 engine power
 * 0.1 radians turn speed
 * Turbo, which if on increases speed
 */
public class Saab95 extends Car {

    private boolean turboOn;

    /**
     * Create a red Saab95 with turbo off
     */
    public Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        turnSpeed = 0.1;
        stopEngine();
    }

    /**
     * Turns the turbo on
     */
    public void setTurboOn(){
	    turboOn = true;
    }
    /**
     * Turns the turbo off
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    /**
     * Checks if the turbo is on
     * @return true if turbo is on
     */
    public boolean IsTurboOn(){
        return turboOn;
    }
}
