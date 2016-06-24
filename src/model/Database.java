package model;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * Created by jourdanwoodrich on 6/21/16.
 */
public class Database {
    private List<Part> parts;
    private Connection con;

    public Database(){
        parts = new LinkedList<>();
    }

    public void connect() throws Exception {

        if (con!=null) return;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new Exception("Driver not found");
        }

        String url = "jdbc:mysql://localhost:3306/swingtest?autoReconnect=true&useSSL=false";
        con = DriverManager.getConnection(url, "root", "password");
        System.out.println("Connected: " + con);
    }

    public void disconnect(){
        if (con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Can't close connection");
            }
        }
    }

    public void save() throws SQLException{

        String checkSql = "Select count(*) as count from swingtest.parts where id=?";

        PreparedStatement checkStmt = con.prepareStatement(checkSql);
        for (Part part: parts){
            int id = part.getId();

            checkStmt.setInt(1, id);
            ResultSet checkResult = checkStmt.executeQuery();
            checkResult.next();
            int count = checkResult.getInt(1);
            System.out.println("Count for person with id: " + id + " is " + count);


        }
        checkStmt.close();
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
