import model.Database;
import model.Part;

import java.sql.SQLException;

/**
 * Created by jourdanwoodrich on 6/23/16.
 */
public class TestDatabase {
    public static void main(String[] args) {
        System.out.println("Running Database test");
        Database db = new Database();

        try {
            db.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        db.addPart(new Part("Engine", "001-1234", "1200.00", "120.00", "25.00"));
        db.addPart(new Part("Radiator", "002-1235", "800.00", "60.00", "15.00"));

        try {
            db.save();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            db.load();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.disconnect();
    }
}
