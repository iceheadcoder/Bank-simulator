import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.Statement;


public class DBconnection {

    Connection c;
    Statement s;

    public DBconnection(){
        try{
            c = DriverManager.getConnection("jdbc:mysql:///banksim","root","eshaan");
            s = c.createStatement();
        }catch (Exception e) {
            System.out.println(e);
        }  
    
    }
      
}
