package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.prefs.Preferences;

/**
 * Created by jourdanwoodrich on 6/19/16.
 */
public class MainFrame extends JFrame {

    private StandardCostFormPanel standardCostFormPanel;
    private SettingForm settingForm;
    private ToolBar toolBar;
    private FormPanel formPanel;
    private JFileChooser fileChooser;
    private Controller controller;
    private TablePanel tablePanel;
    private PrefsDialog prefsDialog;
    private Preferences prefs;
    private JTabbedPane tabbedPane;
    private StandardTablePanel stdCostTablePanel;


    public MainFrame(){

        super("Cost Analysis");

        setLayout(new BorderLayout());

        standardCostFormPanel = new StandardCostFormPanel();
        settingForm = new SettingForm();
        toolBar = new ToolBar();
        formPanel = new FormPanel();
        tablePanel = new TablePanel();
        stdCostTablePanel = new StandardTablePanel();
        tabbedPane = new JTabbedPane();
        tablePanel.setName("Parts Database");
        standardCostFormPanel.setName("Settings");
        formPanel.setName("Form");

        tabbedPane.addTab("Parts Database", tablePanel);
        //tabbedPane.addTab("Standard Costs", stdCostTablePanel);

       // tabbedPane.addChangeListener(e -> tabChanged());



        prefs = Preferences.userRoot().node("db");

        controller = new Controller();

        prefsDialog = new PrefsDialog(this);

        stdCostTablePanel.setData(controller.getPart());

        tablePanel.setData(controller.getPart());

        tablePanel.setPartTableListener(new PartTableListener() {
            @Override
            public void rowDeleted(int row) {
                controller.removePart(row);

            }
            public void deleteEventOccurred(int row){
                connect();
                try {
                    try {
                        controller.connect();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    controller.deletePart(row);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });


        prefsDialog.setPrefsListener((user, password, port) -> {
            prefs.put("root", user);
            prefs.put("password", password);
            prefs.putInt("port", port);

            try{
                controller.configure(port, user, password);

            } catch (Exception e){
                JOptionPane.showMessageDialog(MainFrame.this, "Unable to reconnect to the database");
            }

        });

        String user = prefs.get("user", "");
        String password = prefs.get("password", "");
        Integer port = prefs.getInt("port", 3306);



        prefsDialog.setDefault(user, password, port);

        try{
            controller.configure(port, user, password);
        }catch (Exception e){
            System.err.println("Cant connect to database");
        }

        fileChooser = new JFileChooser();

        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Inventory Database Files (*.inv)", "inv"));
        fileChooser.setAcceptAllFileFilterUsed(true);

        setJMenuBar(createMenuBar());

        toolBar.setToolbarListener(new ToolbarListener() {
            @Override
            public void saveEventOccurred() {
                connect();
                try {
                    controller.connect();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Cannot connect to database", "Database Connection problem", JOptionPane.ERROR_MESSAGE);
                }
                try {
                    controller.save();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Unable to save to database", "Database Connection problem", JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void refreshEventOccurred() {
                connect();
                try {
                    controller.load();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Unable to load from database", "Database Connection problem", JOptionPane.ERROR_MESSAGE);

                }
                tablePanel.refresh();
                stdCostTablePanel.refresh();
            }

        });

        formPanel.setFormListener(e -> {
            controller.addPart(e);
            tablePanel.refresh();
            stdCostTablePanel.refresh();

        });


        settingForm.setSettingListener(e ->{
            controller.addVariable(e);
            standardCostFormPanel.getVariable(e);

        });


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                controller.disconnect();
                dispose();
                System.gc();
            }
        });

        //add(selectTab(), BorderLayout.WEST);
       // tabChanged();
        add(formPanel,BorderLayout.WEST);
        add(toolBar, BorderLayout.PAGE_START);
        add(tabbedPane, BorderLayout.CENTER);

        setSize(1200, 600);

        setMinimumSize(new Dimension(500,400));
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }

    //Switches the forms that appear based on what tab is selected
    //Added so that the Forms don't change position when the tab is changed
    private void tabChanged(){
        Component tab = tabbedPane.getSelectedComponent();
        String name = tab.getName();
        if (name == "Settings"){
            remove(formPanel);
            add(settingForm, BorderLayout.WEST);
        } else if (name=="Parts Database"){
            remove(settingForm);
            add(formPanel, BorderLayout.WEST);

        }
        repaint();
    }


    private void connect(){
        try {
            controller.connect();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(MainFrame.this, "Cannot connect to database", "Database Connection problem", JOptionPane.ERROR_MESSAGE);
        }
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
        JMenuItem prefs = new JMenuItem("Preferences...");
        JMenuItem report = new JMenuItem("Report");
        JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Part Form");
        showFormItem.setSelected(true);

        viewMenu.add(showFormItem);
        viewMenu.add(prefs);
        viewMenu.add(report);

        //Add show menu to window menu
        windowMenu.add(viewMenu);

        //Add main menu items
        menuBar.add(fileMenu);
        menuBar.add(windowMenu);

        report.addActionListener(e -> {
                new Report();

        });

        //Action Listeners

        prefs.addActionListener(e ->
            prefsDialog.setVisible(true)
        );




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
                WindowListener[] listeners = getWindowListeners();

                for (WindowListener listener: listeners){
                    listener.windowClosing(new WindowEvent(MainFrame.this, 0));
                }
            }

        });

        return menuBar;
    }
}
