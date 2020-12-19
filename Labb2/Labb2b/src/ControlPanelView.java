import javax.swing.*;
import java.awt.*;

public class ControlPanelView extends JPanel {
    private JPanel controlPanel = new JPanel();

    private JLabel gasLabel = new JLabel("Amount of gas");

    private JPanel gasPanel = new JPanel();
    private JSpinner gasSpinner = new JSpinner();

    private JButton gasButton = new JButton("Gas");
    private JButton brakeButton = new JButton("Brake");
    private JButton turboOnButton = new JButton("Saab Turbo on");
    private JButton turboOffButton = new JButton("Saab Turbo off");
    private JButton liftBedButton = new JButton("Scania Lift Bed");
    private JButton lowerBedButton = new JButton("Lower Lift Bed");

    private JButton startButton = new JButton("Start all cars");
    private JButton stopButton = new JButton("Stop all cars");

    public ControlPanelView(int sizeX, int sizeY){
        initComponents(sizeX, sizeY);
    }

    // Sets everything in place and fits everything
    private void initComponents(int sizeX, int sizeY) {
        this.setPreferredSize(new Dimension(sizeX, sizeY));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(70, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((sizeX/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(sizeX/5-15,200));
        this.add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(sizeX/5-15,200));
        this.add(stopButton);
    }


    public JSpinner getGasSpinner(){
        return gasSpinner;
    }

    public JButton getGasButton(){
        return gasButton;
    }
    public JButton getBrakeButton(){
        return brakeButton;
    }
    public JButton getTurboOnButton(){
        return turboOnButton;
    }
    public JButton getTurboOffButton(){
        return turboOffButton;
    }
    public JButton getLiftBedButton(){
        return liftBedButton;
    }
    public JButton getLowerBedButton(){
        return lowerBedButton;
    }
    public JButton getStartButton(){
        return startButton;
    }
    public JButton getStopButton(){
        return stopButton;
    }
}
