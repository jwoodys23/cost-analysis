package controller;

import gui.FormEvent;
import gui.SettingEvent;
import gui.VariancePanel;
import model.Database;
import model.Part;
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

    Database db = new Database();
    VariancePanel variancePanel = new VariancePanel();


    public List<Part> getPart(){
        return db.getPart();
    }


    public void addSettings(SettingEvent e){
        double laborRate = e.getLaborRate();
        double laborHrs = e.getLaborHrs();
        double overtimeRate = e.getOvertimeRate();
        double sellingPrice = e.getSellingPrice();
//        variancePanel.revalidate();
//        variancePanel.repaint();

        //Variables variables = new Variables(laborRate,laborHrs, overtimeRate, sellingPrice);

        //Added only so that the variables are also in the Database class to keep mvc structure
        db.setVariables(laborRate,laborHrs, overtimeRate, sellingPrice);
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
