package controller;

import gui.FormEvent;
import gui.SettingEvent;
import model.Database;
import model.Part;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
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



    public void configure(int port, String user, String password) throws Exception{
        db.configure(port, user, password);
    }


    public void addVariable(SettingEvent e){
        String stdLabor = e.getStdLabor();
        String actualLabor = e.getActualLabor();
        String overheadRate = e.getOverheadRate();
        String actOverhead = e.getActOverhead();
        String actualFreight = e.getActFreight();
        String price = e.getPrice();

        BigDecimal standardLabor =  new BigDecimal(stdLabor.replaceAll("[^.\\d]", ""));
        BigDecimal actLabor =  new BigDecimal(actualLabor.replaceAll("[^.\\d]", ""));
        BigDecimal stdOverheadRate =  new BigDecimal(overheadRate.replaceAll("[^.\\d]", ""));
        BigDecimal actualOverhead =  new BigDecimal(actOverhead.replaceAll("[^.\\d]", ""));
        BigDecimal actFreight =  new BigDecimal(actualFreight.replaceAll("[^.\\d]", ""));
        BigDecimal sellingPrice =  new BigDecimal(price.replaceAll("[^.\\d]", ""));


        //Variables variables = new Variables(stdLabor, actualLabor, overheadRate, actOverhead, price);
        db.addVariable(standardLabor, actLabor, stdOverheadRate,actualOverhead, actFreight, sellingPrice);

        //System.out.println(variables.getActOverhead());
    }


    public void addPart(FormEvent e){
        String partName = e.getPartName();
        String partNumber = e.getPartNumber();
        BigDecimal materialCost = e.getMaterialCost();
        BigDecimal laborCost = e.getLaborCost();
        BigDecimal freightCost = e.getFreightCost();
        BigDecimal stdMaterialCost = e.getStdMaterialCost();
        BigDecimal stdLaborCost = e.getStdLaborCost();
        BigDecimal laborVariance = e.getLaborVariance();
        BigDecimal materialVariance = e.getMaterialVariance();
        String constant = e.getConstant();
        BigDecimal totalActual = e.getTotalActual();
        BigDecimal totalStandard = e.getTotalStandard();



        Part part = new Part(partName,partNumber,materialCost, stdMaterialCost, laborCost, stdLaborCost, freightCost, laborVariance, materialVariance, constant, totalActual, totalStandard);
        db.addPart(part);

    }
    public void removePart(int index){
        db.removePart(index);
    }

    public void deletePart(int index) throws SQLException{
        db.deletePart(index);
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
