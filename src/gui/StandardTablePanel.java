package gui;

import model.Part;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by jourdanwoodrich on 7/23/16.
 */
public class StandardTablePanel extends JPanel {
    private JTable table;
    private StdPartTableModel stdPartTableModel;

    public StandardTablePanel(){
        stdPartTableModel = new StdPartTableModel();
        table = new JTable(stdPartTableModel);

        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(List<Part> db){
        stdPartTableModel.setData(db);
    }

    public void refresh(){
        stdPartTableModel.fireTableDataChanged();
    }
}
