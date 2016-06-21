package gui;

import java.util.EventObject;

/**
 * Created by jourdanwoodrich on 6/20/16.
 */
public class FormEvent extends EventObject{
    private String partName;
    private String partNumber;
    private String materialCost;
    private String laborCost;
    private String freightCost;

    public FormEvent(Object source){
        super(source);
    }

    public FormEvent(Object source, String partName, String partNumber, String materialCost, String laborCost, String freightCost){
        super(source);

        this.partName = partName;
        this.partNumber = partNumber;
        this.materialCost = materialCost;
        this.laborCost = laborCost;
        this.freightCost = freightCost;
    }

    public String getFreightCost() {
        return freightCost;
    }

    public void setFreightCost(String freightCost) {
        this.freightCost = freightCost;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(String materialCost) {
        this.materialCost = materialCost;
    }

    public String getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(String laborCost) {
        this.laborCost = laborCost;
    }
}
