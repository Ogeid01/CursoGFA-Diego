/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

/**
 *
 * @author di.ruizdechavez
 */
public class CorridasBD {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/gfajava";
    private static final String USER = "root";
    private static final String PSWD = "Sashimi01";

    public static int insCorrida (String origen, String destino, Date fechaSalida,
            Time horaSalida, Date fechaLlegada, Time horaLlegada, int escalas)
            throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection conexion = DriverManager.getConnection(DB_URL,USER,PSWD);
        Statement query = conexion.createStatement();
        String insert = String.format("INSERT INTO corridas "
                + "(origen, destino, fechaSalida, horaSalida, fechaLlegada, horaLlegada, escalas) "
                + "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', %d)", 
                origen, destino, fechaSalida, horaSalida, fechaLlegada, horaLlegada, escalas);
        
        int resultado = query.executeUpdate(insert);
        query.close();
        conexion.close();
        return resultado;
    } 
}
