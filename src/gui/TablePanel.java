package gui;

import model.Part;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Created by jourdanwoodrich on 6/21/16.
 */
public class TablePanel extends JPanel {

    private JTable table;
    private PartTableModel tableModel;
    private JPopupMenu popupMenu;
    private PartTableListener partTableListener;

    public TablePanel(){

        tableModel = new PartTableModel();
        table = new JTable(tableModel);
        popupMenu = new JPopupMenu();

        JMenuItem removeItem = new JMenuItem("Delete Row");
        popupMenu.add(removeItem);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());

                table.getSelectionModel().setSelectionInterval(row, row);

                if (e.getButton() == MouseEvent.BUTTON3){
                    popupMenu.show(table, e.getX(), e.getY());
                }
            }
        });

        removeItem.addActionListener(e -> {
            int row = table.getSelectedRow();
            int id = tableModel.getId(row);

            if (partTableListener != null){
                partTableListener.rowDeleted(row);
                partTableListener.deleteEventOccurred(id);
                tableModel.fireTableRowsDeleted(row, row);
                System.out.println(row);
            }
        });

        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(List<Part> db){
        tableModel.setData(db);
    }

    public void refresh(){
        tableModel.fireTableDataChanged();
    }

    public void setPartTableListener(PartTableListener listener){
        this.partTableListener = listener;

    }
}
