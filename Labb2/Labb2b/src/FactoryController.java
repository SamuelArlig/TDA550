import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FactoryController{
    private VehicleModel vehicleModel;


    // Constructor
    public FactoryController(VehicleModel vehicleModel){
        this.vehicleModel = vehicleModel;
    }

    public void initComponents(FactoryView factoryView) {


        factoryView.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleModel.addRandomCar();
            }
        });

        factoryView.getRemoveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleModel.removeRandomCar();
            }
        });
    }
}
