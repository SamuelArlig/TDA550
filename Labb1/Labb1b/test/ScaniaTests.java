import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class ScaniaTests {
    @Test
    public void testConstuctor(){
        Scania scania = new Scania();

        assertTrue(scania.getNrDoors() == 2);
        assertTrue(scania.getEnginePower() == 660);
        assertTrue(scania.getColor() == Color.gray);
        assertTrue(scania.getModelName().equals("Scania"));

        assertTrue(scania.getBedAngle() == 0);

        assertTrue(scania.getMaxBedAngle() > 0);
    }

    @Test
    public void testBed(){
        Scania scania = new Scania();

        scania.raiseBed(13);
        assertTrue(scania.getBedAngle() == 13);
        scania.lowerBed(123);
        assertTrue(scania.getBedAngle() == 0);
        scania.raiseBed(20000);
        assertTrue(scania.getBedAngle() == scania.getMaxBedAngle());
    }

    @Test
    public void testBedWhileMoving(){
        Scania scania = new Scania();

        scania.startEngine();
        scania.gas(0.4);
        scania.raiseBed(13);
        assertTrue(scania.getBedAngle() == 0);

    }

}
