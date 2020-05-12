
package koneksi;

import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksiDB {
    private static Connection con;
    
    public static Connection getkoneksi(){
        if (con==null){
            try{
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                con = DriverManager.getConnection("jdbc:mysql://localhost/db_laundry", "root", "");
                System.out.println("Berhasil");
            } catch (Exception e){
                e.getStackTrace();
            }
        }
        return con;
    }

    public static class con {

        public con() {
        }
    }
}
