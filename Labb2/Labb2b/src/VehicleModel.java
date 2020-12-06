import java.util.ArrayList;
import java.util.List;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class VehicleModel {

    private ArrayList<Car> cars = new ArrayList<>();
    private int trackLength;

    public VehicleModel(int trackLength){
        cars.add(new Volvo240(0,(cars.size())*100));
        cars.add(new Saab95(0,cars.size()*100));
        cars.add(new Scania(0,cars.size()*100));

        this.trackLength = trackLength;
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
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
}
