package model;

/**
 * Created by jourdanwoodrich on 7/4/16.
 */
public class Variables {
    private int id;
    private String laborRate;
    private String laborHrs;
    private String overtimeRate;
    private String sellingPrice;

    public Variables(String laborRate, String laborHrs, String overtimeRate, String sellingPrice){
        this.laborRate = laborRate;
        this.laborHrs = laborHrs;
        this.overtimeRate = overtimeRate;
        this.sellingPrice = sellingPrice;
    }
    public Variables(int id, String laborRate, String laborHrs, String overtimeRate, String sellingPrice){
        this.laborRate = laborRate;
        this.laborHrs = laborHrs;
        this.overtimeRate = overtimeRate;
        this.sellingPrice = sellingPrice;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLaborRate() {
        return laborRate;
    }

    public void setLaborRate(String laborRate) {
        this.laborRate = laborRate;
    }

    public String getLaborHrs() {
        return laborHrs;
    }

    public void setLaborHrs(String laborHrs) {
        this.laborHrs = laborHrs;
    }

    public String getOvertimeRate() {
        return overtimeRate;
    }

    public void setOvertimeRate(String overtimeRate) {
        this.overtimeRate = overtimeRate;
    }

    public String getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(String sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
