import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class Volvo240Test {
    @Test
    public void testConstructor(){
        Volvo240 volvo240 = new Volvo240();
        assertTrue(volvo240.getNrDoors() == 4);
        assertTrue(volvo240.getEnginePower() == 100);
        assertTrue(volvo240.getColor() == Color.black);
        assertTrue(volvo240.getModelName() == "Volvo240");
        assertTrue(volvo240.getTurnSpeed() == 0.1);


        assertTrue(volvo240.getX() == 0.0);
        assertTrue(volvo240.getY() == 0.0);
    }

    @Test
    public void testGasVolvo240(){
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        double speed = volvo240.getCurrentSpeed();
        volvo240.gas(1);
        volvo240.gas(2);

        assertTrue(speed < volvo240.getCurrentSpeed());
    }

    @Test
    public void brakeVolvo240(){
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        volvo240.gas(1);
        double speed = volvo240.getCurrentSpeed();
        volvo240.brake(1);
        volvo240.brake(2);

        assertTrue(speed > volvo240.getCurrentSpeed());
    }


    @Test
    public void startEngineVolvo240(){
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        assertTrue(volvo240.isEngineOn());
    }

    @Test
    public void moveVolvo240(){
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        volvo240.gas(0.5);
        volvo240.move();

        assertTrue( 0< volvo240.getX());
    }

    @Test
    public void turnRightVolvo240(){
        Volvo240 volvo240 = new Volvo240();
        volvo240.setAngle(Math.PI);
        volvo240.turnRight();
        assertTrue(volvo240.getAngle()<Math.PI);
    }

    @Test
    public void turnLeftVolvo240(){
        Volvo240 volvo240 = new Volvo240();
        volvo240.setAngle(Math.PI);
        volvo240.turnLeft();
        assertTrue(volvo240.getAngle()>Math.PI);
    }
}