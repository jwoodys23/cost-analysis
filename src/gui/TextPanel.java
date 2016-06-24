package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jourdanwoodrich on 6/19/16.
 */
public class TextPanel extends JPanel {

    private JTextArea textArea;

    public TextPanel(){


        textArea = new JTextArea();

        setLayout(new BorderLayout());
        add(new JScrollPane(textArea),BorderLayout.CENTER);

    }

    public void appendText(String text){
        textArea.append(text);
    }
}
