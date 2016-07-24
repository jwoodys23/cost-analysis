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
    private BigDecimal stdMaterialCost;
    private BigDecimal stdLaborCost;
    private BigDecimal laborVariance;
    private BigDecimal materialVariance;
    private String constant;
    private BigDecimal totalActual;
    private BigDecimal totalStandard;


    public FormEvent(Object source){
        super(source);
    }

    public FormEvent(Object source, String partName, String partNumber, BigDecimal materialCost, BigDecimal stdMaterialCost, BigDecimal laborCost, BigDecimal stdLaborCost,BigDecimal freightCost, BigDecimal laborVariance, BigDecimal materialVariance, String constant, BigDecimal totalActual, BigDecimal totalStandard){
        super(source);

        this.partName = partName;
        this.partNumber = partNumber;
        this.materialCost = materialCost;
        this.laborCost = laborCost;
        this.freightCost = freightCost;
        this.stdMaterialCost = stdMaterialCost;
        this.stdLaborCost = stdLaborCost;
        this.laborVariance = laborVariance;
        this.materialVariance = materialVariance;
        this.constant = constant;
        this.totalActual = totalActual;
        this.totalStandard = totalStandard;
    }

    public BigDecimal getLaborVariance() {
        return laborVariance;
    }

    public void setLaborVariance(BigDecimal laborVariance) {
        this.laborVariance = laborVariance;
    }

    public BigDecimal getMaterialVariance() {
        return materialVariance;
    }

    public void setMaterialVariance(BigDecimal materialVariance) {
        this.materialVariance = materialVariance;
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant;
    }

    public BigDecimal getTotalActual() {
        return totalActual;
    }

    public void setTotalActual(BigDecimal totalActual) {
        this.totalActual = totalActual;
    }

    public BigDecimal getTotalStandard() {
        return totalStandard;
    }

    public void setTotalStandard(BigDecimal totalStandard) {
        this.totalStandard = totalStandard;
    }

    public BigDecimal getStdMaterialCost() {
        return stdMaterialCost;
    }

    public void setStdMaterialCost(BigDecimal stdMaterialCost) {
        this.stdMaterialCost = stdMaterialCost;
    }

    public BigDecimal getStdLaborCost() {
        return stdLaborCost;
    }

    public void setStdLaborCost(BigDecimal stdLaborCost) {
        this.stdLaborCost = stdLaborCost;
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
