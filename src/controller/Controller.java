package controller;

import gui.FormEvent;
import gui.SettingEvent;
import gui.VariancePanel;
import model.Database;
import model.Part;
import model.Settings;
import model.Variables;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Currency;
import java.util.List;

/**
 * Created by jourdanwoodrich on 6/21/16.
 */
public class Controller {
   // private Variables variables;

    Database db = new Database();
    //VariancePanel variancePanel = new VariancePanel();


    public List<Part> getPart(){
        return db.getPart();
    }

    public Variables getVariables(){
        return db.getVariables();
    }


    public void addVariable(SettingEvent e){
        Double stdLabor = e.getStdLabor();
        Double actualLabor = e.getActualLabor();
        Double overheadRate = e.getOverheadRate();
        Double actOverhead = e.getActOverhead();
        Double actualFreight = e.getActFreight();
        Double price = e.getPrice();

        //Variables variables = new Variables(stdLabor, actualLabor, overheadRate, actOverhead, price);
        db.addVariable(stdLabor, actualLabor, overheadRate,actOverhead, actualFreight, price);

        //System.out.println(variables.getActOverhead());
    }

    public void getLabor(){

    }


    public void addPart(FormEvent e){
        String partName = e.getPartName();
        String partNumber = e.getPartNumber();
        BigDecimal materialCost = e.getMaterialCost();
        BigDecimal laborCost = e.getLaborCost();
        BigDecimal freightCost = e.getFreightCost();

        Part part = new Part(partName,partNumber,materialCost,laborCost,freightCost);
        db.addPart(part);

    }
    public void removePart(int index){
        db.removePart(index);
    }

    public void saveToFile(File file) throws IOException{
        db.saveToFile(file);
    }

    public void loadFromFile(File file) throws IOException {
        db.loadFromFile(file);
    }

    public void saveVariable() throws SQLException{
        db.saveVariable();
    }

    public void save() throws SQLException {
        db.save();
    }

    public void disconnect(){
        db.disconnect();
    }

    public void connect() throws Exception {
        db.connect();
    }

    public void load() throws SQLException {
        db.load();
    }
}
