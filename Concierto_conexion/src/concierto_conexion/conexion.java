
package concierto_conexion;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class conexion {
    String bd="conciertos";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="campus2023";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx;
    
    public conexion(){
    }
    
    public Connection conectar(){
        try{ 
            Class.forName(driver);
            cx=DriverManager.getConnection(url+bd,user,password);
            System.out.println("se conecto a bd "+bd);
        }
        catch(ClassNotFoundException |SQLException ex){
            System.out.println(" no se conecto a bd "+bd);
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE,null, ex);
        }
      return cx;
    }
    public void desconectar(){
        try{ 
            cx.close();
        }
        catch(SQLException ex){
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
 
}
