package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.math.BigDecimal;

/**
 * Created by jourdanwoodrich on 6/19/16.
 */
public class FormPanel extends JPanel {

    private JLabel partNameLabel;
    private JLabel partNumberLabel;
    private JLabel actualMaterialCostLabel;
    private JLabel stdMaterialCostLabel;
    private JLabel actualLaborCostLabel;
    private JLabel stdLaborCostLabel;
    private JLabel freightCostLabel;


    private JTextField partNameField;
    private JTextField partNumberField;
    private JTextField materialCostField;
    private JTextField stdMaterialCostField;
    private JTextField laborCostField;
    private JTextField stdLaborCostField;
    private JTextField freightCostField;
    private JButton okBtn;
    private FormListener formListener;


    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 350;
        setPreferredSize(dim);

        //Labels
        partNameLabel = new JLabel("Part name: ");
        partNumberLabel = new JLabel("Part Number: ");
        actualMaterialCostLabel = new JLabel("Actual Material Cost: ");
        stdMaterialCostLabel = new JLabel("Std Material Cost: ");
        actualLaborCostLabel = new JLabel("Actual Labor Cost: ");
        stdLaborCostLabel = new JLabel("Std Labor Cost: ");
        freightCostLabel = new JLabel("Freight Cost: ");

        //Fields
        partNameField = new JTextField(10);
        partNumberField = new JTextField(10);
        materialCostField = new JTextField(10);
        stdMaterialCostField = new JTextField(10);
        laborCostField = new JTextField(10);
        stdLaborCostField = new JTextField(10);
        freightCostField = new JTextField(10);

        // Buttons
        okBtn = new JButton("Add Part");


        okBtn.addActionListener(e -> {
            String partName = partNameField.getText();
            String partNumber = partNumberField.getText();
            String matCostField = materialCostField.getText();
            String stdMatCostField = stdMaterialCostField.getText();
            String labCostField = laborCostField.getText();
            String stdLabCostField = stdLaborCostField.getText();
            String freightCostFieldValue = freightCostField.getText();

            //TODO: make material cost field accept empty value (Just add if statement )
            BigDecimal materialCost =  new BigDecimal(matCostField.replaceAll("[^.\\d]", ""));
            BigDecimal stdMat = new BigDecimal(stdMatCostField.replaceAll("[^.\\d]", ""));
            BigDecimal stdLab = new BigDecimal(stdLabCostField.replaceAll("[^.\\d]", ""));
            BigDecimal laborCost = new BigDecimal(labCostField.replaceAll("[^.\\d]", ""));
            BigDecimal freightCost = new BigDecimal(freightCostFieldValue.replaceAll("[^.\\d]", ""));

            BigDecimal laborVariance = laborCost.subtract(stdLab);
            BigDecimal materialVariance = materialCost.subtract(stdMat);
            String constant = "Variance";
            BigDecimal totalActual = materialCost.add(laborCost).add(freightCost);
            BigDecimal totalStandard = stdLab.add(stdLab).add(freightCost);



            FormEvent ev = new FormEvent(this, partName, partNumber,materialCost,stdMat, laborCost, stdLab, freightCost, laborVariance, materialVariance, constant, totalActual, totalStandard);
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
        add(actualMaterialCostLabel,gc);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(materialCostField, gc);

        //Next Row///

        gc.weightx = 1;
        gc.weighty = 0.2;
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(stdMaterialCostLabel,gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(stdMaterialCostField, gc);

        //////// FOURTH ROW /////////////

        gc.weightx = 1;
        gc.weighty = 0.2;
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(actualLaborCostLabel,gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(laborCostField, gc);

        //Next Row///

        gc.weightx = 1;
        gc.weighty = 0.2;
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(stdLaborCostLabel,gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(stdLaborCostField, gc);

        //////// FIFTH ROW /////////////

        gc.weightx = 1;
        gc.weighty = 0.2;
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(freightCostLabel,gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(freightCostField, gc);

        //////// SIXTH ROW /////////////

        gc.weightx = 1;
        gc.weighty = 0.2;
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(freightCostLabel,gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(freightCostField, gc);

        //////// SEVENTH ROW /////////////

        gc.weightx = 1;
        gc.weighty = 2.0;
        gc.gridx = 1;
        gc.gridy++;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(okBtn, gc);

    }
    public void setFormListener(FormListener listener){
        this.formListener = listener;

    }
}
