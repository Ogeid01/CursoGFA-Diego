/**
 * Created by di.ruizdechavez on 13/01/2017.
 */
public class Motocicleta extends Vehiculo {
    String tipo;
    int cilindrada;
    String tipoCombustible;

    public Motocicleta(String informacion, String color, String tipo, int cilindrada, String tipoCombustible) {
        super(informacion, color);
        this.tipo = tipo;
        this.cilindrada = cilindrada;
        this.tipoCombustible = tipoCombustible;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }
}
