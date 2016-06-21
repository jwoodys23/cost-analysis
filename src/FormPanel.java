import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jourdanwoodrich on 6/19/16.
 */
public class FormPanel extends JPanel {

    private JLabel partNameLabel;
    private JLabel partNumberLabel;
    private JLabel materialCostLabel;
    private JLabel laborCostLabel;
    private JLabel freightCostLabel;

    private JTextField partNameField;
    private JTextField partNumberField;
    private JTextField materialCostField;
    private JTextField laborCostField;
    private JTextField freightCostField;
    private JCheckBox customFreight;
    private JButton okBtn;
    private FormListener formListener;


    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 275;
        setPreferredSize(dim);

        //Labels
        partNameLabel = new JLabel("Part name: ");
        partNumberLabel = new JLabel("Part Number: ");
        materialCostLabel = new JLabel("Material Cost:");
        laborCostLabel = new JLabel("Labor Cost: ");
        freightCostLabel = new JLabel("Freight Cost: ");

        //Fields
        partNameField = new JTextField(10);
        partNumberField = new JTextField(10);
        materialCostField = new JTextField(10);
        laborCostField = new JTextField(10);
        freightCostField = new JTextField(10);

        // Buttons
        okBtn = new JButton("Add Part");

        customFreight = new JCheckBox();

        // Set up freight checkbox
        freightCostLabel.setEnabled(false);
        freightCostField.setEnabled(false);

        customFreight.addActionListener(e -> {
            boolean isTicked = customFreight.isSelected();
            freightCostLabel.setEnabled(isTicked);
            freightCostField.setEnabled(isTicked);
        });

        okBtn.addActionListener(e -> {
            String partName = partNameField.getText();
            String partNumber = partNumberField.getText();
            String materialCost = materialCostField.getText();
            String laborCost = laborCostField.getText();
            String freightCost = freightCostField.getText();

            FormEvent ev = new FormEvent(this, partName, partNumber,materialCost,laborCost,freightCost);
            if (formListener!=null){
                formListener.formEventOccurred(ev);
            }

        });


        Border innerBorder = BorderFactory.createTitledBorder("Add New Part");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 1;
        gc.weighty = 0.2;

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
        gc.weighty = 0.2;

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
        gc.weighty = 0.2;
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
        gc.weighty = 0.2;
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
        gc.weighty = 0.2;
        gc.gridx = 0;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(new JLabel("Custom Freight:"),gc);

        gc.gridx = 1;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(customFreight, gc);

        //////// SIXTH ROW /////////////

        gc.weightx = 1;
        gc.weighty = 0.2;
        gc.gridx = 0;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(freightCostLabel,gc);

        gc.gridx = 1;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(freightCostField, gc);

        //////// SEVENTH ROW /////////////

        gc.weightx = 1;
        gc.weighty = 2.0;
        gc.gridx = 1;
        gc.gridy = 6;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(okBtn, gc);

    }
    public void setFormListener(FormListener listener){
        this.formListener = listener;

    }
}
