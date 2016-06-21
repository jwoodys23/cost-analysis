import javax.swing.*;
import java.awt.*;

/**
 * Created by jourdanwoodrich on 6/19/16.
 */
public class MainFrame extends JFrame {

    private TextPanel textPanel;
    private ToolBar toolBar;
    private FormPanel formPanel;

    public MainFrame(){

        super("Cost Analysis");

        setLayout(new BorderLayout());

        textPanel = new TextPanel();
        toolBar = new ToolBar();
        formPanel = new FormPanel();

        toolBar.setStringListener(text -> textPanel.appendText(text));

        formPanel.setFormListener(e -> {
            String partName = e.getPartName();
            String partNumber = e.getPartNumber();
            String materialCost = e.getMaterialCost();
            String laborCost = e.getLaborCost();
            String freightCost = e.getFreightCost();

            textPanel.appendText(partName + ": " + partNumber + ": " + materialCost + ": " + laborCost + freightCost +"\n");

        });

        add(formPanel, BorderLayout.WEST);
        add(toolBar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);

        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
