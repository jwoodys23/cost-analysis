package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jourdanwoodrich on 6/19/16.
 */
public class ResultPanel extends JPanel {


    public ResultPanel(){

        ResultForm resultForm = new ResultForm();

        VariancePanel variancePanel = new VariancePanel();
        //GraphPanel graphPanel = new GraphPanel();

        setLayout(new BorderLayout());
        add(resultForm, BorderLayout.WEST);
        add(variancePanel,BorderLayout.CENTER);


    }

}
