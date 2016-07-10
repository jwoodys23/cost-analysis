package gui;

import java.math.BigDecimal;
import java.util.EventObject;

/**
 * Created by jourdanwoodrich on 6/20/16.
 */
public class FormEvent extends EventObject{
    private String partName;
    private String partNumber;
    private BigDecimal materialCost;
    private BigDecimal laborCost;
    private BigDecimal freightCost;

    public FormEvent(Object source){
        super(source);
    }

    public FormEvent(Object source, String partName, String partNumber, BigDecimal materialCost, BigDecimal laborCost, BigDecimal freightCost){
        super(source);

        this.partName = partName;
        this.partNumber = partNumber;
        this.materialCost = materialCost;
        this.laborCost = laborCost;
        this.freightCost = freightCost;
    }

    public BigDecimal getFreightCost() {
        return freightCost;
    }

    public void setFreightCost(BigDecimal freightCost) {
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
}
