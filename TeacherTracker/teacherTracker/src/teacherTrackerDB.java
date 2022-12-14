import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class teacherTrackerDB {

    public static Connection connect() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/teacherTracker", "root", "242802");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

}
