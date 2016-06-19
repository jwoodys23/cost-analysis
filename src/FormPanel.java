import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by jourdanwoodrich on 6/19/16.
 */
public class FormPanel extends JPanel {

    private JLabel partNameLabel;
    private JLabel partNumberLabel;
    private JTextField partNameField;
    private JTextField partNumberField;
    private JButton okBtn;


    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        partNameLabel = new JLabel("Part name: ");
        partNumberLabel = new JLabel("Part Number: ");
        partNameField = new JTextField(20);
        partNumberField = new JTextField(20);
        okBtn = new JButton("Save Part");


        Border innerBorder = BorderFactory.createTitledBorder("Add New Part");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
    }
}
