package gui;

import controller.Controller;
import model.Variables;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.Arc2D;

/**
 * Created by jourdanwoodrich on 6/25/16.
 */
public class ResultsDialog extends JDialog{

//    private JLabel stdLaborRate;
//    private JLabel stdLaborHrs;
//    private JLabel stdOverheadRate;
//    //private JLabel freightRate;
//    private JLabel sellingPrice;
//    private JTextField overheadRateInput;
//    //private JTextField freightInput;
//    private JTextField sellingInput;
//    private JTextField stdLaborInput;
//    private JTextField stdLaborHrsInput;
//    private JButton saveBtn;
//    private VariancePanel panel;
//    private SettingListener settingListener;
//    private Variables variables;
//    private Controller controller;
//
//    public ResultsDialog(JFrame parent){
//        super(parent, "Settings", false);
//        variables = new Variables();
//        panel = new VariancePanel();
//        setSize(320, 230);
//        setLocationRelativeTo(parent);
//        controller = new Controller();
//
//        Border innerBorder = BorderFactory.createTitledBorder("Add New Part");
//        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
//        //setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
//
//        Dimension dim = getPreferredSize();
//        dim.width = 275;
//        setPreferredSize(dim);
//
//        stdLaborRate = new JLabel("Std. Labor Rate");
//        stdLaborHrs = new JLabel("Std. Labor Hours");
//        stdOverheadRate = new JLabel("Std. Overhead Rate");
//        sellingPrice = new JLabel("Selling Price");
//
//        saveBtn = new JButton("Save Changes");
//
//        stdLaborInput = new JTextField(10);
//        stdLaborHrsInput = new JTextField(10);
//        sellingInput = new JTextField(10);
//        overheadRateInput = new JTextField(10);
//
//
//        setLayout(new GridBagLayout());
//
//        GridBagConstraints gc = new GridBagConstraints();
//
//        gc.gridx = 0;
//        gc.gridy = 0;
//        gc.weightx = 1;
//        gc.weighty = .2;
//        gc.fill = GridBagConstraints.NONE;
//        gc.anchor = GridBagConstraints.LINE_END;
//        gc.insets = new Insets(0,0,0,5);
//        add(stdLaborRate, gc);
//
//        gc.gridx = 1;
//        gc.anchor = GridBagConstraints.LINE_START;
//        gc.insets = new Insets(0,0,0,0);
//        add(stdLaborInput, gc);
//
//        /////////Next Row////////////
//
//        gc.gridx = 0;
//        gc.gridy++;
//        gc.fill = GridBagConstraints.NONE;
//        gc.anchor = GridBagConstraints.LINE_END;
//        gc.insets = new Insets(0,0,0,5);
//        add(stdLaborHrs, gc);
//
//        gc.gridx = 1;
//        gc.anchor = GridBagConstraints.LINE_START;
//        gc.insets = new Insets(0,0,0,0);
//        add(stdLaborHrsInput, gc);
//
//        /////////Next Row////////////
//
//        gc.gridx = 0;
//        gc.gridy++;
//        gc.fill = GridBagConstraints.NONE;
//        gc.anchor = GridBagConstraints.LINE_END;
//        gc.insets = new Insets(0,0,0,5);
//        add(stdOverheadRate, gc);
//
//        gc.gridx = 1;
//        gc.anchor = GridBagConstraints.LINE_START;
//        gc.insets = new Insets(0,0,0,0);
//        add(overheadRateInput, gc);
//
//        /////////Next Row////////////
//
//        gc.gridx = 0;
//        gc.gridy++;
//        gc.fill = GridBagConstraints.NONE;
//        gc.anchor = GridBagConstraints.LINE_END;
//        gc.insets = new Insets(0,0,0,5);
//        add(sellingPrice, gc);
//
//        gc.gridx = 1;
//        gc.anchor = GridBagConstraints.LINE_START;
//        gc.insets = new Insets(0,0,0,0);
//        add(sellingInput, gc);
//
//
//        //////////Last Row///////////
//        gc.weightx = 1;
//        gc.weighty = 2.0;
//        gc.gridx = 1;
//        gc.gridy++;
//        gc.anchor = GridBagConstraints.FIRST_LINE_START;
//        gc.insets = new Insets(0,0,0,0);
//        add(saveBtn, gc);
//
//
//
//
//        saveBtn.addActionListener(e -> {
//            double laborRate = Double.parseDouble(stdLaborInput.getText());
//            double laborHrs = Double.parseDouble(stdLaborHrsInput.getText());
//            double overheadRate = Double.parseDouble(overheadRateInput.getText());
//            double sellingPrice = Double.parseDouble(sellingInput.getText());
//
//            SettingEvent event = new SettingEvent(this, laborRate, laborHrs, overheadRate, sellingPrice);
//            if (settingListener!=null){
//                settingListener.settingEventOccurred(event);
//            }
//            controller.addSettings(event);
//            setVisible(false);
//           // System.out.println(variables.getLaborHrs());
////
//        });
//
//
//    }
//    public void setSettingListener(SettingListener listener){
//        this.settingListener = listener;
//
//    }
}
