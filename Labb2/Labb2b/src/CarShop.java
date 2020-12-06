import java.util.ArrayList;
import java.util.List;

/**
 * A car shop that can load cars of a specified type
 * @param <T> the type of car that can be handed in to the shop
 */
public class CarShop<T extends Car> implements Loadable<T>{
    private List<T> cars = new ArrayList<>();
    private int capacity;

    /**
     * Create a car shop with the given capacity
     * @param capacity the number of cars that can be in the shop at once
     */
    public CarShop(int capacity){
        this.capacity = capacity;
    }

    /**
     * Hand in a car to the car shop
     * @param item the car to be loaded
     * @return true if the car was loaded successfully
     */
    @Override
    public boolean load(T item) {
        if(cars.size() >= capacity){
            return false;
        }
        if(cars.contains(item)){
            return false;
        }

        cars.add(item);
        return true;
    }

    /**
     * Unloads a car from the shop
     * @param car the car to be unloaded
     * @return the unloaded car, or null if the car is not in the shop
     */
    @Override
    public T unload(T car) {
        if(cars.size()==0){
            return null;
        }
        if(cars.remove(car)){
            return car;
        }
        return null;
    }
}
