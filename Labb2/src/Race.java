import java.util.LinkedList;

/**
 * Run a race between cars in the console
 */
public class Race {
    /**
     * Run a race between a Saab95 with turbo and a Volvo240
     *
     * @param args Don't matter
     */
    public static void main(String[] args) {

        Saab95 saab = new Saab95();

        Car[] cars = new Car[2];
        cars[0] = saab;
        cars[1] = new Volvo240();

        for(Car car : cars){
            car.startEngine();
        }

        for(int i = 0; i < 10; i++){
            if(saab.getCurrentSpeed() > 5){
                saab.setTurboOn();
            }

            for(Car car : cars){
                car.gas(1);
                car.move();

                if(car.getX() > 50){
                    car.turnLeft();
                }

                // System.out.println(car.getModelName() + ": x:" + car.getX() + ", y: " + car.getY() + ", Speed: " + car.getCurrentSpeed());
            }
        }

    }
}

