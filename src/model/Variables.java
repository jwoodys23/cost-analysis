package model;

/**
 * Created by jourdanwoodrich on 7/4/16.
 */
public class Variables {
    private Double stdLabor;
    private Double actualLabor;
    private Double overheadRate;
    private Double actOverhead;
    private Double actualFreight;
    private Double price;

    public Variables(){

    }


    public Variables(Double stdLabor, Double actualLabor, Double overheadRate, Double actOverhead, Double actualFreight, Double price){
        this.stdLabor = stdLabor;
        this.actualLabor = actualLabor;
        this.overheadRate = overheadRate;
        this.actOverhead = actOverhead;
        this.actualFreight = actualFreight;
        this.price = price;
    }


    public Double getActualFreight() {
        return actualFreight;
    }

    public void setActualFreight(Double actualFreight) {
        this.actualFreight = actualFreight;
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
