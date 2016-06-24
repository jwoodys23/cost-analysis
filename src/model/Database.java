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

        String checkSql = "Select count(*) as count from parts where id=?";

        PreparedStatement checkStmt = con.prepareStatement(checkSql);

        String insertSql = "insert into parts (id, part_name, part_number, material_cost, labor_cost, freight_cost) values(?, ?, ?, ?, ?, ?)";
        PreparedStatement insertStmt = con.prepareStatement(insertSql);

        for (Part part: parts){
            int id = part.getId();
            String name = part.getPartName();
            String number = part.getPartNumber();
            String material = part.getMaterialCost();
            String labor = part.getLaborCost();
            String freight = part.getFreightCost();

            checkStmt.setInt(1, id);
            ResultSet checkResult = checkStmt.executeQuery();
            checkResult.next();
            int count = checkResult.getInt(1);
            if (count == 0){
                System.out.println("Inserting Person with id: " + id);
                int col = 1;
                insertStmt.setInt(col++, id);
                insertStmt.setString(col++, name);
                insertStmt.setString(col++, number);
                insertStmt.setString(col++, material);
                insertStmt.setString(col++, labor);
                insertStmt.setString(col++, freight);

                insertStmt.executeUpdate();

            } else {
                System.out.println("Updating Person with id: " + id);
            }

        }
        insertStmt.close();
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
