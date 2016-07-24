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
    private BigDecimal actualMaterialCost;
    private BigDecimal stdMaterialCost;
    private BigDecimal actualLaborCost;
    private BigDecimal stdLaborCost;
    private BigDecimal actualFreightCost;
    private BigDecimal stdFreightCost;
    private BigDecimal laborVariance;
    private BigDecimal materialVariance;
    private String constant;
    private BigDecimal totalActual;
    private BigDecimal totalStandard;


    public Part (String partName, String partNumber, BigDecimal actualMaterialCost, BigDecimal actualLaborCost, BigDecimal actualFreightCost){
        this.partName = partName;
        this.partNumber = partNumber;
        this.actualMaterialCost = actualMaterialCost;
        this.actualLaborCost = actualLaborCost;
        this.actualFreightCost = actualFreightCost;
        this.id = count;
        count++;
    }

    public Part (String partName, String partNumber, BigDecimal actualMaterialCost, BigDecimal stdMaterialCost, BigDecimal actualLaborCost, BigDecimal stdLaborCost, BigDecimal actualFreightCost){
        this(partName, partNumber, actualMaterialCost, actualLaborCost, actualFreightCost);
        this.stdMaterialCost = stdMaterialCost;
        this.stdLaborCost = stdLaborCost;
    }

    public Part (int id, String partName, String partNumber, BigDecimal actualMaterialCost, BigDecimal stdMaterialCost, BigDecimal actualLaborCost, BigDecimal stdLaborCost, BigDecimal actualFreightCost, BigDecimal laborVariance, BigDecimal materialVariance, String constant, BigDecimal totalActual, BigDecimal totalStandard){
        this(partName, partNumber, actualMaterialCost, stdMaterialCost, actualLaborCost, stdLaborCost, actualFreightCost);
        this.id = id;
        this.materialVariance = materialVariance;
        this.laborVariance = laborVariance;
        this.constant = constant;
        this.totalActual = totalActual;
        this.totalStandard = totalStandard;
    }

    public Part (String partName, String partNumber, BigDecimal actualMaterialCost, BigDecimal stdMaterialCost, BigDecimal actualLaborCost, BigDecimal stdLaborCost, BigDecimal actualFreightCost, BigDecimal laborVariance, BigDecimal materialVariance, String constant, BigDecimal totalActual, BigDecimal totalStandard){
        this(partName, partNumber, actualMaterialCost, stdMaterialCost, actualLaborCost, stdLaborCost, actualFreightCost);
        this.materialVariance = materialVariance;
        this.laborVariance = laborVariance;
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

    public BigDecimal getActualMaterialCost() {
        return actualMaterialCost;
    }

    public void setActualMaterialCost(BigDecimal actualMaterialCost) {
        this.actualMaterialCost = actualMaterialCost;
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

    public BigDecimal getStdFreightCost() {
        return stdFreightCost;
    }

    public void setStdFreightCost(BigDecimal stdFreightCost) {
        this.stdFreightCost = stdFreightCost;
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
        return actualMaterialCost;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.actualMaterialCost = materialCost;
    }

    public BigDecimal getActualLaborCost() {
        return actualLaborCost;
    }

    public void setActualLaborCost(BigDecimal actualLaborCost) {
        this.actualLaborCost = actualLaborCost;
    }

    public BigDecimal getActualFreightCost() {
        return actualFreightCost;
    }

    public String toString(){
        return id + " " + partName;
    }

    public void setActualFreightCost(BigDecimal actualFreightCost) {
        this.actualFreightCost = actualFreightCost;
    }
}
