import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by jourdanwoodrich on 6/19/16.
 */
public class FormPanel extends JPanel {

    private JLabel partNameLabel;
    private JLabel partNumberLabel;
    private JLabel materialCostLabel;
    private JLabel laborCostLabel;

    private JTextField partNameField;
    private JTextField partNumberField;
    private JTextField materialCostField;
    private JTextField laborCostField;
    private JButton okBtn;


    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        //Labels
        partNameLabel = new JLabel("Part name: ");
        partNumberLabel = new JLabel("Part Number: ");
        materialCostLabel = new JLabel("Material Cost:");
        laborCostLabel = new JLabel("Labor Cost: ");

        //Fields
        partNameField = new JTextField(10);
        partNumberField = new JTextField(10);
        materialCostField = new JTextField(10);
        laborCostField = new JTextField(10);

        // Buttons
        okBtn = new JButton("Add Part");


        Border innerBorder = BorderFactory.createTitledBorder("Add New Part");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 1;
        gc.weighty = 0.1;

        //////// FIRST ROW /////////////
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(partNameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(partNameField,gc);

        //////// SECOND ROW /////////////

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(partNumberLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(partNumberField, gc);

        //////// THIRD ROW /////////////

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(materialCostLabel,gc);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(materialCostField, gc);

        //////// FOURTH ROW /////////////

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(laborCostLabel,gc);

        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(laborCostField, gc);

        //////// FIFTH ROW /////////////

        gc.weightx = 1;
        gc.weighty = 2.0;
        gc.gridx = 1;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(okBtn, gc);

    }
}
