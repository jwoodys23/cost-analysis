package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jourdanwoodrich on 6/21/16.
 */
public class Database {
    private ArrayList<Part> parts;

    public Database(){
        parts = new ArrayList<>();
    }

    public void addPart(Part part){
        parts.add(part);
    }

    public List<Part> getPart(){
        return parts;
    }
}
