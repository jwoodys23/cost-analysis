package model;

import java.io.Serializable;

/**
 * Created by jourdanwoodrich on 6/21/16.
 */
public class Part implements Serializable{

    private static int count = 1;

    private int id;
    private String partName;
    private String partNumber;
    private String materialCost;
    private String laborCost;
    private String freightCost;

    public Part (String partName, String partNumber, String materialCost, String laborCost, String freightCost){
        this.partName = partName;
        this.partNumber = partNumber;
        this.materialCost = materialCost;
        this.laborCost = laborCost;
        this.freightCost = freightCost;
        this.id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFreightCost() {
        return freightCost;
    }

    public void setFreightCost(String freightCost) {
        this.freightCost = freightCost;
    }
}
