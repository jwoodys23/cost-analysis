package gui;

import apple.laf.JRSUIUtils;
import controller.Controller;
import javafx.event.ActionEvent;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.prefs.Preferences;

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
    private PrefsDialog prefsDialog;
    private Preferences prefs;
    private JTabbedPane tabbedPane;


    public MainFrame(){

        super("Cost Analysis");

        setLayout(new BorderLayout());

        textPanel = new TextPanel();
        toolBar = new ToolBar();
        formPanel = new FormPanel();
        tablePanel = new TablePanel();
        tabbedPane = new JTabbedPane();
        tablePanel.setName("Parts Database");
        textPanel.setName("Report");

        tabbedPane.addTab(tablePanel.getName(), tablePanel);
        tabbedPane.addTab(textPanel.getName(), textPanel);

        tabbedPane.addChangeListener(e -> {

            tabChanged();
           // System.out.println("tabbed changed");
        });

        prefs = Preferences.userRoot().node("db");

        controller = new Controller();

        prefsDialog = new PrefsDialog(this);

        tablePanel.setData(controller.getPart());

        tablePanel.setPartTableListener(row -> controller.removePart(row));

        prefsDialog.setPrefsListener((user, password, port) -> {
            prefs.put("user", user);
            prefs.put("password", password);
            prefs.putInt("port", port);
        });

        String user = prefs.get("user", "");
        String password = prefs.get("password", "");
        Integer port = prefs.getInt("port", 3306);

        prefsDialog.setDefault(user, password, port);

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
            }
        });

        formPanel.setFormListener(e -> {
            controller.addPart(e);
            tablePanel.refresh();

        });

        //tabbedPane;

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                controller.disconnect();
                dispose();
                System.gc();
            }
        });

        add(formPanel, BorderLayout.WEST);
        add(toolBar, BorderLayout.PAGE_START);
        add(tabbedPane, BorderLayout.CENTER);

        setSize(900, 600);
        setMinimumSize(new Dimension(500,400));
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }

    private void tabChanged(){

        Component tab = tabbedPane.getSelectedComponent();
        String name = tab.getName();
        if (name == "Report"){
            formPanel.setVisible(false);
        } else {
            formPanel.setVisible(true);
        }
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
        JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Part Form");
        showFormItem.setSelected(true);

        viewMenu.add(showFormItem);
        viewMenu.add(prefs);

        //Add show menu to window menu
        windowMenu.add(viewMenu);

        //Add main menu items
        menuBar.add(fileMenu);
        menuBar.add(windowMenu);

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
