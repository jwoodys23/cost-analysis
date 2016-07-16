package gui;

import java.util.EventObject;

/**
 * Created by jourdanwoodrich on 7/4/16.
 */
public class SettingEvent extends EventObject {
    private String stdLabor;
    private String  actualLabor;
    private String  overheadRate;
    private String  actOverhead;
    private String  actFreight;
    private String  price;
    public SettingEvent(Object source){ super(source); }

    public SettingEvent(Object source, String stdLabor, String  actualLabor, String  overheadRate, String  actOverhead, String  actFreight, String  price){
        super(source);
        this.stdLabor = stdLabor;
        this.actualLabor = actualLabor;
        this.overheadRate = overheadRate;
        this.actOverhead = actOverhead;
        this.actFreight = actFreight;
        this.price = price;

    }


    public String  getActFreight() {
        return actFreight;
    }

    public void setActFreight(String  actFreight) {
        this.actFreight = actFreight;
    }

    public String getStdLabor() {
        return stdLabor;
    }

    public void setStdLabor(String stdLabor) {
        this.stdLabor = stdLabor;
    }

    public String  getActualLabor() {
        return actualLabor;
    }

    public void setActualLabor(String  actualLabor) {
        this.actualLabor = actualLabor;
    }

    public String  getOverheadRate() {
        return overheadRate;
    }

    public void setOverheadRate(String  overheadRate) {
        this.overheadRate = overheadRate;
    }

    public String  getActOverhead() {
        return actOverhead;
    }

    public void setActOverhead(String  actOverhead) {
        this.actOverhead = actOverhead;
    }

    public String  getPrice() {
        return price;
    }

    public void setPrice(String  price) {
        this.price = price;
    }
}
