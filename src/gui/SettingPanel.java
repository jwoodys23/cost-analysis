package gui;



import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.math.BigDecimal;

/**
 * Created by jourdanwoodrich on 7/16/16.
 */
public class SettingPanel extends JPanel {


    /////Variables with values that update when form changes
    private JLabel stdLaborHrs;
    private JLabel actualLaborHrs;
    private JLabel stdOverheadRate;
    private JLabel overheadExpense;
    private JLabel actualFreightCost;
    private JLabel sellingPrice;

    /////////Actual Labels///////////
    private JLabel stdLaborHrsLabel;
    private JLabel actualLaborHrsLabel;
    private JLabel overheadRateLabel;
    private JLabel overheadExpenseLabel;
    private JLabel freightCostLabel;
    private JLabel sellingPriceLabel;



    public SettingPanel(){

        stdLaborHrsLabel = new JLabel("Standard Labor Hours: ");
        stdLaborHrs = new JLabel("$0.00");
        actualLaborHrsLabel = new JLabel("Actual Labor Hours: ");
        actualLaborHrs = new JLabel("$0.00");
        stdOverheadRate = new JLabel("$0.00");
        overheadRateLabel = new JLabel("Standard Overhead Rate: ");
        overheadExpense = new JLabel("$0.00");
        overheadExpenseLabel = new JLabel("Actual Overhead Expense: ");
        actualFreightCost = new JLabel("$0.00");
        freightCostLabel = new JLabel("Actual Freight Expense: ");
        sellingPrice = new JLabel("$0.00");
        sellingPriceLabel = new JLabel("Selling Price: ");



        Border innerBorder = BorderFactory.createTitledBorder("Current Settings");
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
        add(stdLaborHrsLabel, gc);

        gc.gridx++;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(stdLaborHrs,gc);

        //////// NEXT ROW /////////////
        gc.gridx = 0;
        gc.gridy++;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(actualLaborHrsLabel, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(actualLaborHrs,gc);

        //////// NEXT ROW /////////////
        gc.gridx = 0;
        gc.gridy++;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(overheadRateLabel, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(stdOverheadRate,gc);

        //////// NEXT ROW /////////////
        gc.gridx = 0;
        gc.gridy++;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(overheadExpenseLabel, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(overheadExpense,gc);

        //////// NEXT ROW /////////////
        gc.gridx = 0;
        gc.gridy++;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(freightCostLabel, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(actualFreightCost,gc);

        //////// NEXT ROW /////////////
        gc.gridx = 0;
        gc.gridy++;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(sellingPriceLabel, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(sellingPrice,gc);


    }


    public void getVariable(SettingEvent e) {
        String stdLabor =  e.getStdLabor();
        String  actualLabor = e.getActualLabor();
        String overheadRate = e.getOverheadRate();
        String actOverhead = e.getActOverhead();
        String actualFreight = e.getActFreight();
        String price = e.getPrice();




        stdLaborHrs.setText("$" + stdLabor);
        actualLaborHrs.setText("$" + actualLabor);
        stdOverheadRate.setText("$" + overheadRate);
        overheadExpense.setText("$" + actOverhead);
        actualFreightCost.setText("$" + actualFreight);
        sellingPrice.setText("$" + price);


    }

}
