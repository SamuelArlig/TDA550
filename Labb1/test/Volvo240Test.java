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
        assertTrue(volvo240.modelName == "Volvo240");
        assertTrue(volvo240.turnSpeed == 0.1);
    }
    @Test
    public void testIncrementVolvo240(){
        Volvo240 volvo240 = new Volvo240();
        double speed = volvo240.currentSpeed;
        volvo240.incrementSpeed(1);

        assertTrue(speed < volvo240.currentSpeed);
    }

    @Test
    public void testGasVolvo240(){
        Volvo240 volvo240 = new Volvo240();
        double speed = volvo240.currentSpeed;
        volvo240.gas(1);

        assertTrue(speed < volvo240.currentSpeed);
    }

    @Test
    public void decrementSpeedVolvo240(){
        Volvo240 volvo240 = new Volvo240();
        volvo240.currentSpeed = 10;
        double speed = volvo240.currentSpeed;
        volvo240.decrementSpeed(1);

        assertTrue(speed > volvo240.currentSpeed);
    }

    @Test
    public void brakeVolvo240(){
        Volvo240 volvo240 = new Volvo240();
        volvo240.currentSpeed = 10;
        double speed = volvo240.currentSpeed;
        volvo240.brake(1);

        assertTrue(speed > volvo240.currentSpeed);
    }


    @Test
    public void startEngineVolvo240(){
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        assertTrue(volvo240.currentSpeed > 0);
    }

    @Test
    public void moveVolvo240(){
        Volvo240 volvo240 = new Volvo240();
        volvo240.gas(0.5);
        volvo240.move();

        System.out.println(volvo240.x);
        assertTrue( 0< volvo240.x);
    }

    @Test
    public void turnRightVolvo240(){
        Volvo240 volvo240 = new Volvo240();
        volvo240.angle = Math.PI;
        volvo240.turnRight();
        assertTrue(volvo240.angle<Math.PI);
    }

    @Test
    public void turnLeftVolvo240(){
        Volvo240 volvo240 = new Volvo240();
        volvo240.angle = Math.PI;
        volvo240.turnLeft();
        assertTrue(volvo240.angle>Math.PI);
    }
}