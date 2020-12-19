import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class VehicleController {

    // The controller member

    private VehicleModel vehicleModel;

    private int gasAmount = 0;

    // Constructor
    public VehicleController(VehicleModel vehicleModel){
        this.vehicleModel = vehicleModel;
    }

    public void initComponents(ControlPanelView controlView) {

        JSpinner gasSpinner = controlView.getGasSpinner();
        gasAmount = (int) gasSpinner.getValue();
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });


        controlView.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleModel.startCars();
            }
        });


        controlView.getStopButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleModel.stopCars();
            }
        });

        controlView.getTurboOnButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleModel.setTurboOn();
            }
        });

        controlView.getTurboOffButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleModel.setTurboOff();
            }
        });

        controlView.getLiftBedButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleModel.liftBeds();
            }
        });

        controlView.getLowerBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleModel.lowerBeds();
            }
        });



        // This actionListener is for the gas button only
        controlView.getGasButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleModel.gas(gasAmount);
            }
        });


        controlView.getBrakeButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleModel.brake(gasAmount);
            }
        });


    }

}