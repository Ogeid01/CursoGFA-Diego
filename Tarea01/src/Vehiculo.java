/**
 * Created by di.ruizdechavez on 13/01/2017.
 */
public abstract class Vehiculo {
    String informacion;
    String color;

    public Vehiculo(String informacion, String color) {
        this.informacion = informacion;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
}

