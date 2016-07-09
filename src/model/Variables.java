package model;

/**
 * Created by jourdanwoodrich on 7/4/16.
 */
public class Variables {
    private int id;
    private double laborRate;
    private double laborHrs;
    private double overtimeRate;
    private double sellingPrice;

    public Variables(){

    }

    public Variables(double laborRate, double laborHrs, double overtimeRate, double sellingPrice){
        this.laborRate = laborRate;
        this.laborHrs = laborHrs;
        this.overtimeRate = overtimeRate;
        this.sellingPrice = sellingPrice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLaborRate() {
        return laborRate;
    }

    public void setLaborRate(double laborRate) {
        this.laborRate = laborRate;
    }

    public double getLaborHrs() {
        return laborHrs;
    }

    public void setLaborHrs(double laborHrs) {
        this.laborHrs = laborHrs;
    }

    public double getOvertimeRate() {
        return overtimeRate;
    }

    public void setOvertimeRate(double overtimeRate) {
        this.overtimeRate = overtimeRate;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
