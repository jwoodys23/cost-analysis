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

    //private double
    //private List<Variables> variables;
    private Connection con;

    private int port;
    private String user;
    private String password;


    public void configure(int port, String user, String password) throws Exception{
        this.port = port;
        this.user = user;
        this.password = password;

        if (con!=null){
            disconnect();
            connect();
        }
    }

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

        String url = String.format("jdbc:mysql://localhost:%d/swingtest?autoReconnect=true&useSSL=false", port);
        con = DriverManager.getConnection(url, user, password);
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

    public void deletePart(int row) throws SQLException{

        String deleteSql = "DELETE FROM parts WHERE id=?";
        PreparedStatement deleteStmt = con.prepareStatement(deleteSql);
        deleteStmt.setInt(1, row);
        System.out.println("Deleting part with id: " + row);

        deleteStmt.execute();


    }




    public void save() throws SQLException{

        String checkSql = "Select count(*) as count from parts where id=?";

        PreparedStatement checkStmt = con.prepareStatement(checkSql);

        String insertSql = "insert into parts (id, part_name, part_number, material_cost, labor_cost, freight_cost, stdMaterialCost, stdLaborCost, laborVariance, materialVariance, constant, totalActual, totalStandard) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertStmt = con.prepareStatement(insertSql);

        String updateSql = "update parts set part_name=?, part_number=?, material_cost=?, labor_cost=?, freight_cost=?, stdMaterialCost=?, stdLaborCost=?, laborVariance=?, materialVariance=?, constant=?, totalActual=?, totalStandard=? where id=?";
        PreparedStatement updateStmt = con.prepareStatement(updateSql);


        for (Part part: parts){
            int id = part.getId();
            String name = part.getPartName();
            String number = part.getPartNumber();
            BigDecimal material = part.getMaterialCost();
            BigDecimal labor = part.getActualLaborCost();
            BigDecimal freight = part.getActualFreightCost();
            BigDecimal stdMaterial = part.getStdMaterialCost();
            BigDecimal stdLabor = part.getStdLaborCost();
            BigDecimal laborVariance = part.getLaborVariance();
            BigDecimal materialVariance = part.getMaterialVariance();
            String constant = part.getConstant();
            BigDecimal totalActual = part.getTotalActual();
            BigDecimal totalStandard = part.getTotalStandard();


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
                insertStmt.setBigDecimal(col++, stdMaterial);
                insertStmt.setBigDecimal(col++, stdLabor);
                insertStmt.setBigDecimal(col++, laborVariance);
                insertStmt.setBigDecimal(col++, materialVariance);
                insertStmt.setString(col++, constant);
                insertStmt.setBigDecimal(col++, totalActual);
                insertStmt.setBigDecimal(col++, totalStandard);

                insertStmt.executeUpdate();

            } else {
                System.out.println("Updating Person with id: " + id);

                int col = 1;
                updateStmt.setString(col++, name);
                updateStmt.setString(col++, number);
                updateStmt.setBigDecimal(col++, material);
                updateStmt.setBigDecimal(col++, labor);
                updateStmt.setBigDecimal(col++, freight);
                updateStmt.setBigDecimal(col++, stdMaterial);
                updateStmt.setBigDecimal(col++, stdLabor);
                updateStmt.setBigDecimal(col++, laborVariance);
                updateStmt.setBigDecimal(col++, materialVariance);
                updateStmt.setString(col++, constant);
                updateStmt.setBigDecimal(col++, totalActual);
                updateStmt.setBigDecimal(col++, totalStandard);
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
        String sql = "SELECT id, part_name, part_number, material_cost, labor_cost, freight_cost, stdMaterialCost, stdLaborCost, laborVariance, materialVariance, constant, totalActual, totalStandard FROM parts ORDER BY part_name";
        ResultSet results = selectStmt.executeQuery(sql);

        while (results.next()){
            int id = results.getInt("id");
            String name = results.getString("part_name");
            String number = results.getString("part_number");
            BigDecimal material = results.getBigDecimal("material_cost");
            BigDecimal labor = results.getBigDecimal("labor_cost");
            BigDecimal freight = results.getBigDecimal("freight_cost");
            BigDecimal stdMaterial = results.getBigDecimal("stdMaterialCost");
            BigDecimal stdLabor = results.getBigDecimal("stdLaborCost");
            BigDecimal laborVariance = results.getBigDecimal("laborVariance");
            BigDecimal materialVariance = results.getBigDecimal("materialVariance");
            String constant = results.getString("constant");
            BigDecimal totalActual = results.getBigDecimal("totalActual");
            BigDecimal totalStandard = results.getBigDecimal("totalStandard");


            Part part = new Part(id, name, number, material, stdMaterial,labor, stdLabor, freight, laborVariance, materialVariance, constant, totalActual, totalStandard);

            parts.add(part);

            System.out.println(part);

        }

        results.close();
        selectStmt.close();

    }

    public void addPart(Part part){
        parts.add(part);
    }

    public void addVariable(BigDecimal stdLabor, BigDecimal actualLabor, BigDecimal overheadRate, BigDecimal actOverhead, BigDecimal actualFreight, BigDecimal price){

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
