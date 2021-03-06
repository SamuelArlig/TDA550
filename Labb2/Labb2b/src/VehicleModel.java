import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VehicleModel {

    private static final double VEHICLE_Y_SPACING = 62;

    private List<Car> cars = new ArrayList<>();
    private int trackLength;

    public VehicleModel(int trackLength){
        cars.add(CarFactory.CreateVolvo240(0,(cars.size())*VEHICLE_Y_SPACING));
        cars.add(CarFactory.CreateSaab95(0,(cars.size())*VEHICLE_Y_SPACING));
        cars.add(CarFactory.CreateScania(0,(cars.size())*VEHICLE_Y_SPACING));

        this.trackLength = trackLength;
    }

    public void addRandomCar(){
        if(cars.size() >=  10){
            return;
        }

        int random = new Random().nextInt(3);
        switch (random) {
            case 0 -> cars.add(CarFactory.CreateVolvo240(0, (cars.size()) * VEHICLE_Y_SPACING));
            case 1 -> cars.add(CarFactory.CreateSaab95(0, (cars.size()) * VEHICLE_Y_SPACING));
            case 2 -> cars.add(CarFactory.CreateScania(0, (cars.size()) * VEHICLE_Y_SPACING));
        }
    }

    public void removeRandomCar(){
        if(cars.size()>0) {
            int randomIndex = new Random().nextInt(cars.size());
            removeCar(cars.get(randomIndex));
        }
    }

    private void removeCar(Car car){
        cars.remove(car);
        int index = 0;
        for(Car otherCar : cars){
            otherCar.setPosition(otherCar.getX(),index * VEHICLE_Y_SPACING);
            index++;
        }
    }

    public void update(){
        for(Car car : cars){
            car.move();

            if(car.getX() >= trackLength - VehicleView.IMAGE_WIDTH){
                car.setAngle(Math.PI);
            }
            if(car.getX() <= 0){
                car.setAngle(0);
            }
        }

        notifyObservers();
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    void startCars(){
        for (Car car : cars) {
            car.startEngine();
        }
    }

    void stopCars(){
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    void setTurboOn(){
        for (Car car : cars) {
            // Only Saab95 has turbo
            if (car.getClass() == Saab95.class){
                ((Saab95)car).setTurboOn();
            }
        }
    }

    void setTurboOff(){
        for (Car car : cars) {
            if (car.getClass() == Saab95.class){
                ((Saab95)car).setTurboOff();
            }
        }
    }

    void liftBeds(){
        for(Car car : cars) {
            if(car.getClass() == Scania.class){
                ((Scania)car).raiseBed(45);
            }
        }
    }

    void lowerBeds(){
        for(Car car : cars) {
            if(car.getClass() == Scania.class){
                ((Scania)car).lowerBed(45);
            }
        }
    }


    public List<Car> getCars(){
        return cars;
    }



    // Observable
    private List<VehicleModelObserver> observers = new ArrayList<>();

    public void addObserver(VehicleModelObserver observer){
        observers.add(observer);
    }

    public void removeObserver(VehicleModelObserver observer){
        observers.remove(observer);
    }

    protected void notifyObservers(){
        for(VehicleModelObserver observer : observers){
            observer.onNotify(this);
        }
    }
}
