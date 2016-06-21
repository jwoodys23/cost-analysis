package controller;

import gui.FormEvent;
import model.Database;
import model.Part;

/**
 * Created by jourdanwoodrich on 6/21/16.
 */
public class Controller {

    Database db = new Database();

    public void addPart(FormEvent e){
        String partName = e.getPartName();
        String partNumber = e.getPartNumber();
        String materialCost = e.getMaterialCost();
        String laborCost = e.getLaborCost();
        String freightCost = e.getFreightCost();

        Part part = new Part(partName,partNumber,materialCost,laborCost,freightCost);
        db.addPart(part);

    }
}
