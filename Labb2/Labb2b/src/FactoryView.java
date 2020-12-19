import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FactoryView extends JPanel{
    private JButton addButton = new JButton("Add");
    private JButton removeButton = new JButton("Remove");

    public FactoryView(int sizeX, int sizeY){
        initComponents(sizeX, sizeY);
    }

    // Sets everything in place and fits everything
    private void initComponents(int sizeX, int sizeY) {

        this.setPreferredSize(new Dimension(sizeX, sizeY));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        add(addButton);
        add(removeButton);
    }

    public JButton getAddButton(){
        return addButton;
    }

    public JButton getRemoveButton(){
        return removeButton;
    }
}
