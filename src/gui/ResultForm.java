package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jourdanwoodrich on 6/25/16.
 */
public class ResultForm extends JPanel{

    private JLabel stdLaborRate;
    private JButton saveBtn;

    public ResultForm(){

        Dimension dim = getPreferredSize();
        dim.width = 275;
        setPreferredSize(dim);

        stdLaborRate = new JLabel("Standard Labor Rate");
        saveBtn = new JButton("Save Changes");

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

//        gc.gridx = 0;
//        gc.gridy = 0;

        gc.weightx = 1;
        gc.weighty = 2.0;
        gc.gridx = 1;
        gc.gridy = 6;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(saveBtn, gc);





    }
}
