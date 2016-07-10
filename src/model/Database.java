package model;

import java.io.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

/**
 * Created by jourdanwoodrich on 6/21/16.
 */
public class Database {
    private List<Part> parts;
    private Variables variables;
    private String stdLaborHrs;
    private String actualLaborHrs;
    private String overheadRate;
    private String sellingPrice;

    //private double
    //private List<Variables> variables;
    private Connection con;

    public Database(){
        parts = new LinkedList<>();
        variables = new Variables();
       // variables = new LinkedList<>();
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

        String updateSql = "update parts set part_name=?, part_number=?, material_cost=?, labor_cost=?, freight_cost=? where id=?";
        PreparedStatement updateStmt = con.prepareStatement(updateSql);


        for (Part part: parts){
            int id = part.getId();
            String name = part.getPartName();
            String number = part.getPartNumber();
            BigDecimal material = part.getMaterialCost();
            BigDecimal labor = part.getLaborCost();
            BigDecimal freight = part.getFreightCost();

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
                insertStmt.setBigDecimal(col++, material);
                insertStmt.setBigDecimal(col++, labor);
                insertStmt.setBigDecimal(col++, freight);

                insertStmt.executeUpdate();

            } else {
                System.out.println("Updating Person with id: " + id);

                int col = 1;
                updateStmt.setString(col++, name);
                updateStmt.setString(col++, number);
                updateStmt.setBigDecimal(col++, material);
                updateStmt.setBigDecimal(col++, labor);
                updateStmt.setBigDecimal(col++, freight);
                updateStmt.setInt(col++, id);

                updateStmt.executeUpdate();

            }

        }
        updateStmt.close();
        insertStmt.close();
        checkStmt.close();
    }

    public void load() throws SQLException {
        parts.clear();

        Statement selectStmt = con.createStatement();
        String sql = "SELECT id, part_name, part_number, material_cost, labor_cost, freight_cost FROM parts ORDER BY part_name";
        ResultSet results = selectStmt.executeQuery(sql);

        while (results.next()){
            int id = results.getInt("id");
            String name = results.getString("part_name");
            String number = results.getString("part_number");
            BigDecimal material = results.getBigDecimal("material_cost");
            BigDecimal labor = results.getBigDecimal("labor_cost");
            BigDecimal freight = results.getBigDecimal("freight_cost");

            Part part = new Part(id, name, number, material, labor, freight);

            parts.add(part);

            System.out.println(part);

        }

        results.close();
        selectStmt.close();

    }

    public void addPart(Part part){
        parts.add(part);
    }

    public void setVariables(double laborRate, double laborHrs, double overtimeRate, double sellingPrice){
        variables.setLaborRate(laborRate);
        variables.setLaborHrs(laborHrs);
        variables.setOvertimeRate(overtimeRate);
        variables.setSellingPrice(sellingPrice);
        System.out.println("Variables set");
    }


    public void removePart(int row){
        parts.remove(row);
    }

    public List<Part> getPart(){
        return Collections.unmodifiableList(parts);
    }

//    public List<Variables> getVariables(){
//        return Collections.unmodifiableList(variables);
//    }

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
