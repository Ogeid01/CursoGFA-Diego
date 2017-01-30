/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author di.ruizdechavez
 */
public class MariaDB <T> {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/gfajava";
    private static final String USER = "root";
    private static final String PSWD = "Sashimi01";

    public MariaDB() {
    }
    
    public T[] obtenerDatos(String consulta) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
        Class.forName(JDBC_DRIVER);
        Connection conexion = DriverManager.getConnection(DB_URL,USER,PSWD);
        Statement query = conexion.createStatement();
        ResultSet rs = query.executeQuery(consulta);

        List<String> columnNames = new ArrayList<>();
        ResultSetMetaData rsmd = rs.getMetaData();
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            columnNames.add(rsmd.getColumnLabel(i));
        }
        int rowIndex = 0;
        ArrayList<T> datos = new ArrayList<>();
        while (rs.next()) {
            rowIndex++;
            // collect row data as objects in a List
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                T dato;
                dato = (T) rs.getClass().newInstance().getObject(i);
                datos.add(dato);
            }
            // for test purposes, dump contents to check our results
            // (the real code would pass the "rowData" List to some other routine)
            System.out.printf("Row %d%n", rowIndex);
            for (int colIndex = 0; colIndex < rsmd.getColumnCount(); colIndex++) {
                String objType = "null";
                String objString = "";
                Object columnObject = datos.get(colIndex);
                if (columnObject != null) {
                    objString = columnObject.toString() + " ";
                    objType = columnObject.getClass().getName();
                }
                System.out.printf("  %s: %s(%s)%n",
                        columnNames.get(colIndex), objString, objType);
            }
        }
//        T dato = new T()
//        T[] resultado;
//        resultado = (T[]) Array.newInstance(<T>, datos.size());
//        return resultado;
        return null;
    }
}
