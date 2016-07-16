package gui;

import controller.Controller;
import model.Variables;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.sql.SQLException;

/**
 * Created by jourdanwoodrich on 6/19/16.
 */
public class SettingForm extends JPanel {
    private JLabel stdLaborHrs;
    private JLabel actualLaborHrs;
    private JLabel stdOverheadRate;
    private JLabel actualOverhead;
    private JLabel actualFreight;
    private JLabel sellingPrice;
    private JTextField overheadRateInput;
    private JTextField actualOverheadInput;
    private JTextField actualFreightInput;
    private JTextField sellingInput;
    private JTextField actualLaborHrsInput;
    private JTextField stdLaborHrsInput;
    private JButton saveBtn;

    private SettingListener settingListener;
    //private Variables variables;
    private Controller controller;


    public SettingForm(){

        Dimension dim = getPreferredSize();
        dim.width = 350;
        setPreferredSize(dim);
        controller = new Controller();


        //Labels
        stdLaborHrs = new JLabel("Standard Labor Hours");
        actualLaborHrs = new JLabel("Actual Labor Hours");
        stdOverheadRate = new JLabel("Standard Overhead Rate");
        actualOverhead = new JLabel("Actual Overhead Expense");
        actualFreight = new JLabel("Actual Freight Expense");
        sellingPrice = new JLabel("Selling Price");



        //Inputs
        actualLaborHrsInput = new JTextField(10);
        stdLaborHrsInput = new JTextField(10);
        overheadRateInput = new JTextField(10);
        actualOverheadInput = new JTextField(10);
        actualFreightInput = new JTextField(10);
        sellingInput = new JTextField(10);

        //Buttons
        saveBtn = new JButton("Save Settings");


        //Adding fields to Grid Bag Layout
        Border innerBorder = BorderFactory.createTitledBorder("Add Settings");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

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
        add(stdLaborHrs, gc);

        gc.gridx++;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(stdLaborHrsInput,gc);

        /////////Next Row ////////////

        gc.gridx = 0;
        gc.gridy++;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(actualLaborHrs,gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(actualLaborHrsInput, gc);

        /////////Next Row ////////////

        gc.gridx = 0;
        gc.gridy++;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(stdOverheadRate,gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(overheadRateInput, gc);

        /////////Next Row ////////////

        gc.gridx = 0;
        gc.gridy++;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(actualOverhead,gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(actualOverheadInput, gc);


        /////////Next Row ////////////

        gc.gridx = 0;
        gc.gridy++;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(actualFreight,gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(actualFreightInput, gc);

        /////////Next Row ////////////

        gc.gridx = 0;
        gc.gridy++;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(sellingPrice,gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(sellingInput, gc);




        /////////Button Row ////////////


        gc.weightx = 1;
        gc.weighty = 2.0;
        gc.gridx = 1;
        gc.gridy++;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(saveBtn,gc);



        saveBtn.addActionListener(e ->{

            //TODO: make all these fields accept empty value(Just add if statements to all)
            Double stdLabor = Double.parseDouble(stdLaborHrsInput.getText());
            Double actualLabor = Double.parseDouble(actualLaborHrsInput.getText());
            Double overheadRate = Double.parseDouble(overheadRateInput.getText());
            Double actOverhead = Double.parseDouble(actualOverheadInput.getText());
            Double actFreight = Double.parseDouble(actualFreightInput.getText());
            Double price = Double.parseDouble(sellingInput.getText());


            SettingEvent ev = new SettingEvent(this, stdLabor, actualLabor, overheadRate, actOverhead, actFreight, price);

            System.out.println(controller.getVariables());
            if (settingListener!=null){
                settingListener.settingEventOccurred(ev);
                controller.addVariable(ev);
                try {
                    controller.connect();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                try {
                    controller.saveVariable();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
//                System.out.println(controller.getVariables());
            }



            //System.out.println();
//

        });


    }

    public void setSettingListener(SettingListener listener){
        this.settingListener = listener;

    }

}
