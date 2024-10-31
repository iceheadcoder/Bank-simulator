import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DBconnection {

    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASS = "eshaan"; 

    public static void main(String[] args) { 
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stat = conn.createStatement();)
        {
            String sql = "CREATE DATABASE BANKSIM";
            stat.executeUpdate(sql);
            System.out.println("Database created successfully...");
        } catch (SQLException e) {

            e.printStackTrace();
        }  
    }
}
