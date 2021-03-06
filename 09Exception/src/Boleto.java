import java.util.Date;

/**
 * Created by di.ruizdechavez on 13/01/2017.
 */
public class Boleto {
    private float costo;
    private int folio;
    private String origen;
    private String destino;
    private Date fecha;

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) throws FechaInvalidaException {
        if (fecha.before(new Date())) {
            throw new FechaInvalidaException();
        }
        else {
            this.fecha = fecha;
        }
    }
}
