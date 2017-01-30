/**
 * Created by di.ruizdechavez on 13/01/2017.
 */
public class Avion extends Vehiculo {
    int turbinas;
    int pasajetos;
    String Tipo;

    public Avion(String informacion, String color, int turbinas, int pasajetos, String tipo) {
        super(informacion, color);
        this.turbinas = turbinas;
        this.pasajetos = pasajetos;
        Tipo = tipo;
    }

    public int getTurbinas() {
        return turbinas;
    }

    public void setTurbinas(int turbinas) {
        this.turbinas = turbinas;
    }

    public int getPasajetos() {
        return pasajetos;
    }

    public void setPasajetos(int pasajetos) {
        this.pasajetos = pasajetos;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }
}
