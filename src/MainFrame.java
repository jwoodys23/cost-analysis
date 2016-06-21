import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

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

        setJMenuBar(createMenuBar());

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

    private JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exportDataItem = new JMenuItem("Export Data...");
        JMenuItem importDataItem = new JMenuItem("Import Data...");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exportDataItem);
        fileMenu.add(importDataItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // Window Menu
        JMenu windowMenu = new JMenu("Window");

        // View Menu
        JMenu viewMenu = new JMenu("View");
        JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Part Form");
        showFormItem.setSelected(true);

        viewMenu.add(showFormItem);

        //Add show menu to window menu
        windowMenu.add(viewMenu);

        //Add main menu items
        menuBar.add(fileMenu);
        menuBar.add(windowMenu);

        //Action Listeners
        showFormItem.addActionListener(e -> {
            JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();
            formPanel.setVisible(menuItem.isSelected());
        });

        //Mnemonics
        fileMenu.setMnemonic(KeyEvent.VK_F);
        exitItem.setMnemonic(KeyEvent.VK_X);

        //Accelerators
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        //Close Application when exit menu item is clicked
        exitItem.addActionListener(e -> {
            System.exit(0);
        });

        return menuBar;
    }
}
