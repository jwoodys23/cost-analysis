package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jourdanwoodrich on 6/19/16.
 */
public class ResultPanel extends JPanel {

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



    public ResultPanel(){

        String material = "filler";
        String labor = "filler";

        stdCost = new JLabel("Standard Cost");
        actualCost = new JLabel("Actual Cost");
        variance = new JLabel("Variance");
        materialLabel = new JLabel("Material Variance");
        materialStd = new JLabel(material);


        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 1;
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

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridy = 1;
        gc.gridx = 0;
        add(materialLabel, gc);

        gc.gridx = 1;
        add(materialStd,gc);



    }

}
