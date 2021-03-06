import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InfoView extends JPanel implements VehicleModelObserver {

    private List<Car> cars = new ArrayList<>();

    public InfoView(int x, int y){
        this.setPreferredSize(new Dimension(x, y));
        //this.setBackground(Color.black);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int i = 1;
        for(Car car : cars) {
            g.drawString(car.getModelName() + ": " + car.getCurrentSpeed() , 0, i*10);
            i++;
        }
    }

    @Override
    public void onNotify(VehicleModel observed) {
        this.cars = observed.getCars();
        repaint();
    }
}
