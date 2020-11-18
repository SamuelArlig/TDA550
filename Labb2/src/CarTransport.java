import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class CarTransport extends Truck implements Loadable<Car> {

    private LinkedList<Car> carList;
    private int maxLoad;


    protected CarTransport(){
        super(110,2, 660, Color.CYAN, "Transporty McTransportFace", 0.01);
        this.carList = new LinkedList<>();
    }

    /**
     * Returns the speed factor of the car
     *
     * @return the speed factor of the car
     */
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.001/ carList.size();
    }

    @Override
    public void load(Car item) {
        if(carList.size() < maxLoad){
            carList.add(item);
        }
    }

    @Override
    public void unload(Car item) {

    }

    public void raiseRamp() {
        setBedAngle(0);
    }

    public void lowerRamp() {
        setBedAngle(getMaxBedAngle());
    }

    public boolean isRampDown(){
        return getBedAngle() == getMaxBedAngle();
    }
}
