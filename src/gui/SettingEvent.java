package gui;

import java.util.EventObject;

/**
 * Created by jourdanwoodrich on 7/4/16.
 */
public class SettingEvent extends EventObject {
    private String laborRate;
    private String laborHrs;
    private String overtimeRate;
    private String sellingPrice;
    public SettingEvent(Object source){ super(source); }

    public SettingEvent(Object source, String laborRate, String laborHrs, String overtimeRate, String sellingPrice ){
        super(source);
        this.laborRate = laborRate;
        this.laborHrs = laborHrs;
        this.overtimeRate = overtimeRate;
        this.sellingPrice = sellingPrice;
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
