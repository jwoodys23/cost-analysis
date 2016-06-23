package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Created by jourdanwoodrich on 6/19/16.
 */
public class MainFrame extends JFrame {

    private TextPanel textPanel;
    private ToolBar toolBar;
    private FormPanel formPanel;
    private JFileChooser fileChooser;
    private Controller controller;
    private TablePanel tablePanel;


    public MainFrame(){

        super("Cost Analysis");

        setLayout(new BorderLayout());

        textPanel = new TextPanel();
        toolBar = new ToolBar();
        formPanel = new FormPanel();
        tablePanel = new TablePanel();

        controller = new Controller();
        tablePanel.setData(controller.getPart());

        tablePanel.setPartTableListener(new PartTableListener(){
           public void rowDeleted(int row){
               controller.removePart(row);
           }
        });



        fileChooser = new JFileChooser();

        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Inventory Database Files (*.inv)", "inv"));
        fileChooser.setAcceptAllFileFilterUsed(true);

        setJMenuBar(createMenuBar());

        toolBar.setStringListener(text -> textPanel.appendText(text));

        formPanel.setFormListener(e -> {
            controller.addPart(e);
            tablePanel.refresh();

        });

        add(formPanel, BorderLayout.WEST);
        add(toolBar, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);

        setSize(900, 600);
        setMinimumSize(new Dimension(500,400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exportDataItem = new JMenuItem("Save");
        JMenuItem importDataItem = new JMenuItem("Open");
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
                try {
                    controller.loadFromFile(fileChooser.getSelectedFile());
                    tablePanel.refresh();
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Could not load data from file", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }

        });

        exportDataItem.addActionListener(e -> {
            if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
                try {
                    controller.saveToFile(fileChooser.getSelectedFile());
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Could not save data to file", "Error", JOptionPane.ERROR_MESSAGE);
                }

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
