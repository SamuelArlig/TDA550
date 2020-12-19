import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationEngine extends JFrame {

    private static final int X = 800;
    private static final int Y = 800;
    private static final int TRACK_HEIGHT = 400;
    private static final int CONTROLLER_HEIGHT = 230;

    private final int delay = 50;

    private Timer timer = new Timer(delay, new SimulationEngine.TimerListener());

    private VehicleModel vehicleModel;
    private ControlPanelView controlPanelView;
    private VehicleView vehicleView;
    private InfoView infoView;
    private FactoryView factoryView;

    private FactoryController factoryController;
    private VehicleController vehicleController;

    public SimulationEngine(){

        vehicleModel = new VehicleModel(X);
        vehicleView = new VehicleView(X, TRACK_HEIGHT);
        controlPanelView = new ControlPanelView(X, CONTROLLER_HEIGHT);

        infoView = new InfoView(X/2, 50);
        factoryView = new FactoryView(X/2, 100);

        vehicleController = new VehicleController(vehicleModel);
        vehicleController.initComponents(controlPanelView);

        factoryController = new FactoryController(vehicleModel);
        factoryController.initComponents(factoryView);

        vehicleModel.addObserver(vehicleView);
        vehicleModel.addObserver(infoView);

        timer.start();


        initGUI();
    }

    private void initGUI(){
        this.setTitle("CarSim 2.0");
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(vehicleView);
        this.add(controlPanelView);
        JPanel bottomBar = new JPanel();
        bottomBar.setPreferredSize(new Dimension(X, 100));
        bottomBar.setLayout(new GridLayout(1, 2));
        bottomBar.add(infoView);
        bottomBar.add(factoryView);
        this.add(bottomBar);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();
        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            vehicleModel.update();
        }
    }

    public static void main(String[] args) {
        new SimulationEngine();
    }
}
