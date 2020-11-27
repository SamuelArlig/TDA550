import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CarTransportTest {

    @Test
    public void testLoadingCarsRampUp(){
        CarTransport carTransport = new CarTransport(4);
        Car saab = new Saab95();
        assertFalse(carTransport.load(saab));

    }

    @Test
    public void testLoadingCarsRampDown(){
        CarTransport carTransport = new CarTransport(4);
        carTransport.lowerRamp();
        Car saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        carTransport.load(saab);
        carTransport.load(saab);
        assertTrue(carTransport.getLoadedCarCount()==1);
        carTransport.load(volvo);
        assertTrue(carTransport.getLoadedCarCount()==2);

    }

    @Test
    public void testLoadingCarsFullCapacity(){
        CarTransport carTransport = new CarTransport(1);
        carTransport.lowerRamp();
        Car saab = new Saab95();
        Car saab1 = new Saab95()
;
        carTransport.load(saab);
        carTransport.load(saab1);

        assertTrue(carTransport.getLoadedCarCount()==1);

    }
}
