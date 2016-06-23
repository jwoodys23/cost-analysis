import model.Database;

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
        db.disconnect();
    }
}
