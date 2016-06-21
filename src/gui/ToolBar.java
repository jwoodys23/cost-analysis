package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jourdanwoodrich on 6/19/16.
 */
public class ToolBar extends JPanel implements ActionListener{
    private JButton helloBtn;
    private JButton goodbyeBtn;
    private StringListener textListener;

    public ToolBar(){

        setBorder(BorderFactory.createEtchedBorder());
        helloBtn = new JButton("Hello");
        goodbyeBtn = new JButton("Goodbye");

        helloBtn.addActionListener(this);
        goodbyeBtn.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(helloBtn);
        add(goodbyeBtn);
    }

    public void setStringListener(StringListener listener){
        this.textListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if (clicked==helloBtn){
            if (textListener!=null){
                textListener.textEmitted("Hello\n");
            }
        } else if (clicked==goodbyeBtn){
            if (textListener!=null){
                textListener.textEmitted("Goodbye\n");
            }
        }
    }
}
