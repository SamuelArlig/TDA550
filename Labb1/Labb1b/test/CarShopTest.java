import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CarShopTest {
    @Test
    public void testLoadingCars(){
        CarShop<Car> carShop = new CarShop<>(3);
        Car car1 = new Saab95();
        Car car2 = new Volvo240();
        Car car3 = new Scania();
        Car car4 = new Saab95();

        carShop.load(car1);
        carShop.load(car2);
        carShop.load(car3);
        carShop.load(car4);

        assertTrue(carShop.unload(car4) == null);
        assertTrue(carShop.unload(car2) == car2);

    }
}
