package gui;



import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.Arc2D;

/**
 * Created by jourdanwoodrich on 7/16/16.
 */
public class StandardCostFormPanel extends JPanel {


    /////Variables with values that update when form changes
    private JLabel stdLaborHrs;
    private JLabel actualLaborHrs;
    private JLabel stdLaborCalculation;
    private JLabel stdOverheadRate;
    private JLabel overheadExpense;
    private JLabel actualFreightCost;
    private JLabel sellingPrice;

    /////////Actual Labels///////////
    private JLabel stdLaborHrsLabel;
    private JLabel stdLaborRate;
    private JLabel stdLaborCalculationLabel;
    private JLabel overheadRateLabel;
    private JLabel overheadExpenseLabel;
    private JLabel freightCostLabel;
    private JLabel sellingPriceLabel;



    public StandardCostFormPanel(){

        stdLaborHrsLabel = new JLabel("Standard Labor Hours: ");
        stdLaborHrs = new JLabel("$0.00");
        stdLaborRate = new JLabel("Standard Labor Rate: ");
        stdLaborCalculationLabel = new JLabel("Labor Calculation: ");
        stdLaborCalculation = new JLabel("$0.00");
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
        add(stdLaborRate, gc);

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
        add(stdLaborCalculationLabel, gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(stdLaborCalculation,gc);

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

        Double calculation = Double.parseDouble(actualLabor) * Double.parseDouble(stdLabor);




        stdLaborHrs.setText("$" + stdLabor);
        actualLaborHrs.setText("$" + actualLabor);
        stdOverheadRate.setText("$" + overheadRate);
        stdLaborCalculation.setText("$" + calculation);
        overheadExpense.setText("$" + actOverhead);
        actualFreightCost.setText("$" + actualFreight);
        sellingPrice.setText("$" + price);


    }

}
