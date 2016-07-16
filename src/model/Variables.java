package model;

import java.math.BigDecimal;

/**
 * Created by jourdanwoodrich on 7/4/16.
 */
public class Variables {
    private BigDecimal stdLabor;
    private BigDecimal actualLabor;
    private BigDecimal overheadRate;
    private BigDecimal actOverhead;
    private BigDecimal actualFreight;
    private BigDecimal price;

    public Variables(){

    }


    public Variables(BigDecimal stdLabor, BigDecimal actualLabor, BigDecimal overheadRate, BigDecimal actOverhead, BigDecimal actualFreight, BigDecimal price){
        this.stdLabor = stdLabor;
        this.actualLabor = actualLabor;
        this.overheadRate = overheadRate;
        this.actOverhead = actOverhead;
        this.actualFreight = actualFreight;
        this.price = price;
    }


    public BigDecimal getActualFreight() {
        return actualFreight;
    }

    public void setActualFreight(BigDecimal actualFreight) {
        this.actualFreight = actualFreight;
    }

    public BigDecimal getStdLabor() {
        return stdLabor;
    }

    public void setStdLabor(BigDecimal stdLabor) {
        this.stdLabor = stdLabor;
    }

    public BigDecimal getActualLabor() {
        return actualLabor;
    }

    public void setActualLabor(BigDecimal actualLabor) {
        this.actualLabor = actualLabor;
    }

    public BigDecimal getOverheadRate() {
        return overheadRate;
    }

    public void setOverheadRate(BigDecimal overheadRate) {
        this.overheadRate = overheadRate;
    }

    public BigDecimal getActOverhead() {
        return actOverhead;
    }

    public void setActOverhead(BigDecimal actOverhead) {
        this.actOverhead = actOverhead;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
