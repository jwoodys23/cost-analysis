package gui;

import model.Part;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by jourdanwoodrich on 6/21/16.
 */
public class PartTableModel extends AbstractTableModel {

    private List<Part> db;
    private String[] colNames = {"ID", "Part Name", "Part Number", "Material Cost", "Labor Cost", "Freight Cost"};

    public PartTableModel(){
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    public void setData(List<Part> db){
        this.db = db;
    }
    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Part part = db.get(rowIndex);

        switch (columnIndex){
            case 0:
                return part.getId();
            case 1:
                return part.getPartName();
            case 2:
                return part.getPartNumber();
            case 3:
                return part.getMaterialCost();
            case 4:
                return part.getLaborCost();
            case 5:
                return part.getFreightCost();
        }
        return null;

    }
}
