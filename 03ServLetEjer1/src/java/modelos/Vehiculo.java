package modelos;

/**
 *
 * @author di.ruizdechavez
 */
public abstract class Vehiculo {

    private int id;
    private String color;
    private int ancho;
    private int alto;
    private int largo;
    public boolean encendido;

    public Vehiculo(int id, String color, int ancho, int alto, int largo) {
        this.id = id;
        this.color = color;
        this.ancho = ancho;
        this.alto = alto;
        this.largo = largo;
    }

    public Vehiculo(String completo) {
        String[] nC = completo.split("|");
        this.id = Integer.parseInt(nC[0]);
        this.color = nC[1];
        this.ancho = Integer.parseInt(nC[2]);
        this.alto = Integer.parseInt(nC[3]);
        this.largo = Integer.parseInt(nC[4]);
    }

    public void arrancar(){
        this.encendido = true;
    }
    
    public void acelerar(){}
    
    public void frenar(){}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }
}
