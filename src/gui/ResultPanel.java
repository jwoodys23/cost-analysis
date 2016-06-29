package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by jourdanwoodrich on 6/19/16.
 */
public class ResultPanel extends JPanel {


    public ResultPanel(){
        Border border = BorderFactory.createLineBorder(Color.black);
        setBorder(border);

        ResultForm resultForm = new ResultForm();

        VariancePanel variancePanel = new VariancePanel();
        //GraphPanel graphPanel = new GraphPanel();

        setLayout(new BorderLayout());
        add(resultForm, BorderLayout.WEST);
        add(variancePanel,BorderLayout.CENTER);


    }

}
