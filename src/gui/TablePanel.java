package gui;

import model.Part;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by jourdanwoodrich on 6/21/16.
 */
public class TablePanel extends JPanel {

    private JTable table;
    private PartTableModel tableModel;

    public TablePanel(){

        tableModel = new PartTableModel();
        table = new JTable(tableModel);

        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(List<Part> db){
        tableModel.setData(db);
    }

    public void refresh(){
        tableModel.fireTableDataChanged();
    }
}
