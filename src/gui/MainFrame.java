package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by jourdanwoodrich on 6/19/16.
 */
public class MainFrame extends JFrame {

    private TextPanel textPanel;
    private ToolBar toolBar;
    private FormPanel formPanel;
    private JFileChooser fileChooser;
    private Controller controller;


    public MainFrame(){

        super("Cost Analysis");

        setLayout(new BorderLayout());

        textPanel = new TextPanel();
        toolBar = new ToolBar();
        formPanel = new FormPanel();

        controller = new Controller();

        fileChooser = new JFileChooser();

        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Inventory Database Files (*.inv)", "inv"));
        fileChooser.setAcceptAllFileFilterUsed(true);

        setJMenuBar(createMenuBar());

        toolBar.setStringListener(text -> textPanel.appendText(text));

        formPanel.setFormListener(e -> {
            controller.addPart(e);

        });

        add(formPanel, BorderLayout.WEST);
        add(toolBar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);

        setSize(900, 600);
        setMinimumSize(new Dimension(500,400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exportDataItem = new JMenuItem("Open");
        JMenuItem importDataItem = new JMenuItem("Save");
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

        importDataItem.addActionListener(e -> {
            if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
                System.out.println(fileChooser.getSelectedFile());
            }

        });

        exportDataItem.addActionListener(e -> {
            if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
                System.out.println(fileChooser.getSelectedFile());
            }

        });

        //Mnemonics
        fileMenu.setMnemonic(KeyEvent.VK_F);
        exitItem.setMnemonic(KeyEvent.VK_X);

        //Accelerators
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        //Close Application when exit menu item is clicked
        exitItem.addActionListener(e -> {
            int action = JOptionPane.showConfirmDialog(MainFrame.this, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
            if (action == JOptionPane.OK_OPTION){
                System.exit(0);
            }

        });

        return menuBar;
    }
}
