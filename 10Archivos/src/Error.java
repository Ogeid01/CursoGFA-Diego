import java.io.*;
import java.util.Date;

public class Error implements IEscribible {
    private long timeStamp;
    private int codigoError;
    private String descripcion;

    public Error(int codigoError, String descripcion) {
        this.codigoError = codigoError;
        this.descripcion = descripcion;
        this.timeStamp = new Date().getTime();
    }

    @Override
    public void escribir(String url) {
        FileWriter fw;
        String linea = timeStamp + " | " + codigoError + " | " + descripcion + "\n";
        try {
            fw = new FileWriter(url);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void leer(String url) {
        FileReader fr = null;
        try {
            fr = new FileReader(url);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {

            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo");
        } catch (IOException e) {
            System.out.println("Error al recorrer el contenido del archivo");
        }

    }

    @Override
    public void agregar(String url) {

    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(int codigoError) {
        this.codigoError = codigoError;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
