package gui;

import controller.Controller;
import model.Variables;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.List;
import java.util.*;

/**
 * Created by jourdanwoodrich on 6/26/16.
 */
public class VariancePanel extends JPanel {
    //Titles
    private JLabel materialLabel;
    private JLabel laborLabel;
    private JLabel overheadVariance;
    private JLabel totalVariance;
    private JLabel stdCost;
    private JLabel actualCost;
    private JLabel variance;
    private JLabel grossMargin;

    //Labels with variable passed to the constructor
    private JLabel materialStd;
    private JLabel laborStd;
    private JLabel overheadStd;
    private JLabel totalStd;
    private JLabel materialActual;
    private JLabel laborActual;
    private JLabel overheadActual;
    private JLabel totalActual;
    private JLabel materialVariance;
    private JLabel laborVariance;
    private Variables variables;


    public VariancePanel(){

       // controller = new Controller();
        variables = new Variables();

        Border border = BorderFactory.createLineBorder(Color.black);
        setBorder(border);

        //String filler = "filler";
        double test = variables.getLaborHrs();
        System.out.println("variance test: " + test);

        stdCost = new JLabel("Standard Cost");
        actualCost = new JLabel("Actual Cost");
        variance = new JLabel("Variance");
        materialLabel = new JLabel("Material Variance");
        materialStd = new JLabel("Std material cost");
        materialActual = new JLabel("Actual material cost");
        materialVariance = new JLabel("total material var");
        laborLabel = new JLabel("Labor Variance");
        laborActual = new JLabel("Labor hours");
        laborStd = new JLabel("Std Labor Cost");
        laborVariance = new JLabel("total labor var");

        //laborActual.setText(Double.toString(test));



        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = .2;
        gc.weighty = 0.2;

        //////// FIRST ROW /////////////
        gc.gridx = 1;
        gc.gridy = 0;
        //gc.fill = GridBagConstraints.NONE;
        //gc.anchor = GridBagConstraints.LINE_END;
        //gc.insets = new Insets(0,0,0,5);
        add(stdCost, gc);

        gc.gridx = 2;
        gc.gridy = 0;
        //gc.anchor = GridBagConstraints.LINE_START;
        //gc.insets = new Insets(0,0,0,0);
        add(actualCost, gc);

        gc.gridx = 3;
        add(variance,gc);

        //////////////Next Row///////////////

        gc.weightx = .2;
        gc.weighty = 0.2;

        gc.gridy = 1;
        gc.gridx = 0;
        add(materialLabel, gc);

        gc.gridx = 1;
        add(materialStd,gc);

        gc.gridx = 2;
        add(materialActual, gc);

        gc.gridx = 3;
        add(materialVariance, gc);

        //////////////Next Row///////////////

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridy = 2;
        gc.gridx = 0;
        add(laborLabel, gc);

        gc.gridx = 1;
        add(laborStd,gc);

        gc.gridx = 2;
        add(laborActual, gc);

        gc.gridx = 3;
        add(laborVariance, gc);



    }

}
