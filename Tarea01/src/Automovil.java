/**
 * Created by di.ruizdechavez on 13/01/2017.
 */


public class Automovil extends Vehiculo{
    int puertas;
    int cilindros;
    String tipoGasolina;

    public Automovil(String informacion, String color, int puertas, int cilindros, String tipoGasolina) {
        super(informacion, color);
        this.puertas = puertas;
        this.cilindros = cilindros;
        this.tipoGasolina = tipoGasolina;
    }
}
