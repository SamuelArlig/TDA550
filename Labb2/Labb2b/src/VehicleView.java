import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// This panel represent the animated part of the view with the car images.

public class VehicleView extends JPanel implements VehicleModelObserver {
    public static int IMAGE_WIDTH = 100;

    // Images of all cars, key is model name
    private Map<String, BufferedImage> carImages = new HashMap<>();
    private List<Car> cars = new ArrayList<>();

    // Initializes the panel and reads the images
    public VehicleView(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ
            carImages.put("Volvo240", ImageIO.read(VehicleView.class.getResourceAsStream("pics/Volvo240.jpg")));
            carImages.put("Scania", ImageIO.read(VehicleView.class.getResourceAsStream("pics/Scania.jpg")));
            carImages.put("Saab95", ImageIO.read(VehicleView.class.getResourceAsStream("pics/Saab95.jpg")));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(Car car : cars) {
            g.drawImage(carImages.get(car.getModelName()), (int)car.getX(), (int)car.getY(), null);
        }
    }

    @Override
    public void onNotify(VehicleModel model) {
        this.cars = model.getCars();
        repaint();
    }
}
