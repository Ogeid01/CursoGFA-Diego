package ws;

import bd.BDCorrida;
import modelo.Corrida;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 * Created by ma.diaz.a on 25/01/2017.
 */
@Path("/")
public class CorridaWS {

    @Path("Consulta/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Corrida corrida(@PathParam("id")int id){
        
        try {
            return BDCorrida.buscarCorrida(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    @Path("Insertar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Corrida insertar(@QueryParam("origen")String origen,
                            @QueryParam("destino")String destino,
                            @QueryParam("fechaHoraSalida")String fechaHoraSalida,
                            @QueryParam("fechaHoraLlegada")String fechaHoraLlegada,
                            @QueryParam("escalas")int escalas){
        Corrida corrida = new Corrida(0, escalas, origen, destino, fechaHoraSalida, fechaHoraLlegada);
        System.out.println(corrida);
        try{
            BDCorrida.insertarCorrida(corrida);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return corrida;
    }

}