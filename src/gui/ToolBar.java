package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

/**
 * Created by jourdanwoodrich on 6/19/16.
 */
public class ToolBar extends JToolBar implements ActionListener{
    private JButton saveBtn;
    private JButton refreshBtn;
    private ToolbarListener textListener;

    public ToolBar(){

        setBorder(BorderFactory.createEtchedBorder());
        setFloatable(false);
        saveBtn = new JButton();
        saveBtn.setIcon(createIcon("/images/save.png"));
        saveBtn.setToolTipText("Save");

        refreshBtn = new JButton();
        refreshBtn.setIcon(createIcon("/images/refresh.png"));
        refreshBtn.setToolTipText("Refresh");

        saveBtn.addActionListener(this);
        refreshBtn.addActionListener(this);



        add(saveBtn);
        add(refreshBtn);

    }

    private ImageIcon createIcon(String path){
        URL url = getClass().getResource(path);

        if (url == null){
            System.err.println("Unable to load image: " + path);
        }

        ImageIcon imageIcon = new ImageIcon(url);

        return imageIcon;
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
