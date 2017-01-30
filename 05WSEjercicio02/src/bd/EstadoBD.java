package bd;

import model.Estado;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by jl.jasso on 21/01/2017.
 */
public class EstadoBD {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/estadosmexico";
    private static final String USER = "root";
    private static final String PASS = "Sashimi01";

    public static String getCapital(String estadoNombre) throws ClassNotFoundException,
            SQLException {

        Class.forName(JDBC_DRIVER);
        Connection conexion = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement st = conexion.createStatement();
        String capital = null;

        String consulta = "SELECT capital from estados where nombre = '" + estadoNombre + "'";
        ResultSet rs = st.executeQuery(consulta);

        if(rs.next()){
            capital = rs.getString("capital");
        }

        conexion.close();
        st.close();
        rs.close();

        return capital;

    }

    public static int getPoblacion(String estadoNombre) throws ClassNotFoundException,
            SQLException {

        Class.forName(JDBC_DRIVER);
        Connection conexion = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement st = conexion.createStatement();
        String capital = null;

        String consulta = "SELECT poblacion from estados where nombre = '" + estadoNombre + "'";
        ResultSet rs = st.executeQuery(consulta);

        int poblacion = 0;

        if(rs.next()){
            poblacion = rs.getInt("poblacion");
        }

        conexion.close();
        st.close();
        rs.close();

        return poblacion;

    }

    public static Estado[] getEstados() throws ClassNotFoundException, SQLException  {

        ArrayList<Estado> estados = new ArrayList<Estado>();
        Class.forName(JDBC_DRIVER);
        Connection conexion = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement st = conexion.createStatement();
        String consulta = "SELECT idEstado, nombre, municipios, capital, comidaTipica, poblacion from estados";
        ResultSet rs = st.executeQuery(consulta);

        while(rs.next()){
            estados.add(new Estado(
                    rs.getInt("idEstado"),
                    rs.getString("nombre"),
                    rs.getInt("municipios"),
                    rs.getString("capital"),
                    rs.getString("comidaTipica"),
                    rs.getInt("poblacion")
                    ));
        }
        conexion.close();
        st.close();
        rs.close();
        Estado[] e = new Estado[estados.size()];
        return estados.toArray(e);

    }
}
