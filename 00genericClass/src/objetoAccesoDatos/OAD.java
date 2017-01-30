package objetoAccesoDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author di.ruizdechavez
 */
public class OAD <T> {
    private String JDBC_DRIVER;
    private String DB_URL;
    private String USER;
    private String PSWD;

    public OAD() {
        this.DB_URL = "jdbc:mysql://localhost:3306/estadosmexico";
        this.JDBC_DRIVER = "com.mysql.jdbc.Driver";
        this.USER = "root";
        this.PSWD = "Sashimi01";
    }

    public OAD(String JDBC_DRIVER, String DB_URL, String USER, String PSWD) {
        this.JDBC_DRIVER = JDBC_DRIVER;
        this.DB_URL = DB_URL;
        this.USER = USER;
        this.PSWD = PSWD;
    }
    
    public void guardar(String insert){
    }
    
    public T leer(String consulta) 
    {
        try {
            Class.forName(this.JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OAD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(this.DB_URL,this.USER,this.PSWD);
        } catch (SQLException ex) {
            Logger.getLogger(OAD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Statement query = null;
        try {
            query = conexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(OAD.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = null;
        try {
            rs = query.executeQuery(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(OAD.class.getName()).log(Level.SEVERE, null, ex);
        }
            // para sacar los nombres de las columnas:
//        List<String> nombres = new ArrayList<>();
//        ResultSetMetaData rsmd = rs.getMetaData();
//        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
//            nombres.add(rsmd.getColumnLabel(i));
//        }
        try {
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(OAD.class.getName()).log(Level.SEVERE, null, ex);
        }
//        dato = (T) rs.getClass().newInstance();
        System.out.println(rs.toString()); 
        
        return  (T) rs;
    }
    
    public T[] leerTodo(String consulta) throws ClassNotFoundException, SQLException{
        return null;
    }
}
