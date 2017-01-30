/**
 * Created by di.ruizdechavez on 13/01/2017.
 */
public class Envarcacion extends Vehiculo {
    int tamanio;
    String nombre;
    boolean anfivio;

    public Envarcacion(String informacion, String color, int tamanio, String nombre, boolean anfivio) {
        super(informacion, color);
        this.tamanio = tamanio;
        this.nombre = nombre;
        this.anfivio = anfivio;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAnfivio() {
        return anfivio;
    }

    public void setAnfivio(boolean anfivio) {
        this.anfivio = anfivio;
    }
}
