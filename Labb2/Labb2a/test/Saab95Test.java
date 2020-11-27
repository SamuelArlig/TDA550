import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class Saab95Test {

    private Saab95 saab95;

    @Before
    public void init(){
        saab95 = new Saab95();
    }

    @Test
    public void testConstructor(){
        assertTrue(saab95.getNrDoors() == 2);
        assertTrue(saab95.getEnginePower() == 125);
        assertTrue(saab95.getColor() == Color.red);
        assertTrue(saab95.getCurrentSpeed() == 0);
        assertFalse(saab95.IsTurboOn());
    }

    @Test
    public void testSetColor(){
        saab95.setColor(Color.black);
        assertTrue(saab95.getColor() == Color.black);
    }

    @Test
    public void testTurboAndSpeedFactor(){
        double speedFactorTurboOff = saab95.speedFactor();
        saab95.setTurboOn();
        assertTrue(speedFactorTurboOff < saab95.speedFactor());
        saab95.setTurboOff();
        assertTrue(speedFactorTurboOff == saab95.speedFactor());
    }

}
