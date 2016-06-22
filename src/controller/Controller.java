package controller;

import gui.FormEvent;
import model.Database;
import model.Part;

import java.io.File;
import java.io.IOException;
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

    public void saveToFile(File file) throws IOException{
        db.saveToFile(file);
    }

    public void loadFromFile(File file) throws IOException {
        db.loadFromFile(file);
    }
}
