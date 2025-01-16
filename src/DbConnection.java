import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    static Connection conn = null;

    public DbConnection() {
    }

    static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/car_app_database";
            String user = "root";
            String password = "Koko.1593578462";
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException var1) {
            ClassNotFoundException e = var1;
            e.printStackTrace();
        } catch (SQLException var2) {
            SQLException e = var2;
            e.printStackTrace();
        }

        return conn;
    }
}