package model;

import java.io.*;
import java.util.*;

/**
 * Created by jourdanwoodrich on 6/21/16.
 */
public class Database {
    private List<Part> parts;

    public Database(){
        parts = new LinkedList<>();
    }

    public void addPart(Part part){
        parts.add(part);
    }

    public void removePart(int row){
        parts.remove(row);
    }

    public List<Part> getPart(){
        return Collections.unmodifiableList(parts);
    }

    public void saveToFile (File file) throws IOException{
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Part[] partsArray = parts.toArray(new Part[parts.size()]);

        oos.writeObject(partsArray);

        oos.close();

    }

    public void loadFromFile (File file) throws IOException{

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            Part[] partsArray = (Part[]) ois.readObject();
            parts.clear();
            parts.addAll(Arrays.asList(partsArray));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ois.close();
    }
}
