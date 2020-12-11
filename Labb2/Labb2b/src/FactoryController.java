import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FactoryController extends JPanel{
    private VehicleModel vehicleModel;

    private JButton addButton = new JButton("Add");
    private JButton removeButton = new JButton("Remove");

    // Constructor
    public FactoryController(VehicleModel vehicleModel, int sizeX, int sizeY){
        this.vehicleModel = vehicleModel;
        initComponents(sizeX, sizeY);
    }

    // Sets everything in place and fits everything
    private void initComponents(int sizeX, int sizeY) {

        this.setPreferredSize(new Dimension(sizeX, sizeY));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleModel.addRandomCar();
            }
        });

        add(removeButton);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleModel.removeRandomCar();
            }
        });
    }
}
