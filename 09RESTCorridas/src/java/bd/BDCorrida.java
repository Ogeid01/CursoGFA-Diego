package bd;

import modelo.Corrida;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ma.diaz.a on 25/01/2017.
 */
public class BDCorrida {

    public static boolean insertarCorrida(Corrida corrida) throws ClassNotFoundException, SQLException{
        Datos DT = new Datos();
        Class.forName(DT.JDBC_DRIVER);
        Connection cx = DriverManager.getConnection(DT.URL_BD,DT.USER,DT.PASS);
        Statement st = cx.createStatement();
        String consulta = String.format("insert into corridas (origen, destino, fechaHoraSalida, fechaHoraLlegada, " +
                "escalas) values('%s','%s','%s','%s','%d')", //STR_TO_DATE('%s','%Y-%m-%d %H:%i:%s')
                corrida.getOrigen(), corrida.getDestino(),
                corrida.getFechaHoraSalida(), corrida.getFechaHoraLlegada(),
                corrida.getEscalas());
        int respuesta = st.executeUpdate(consulta);
        st.close();
        cx.close();
        return respuesta == 1;
    }

    public static Corrida buscarCorrida(int id) throws SQLException, ClassNotFoundException
    {
        Datos DT = new Datos();
        Class.forName(DT.JDBC_DRIVER);
        Connection cx = DriverManager.getConnection(DT.URL_BD,DT.USER,DT.PASS);
        Statement st = cx.createStatement();
        String consulta = "Select * from corridas WHERE idCorrida = " + id;
        ResultSet r = st.executeQuery(consulta);
        Corrida corrida = null;
        if(r.next()){
            corrida = new Corrida(
                    r.getInt("idCorrida"),
                    r.getInt("escalas"),
                    r.getString("origen"),
                    r.getString("destino"),
                    r.getString("fechaHoraSalida"),
                    r.getString("fechaHoraLlegada")
            );
        }
        r.close();
        st.close();
        cx.close();
        return corrida;
    }
}