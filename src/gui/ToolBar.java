package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jourdanwoodrich on 6/19/16.
 */
public class ToolBar extends JPanel implements ActionListener{
    private JButton saveBtn;
    private JButton refreshBtn;
    private ToolbarListener textListener;

    public ToolBar(){

        setBorder(BorderFactory.createEtchedBorder());
        saveBtn = new JButton("Save");
        refreshBtn = new JButton("Refresh");

        saveBtn.addActionListener(this);
        refreshBtn.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(saveBtn);
        add(refreshBtn);
    }

    public void setToolbarListener(ToolbarListener listener){
        this.textListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if (clicked==saveBtn){
            if (textListener!=null){
                textListener.saveEventOccurred();
            }
        } else if (clicked==refreshBtn){
            if (textListener!=null){
                textListener.refreshEventOccurred();
            }
        }
    }
}
