package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jourdanwoodrich on 7/16/16.
 */
public class SettingPanel extends JPanel {
    private JLabel test;
    private JTextField text;
    public SettingPanel(){
        test = new JLabel("Current Value is: ");
        text = new JTextField(10);


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
        add(test, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(text,gc);

    }
}
