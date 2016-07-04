package controller;

import gui.FormEvent;
import gui.SettingEvent;
import model.Database;
import model.Part;
import model.Settings;
import model.Variables;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by jourdanwoodrich on 6/21/16.
 */
public class Controller {

    Database db = new Database();


    public List<Part> getPart(){
        return db.getPart();
    }

    public List<Variables> getVariables(){
        return db.getVariables();
    }

    public void addSettings(SettingEvent e){
        String laborRate = e.getLaborRate();
        String laborHrs = e.getLaborHrs();
        String overtimeRate = e.getOvertimeRate();
        String sellingPrice = e.getSellingPrice();

        Variables variables = new Variables(laborRate,laborHrs, overtimeRate, sellingPrice);
        System.out.println(variables.getLaborHrs());
    }
    public void setSettings (){
//        double laborRate = settings.getLaborRate();
//        double laborHrs = settings.getLaborHrs();
//        double overtimeRate = settings.getOvertimeRate();
//        double sellingPrice = settings.getSellingPrice();
//        Settings settings = new Settings(laborRate, laborHrs);
        System.out.println("Set Settings was called");
    }


    public void addPart(FormEvent e){
        String partName = e.getPartName();
        String partNumber = e.getPartNumber();
        String materialCost = e.getMaterialCost();
        String laborCost = e.getLaborCost();
        String freightCost = e.getFreightCost();

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
