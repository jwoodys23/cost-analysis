package gui;

import model.Part;

import javax.swing.table.AbstractTableModel;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by jourdanwoodrich on 6/21/16.
 */
public class PartTableModel extends AbstractTableModel {

    private List<Part> db;
    private String[] colNames = {"Part Name", "Part Number", "Actual Material Cost", "Standard Material Cost", "Actual Labor Cost", "Standard Labor Cost", "Freight Cost"};

    public PartTableModel(){
    }

    public int getId(int row){
        Part part = db.get(row);
        System.out.println("part at row " + row);
        return part.getId();
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            default:
                return true;

        }
    }

    @Override
    public void setValueAt(Object aValue, int row, int col) {
        if (db == null) return;
        Part part = db.get(row);
        switch (col){
            case 0:
                part.setPartName((String)aValue);
                break;
            case 1:
                part.setPartNumber((String)aValue);
                break;
            case 2:
                part.setActualMaterialCost(getBigDecimal(aValue));
                break;
            case 3:
                part.setStdMaterialCost(getBigDecimal(aValue));
                break;
            case 4:
                part.setActualLaborCost(getBigDecimal(aValue));
                break;
            case 5:
                part.setStdLaborCost(getBigDecimal(aValue));
                break;
            case 6:
                part.setActualFreightCost(getBigDecimal(aValue));
                break;
            default:
                return;

        }
    }

    // Method found at http://www.java2s.com/Code/Java/Data-Type/ConvertObjecttoBigDecimal.htm

    public static BigDecimal getBigDecimal( Object value ) {
        BigDecimal ret = null;
        if( value != null ) {
            if( value instanceof BigDecimal ) {
                ret = (BigDecimal) value;
            } else if( value instanceof String ) {
                ret = new BigDecimal( (String) value );
            } else if( value instanceof BigInteger) {
                ret = new BigDecimal( (BigInteger) value );
            } else if( value instanceof Number ) {
                ret = new BigDecimal( ((Number)value).doubleValue() );
            } else {
                throw new ClassCastException("Not possible to coerce ["+value+"] from class "+value.getClass()+" into a BigDecimal.");
            }
        }
        return ret;
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
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Part part = db.get(rowIndex);

        switch (columnIndex){
            case 0:
                return part.getPartName();
            case 1:
                return part.getPartNumber();
            case 2:
                return part.getActualMaterialCost();
            case 3:
                return part.getStdMaterialCost();
            case 4:
                return part.getActualLaborCost();
            case 5:
                return part.getStdLaborCost();
            case 6:
                return part.getActualFreightCost();

        }
        return null;

    }
}
