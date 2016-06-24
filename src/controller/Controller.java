package controller;

import gui.FormEvent;
import model.Database;
import model.Part;

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
