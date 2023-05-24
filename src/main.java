import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class main {
    public static void main(String[] args) {

        Connection connection = null;

        try {
            //Load the JDBC driver
            String driverName = "org.gjt.mm.mysql.Driver";
            Class.forName(driverName);

            //Create a connection to the database
            String serverName = "http://localhost/phpmyadmin/";
            String mydatabase = "bd_rh";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "username";
            String password = "your_password";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            //Could not find the database driver
            String msg = "erro1";
        } catch (SQLException e) {
            //Could not connect to the database
            String msg = "erro2";
        }

        try {
            Statement stmt = connection.createStatement();

            //Use TRUNCATE
            String sql = "TRUNCATE my_table";

            //Use DELETE
            sql = "DELETE FROM my_table";

            //Execute deletion
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            String msg = "erro3";
        }
    }
}
