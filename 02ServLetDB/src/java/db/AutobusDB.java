/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Autobus;

/**
 * Comunicación con la base de datos
 * @author di.ruizdechavez
 */
public class AutobusDB {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/gfajava";
    private static final String USER = "root";
    private static final String PSWD = "Sashimi01";
    
    public List<Autobus> getAutobuses() throws ClassNotFoundException, SQLException{
        Class.forName(JDBC_DRIVER);
        Connection conexion = DriverManager.getConnection(DB_URL,USER,PSWD);
        Statement consulta = conexion.createStatement();
        ResultSet resultado = consulta.executeQuery("SELECT * FROM autobus");
        
        ArrayList<Autobus> lista = new ArrayList<>();
        
        while(resultado.next()){ 
            Autobus autobus = new Autobus();
            autobus.setNum_autobus(resultado.getInt("num_autobus"));
            autobus.setSiglas(resultado.getString("siglas"));
            autobus.setModelo(resultado.getInt("modelo"));
            autobus.setCapacidad(resultado.getInt("capacidad"));
            autobus.setBase(resultado.getString("base"));
            lista.add(autobus);
        }
        resultado.close();
        consulta.close();
        conexion.close();
        return lista;
    }
    
    public int registrarAutobus(Autobus a)throws ClassNotFoundException, SQLException{
        Class.forName(JDBC_DRIVER);
        Connection conexion = DriverManager.getConnection(DB_URL,USER,PSWD);
        Statement consulta = conexion.createStatement();
        
        String query = String.format("INSERT INTO autobus (num_autobus,siglas,modelo,capacidad,base) VALUES ('%d','%s','%d','%d','%s')", a.getNum_autobus(),a.getSiglas(),a.getModelo(),a.getCapacidad(),a.getBase());
        
        int resultado = consulta.executeUpdate(query);
        consulta.close();
        conexion.close();
        return resultado;
        
    }
}
