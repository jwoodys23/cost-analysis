package model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by jourdanwoodrich on 6/21/16.
 */
public class Part implements Serializable{

    private static int count = 1;

    private int id;
    private String partName;
    private String partNumber;
    private BigDecimal materialCost;
    private BigDecimal laborCost;
    private BigDecimal freightCost;

    public Part (String partName, String partNumber, BigDecimal materialCost, BigDecimal laborCost, BigDecimal freightCost){
        this.partName = partName;
        this.partNumber = partNumber;
        this.materialCost = materialCost;
        this.laborCost = laborCost;
        this.freightCost = freightCost;
        this.id = count;
        count++;
    }

    public Part (int id, String partName, String partNumber, BigDecimal materialCost, BigDecimal laborCost, BigDecimal freightCost){
        this(partName, partNumber, materialCost, laborCost, freightCost);
        this.id = id;
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

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public BigDecimal getFreightCost() {
        return freightCost;
    }

    public String toString(){
        return id + " " + partName;
    }

    public void setFreightCost(BigDecimal freightCost) {
        this.freightCost = freightCost;
    }
}
