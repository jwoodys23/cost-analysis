package gui;

import model.Part;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by jourdanwoodrich on 7/23/16.
 */
public class StdPartTableModel extends AbstractTableModel {
    private List<Part> db;
    private String[] colNames = {"Part Name", "Part Number", "Actual Material Cost","Standard Material Cost"};

    public StdPartTableModel(){}

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
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Part part = db.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return part.getPartName();
            case 1:
                return part.getPartNumber();
            case 2:
                return part.getActualMaterialCost();
            case 3:
                return part.getStdMaterialCost();
        }
        return null;
    }

    }
