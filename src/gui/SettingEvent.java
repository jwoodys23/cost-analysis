package gui;

import java.util.EventObject;

/**
 * Created by jourdanwoodrich on 7/4/16.
 */
public class SettingEvent extends EventObject {
    private Double stdLabor;
    private Double actualLabor;
    private Double overheadRate;
    private Double actOverhead;
    private Double actFreight;
    private Double price;
    public SettingEvent(Object source){ super(source); }

    public SettingEvent(Object source, Double stdLabor, Double actualLabor, Double overheadRate, Double actOverhead, Double actFreight, Double price){
        super(source);
        this.stdLabor = stdLabor;
        this.actualLabor = actualLabor;
        this.overheadRate = overheadRate;
        this.actOverhead = actOverhead;
        this.actFreight = actFreight;
        this.price = price;

    }


    public Double getActFreight() {
        return actFreight;
    }

    public void setActFreight(Double actFreight) {
        this.actFreight = actFreight;
    }

    public Double getStdLabor() {
        return stdLabor;
    }

    public void setStdLabor(Double stdLabor) {
        this.stdLabor = stdLabor;
    }

    public Double getActualLabor() {
        return actualLabor;
    }

    public void setActualLabor(Double actualLabor) {
        this.actualLabor = actualLabor;
    }

    public Double getOverheadRate() {
        return overheadRate;
    }

    public void setOverheadRate(Double overheadRate) {
        this.overheadRate = overheadRate;
    }

    public Double getActOverhead() {
        return actOverhead;
    }

    public void setActOverhead(Double actOverhead) {
        this.actOverhead = actOverhead;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
