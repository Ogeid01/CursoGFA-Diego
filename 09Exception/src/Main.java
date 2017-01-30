import java.util.ArrayList;
import java.util.Date;

/**
 * Created by di.ruizdechavez on 13/01/2017.
 */
public class Main {
    public static void main(String[] args) throws FechaInvalidaException {
/*        String nombre = "Diego";
        int valorEntero;
        ArrayList<String> a = null;

        try {
            System.out.println("Dentro del Try");
            //valorEntero = Integer.parseInt(nombre);
            //a.add("agregar primer elemento");
            //a.add("");
            System.out.println(2345/0);

        } catch (ArrayIndexOutOfBoundsException ex) {
            //ex.printStackTrace();
            System.out.println("Error en los argumentos del programa");
        } catch (NumberFormatException ex){
            System.out.println("El valor de la cadena NOMBRE no es entero");
        } catch (NullPointerException ex) {
            System.out.println("La lista no se intanció o es Nula");
        } catch (Exception ex) {
            System.out.println("La cagaste en otra cosa");
        }
        System.out.println("Fin de programa");
        */
        Boleto bol = new Boleto();
        Date fecha = new Date("12/12/2016");
        try {
            bol.setFecha(fecha);
        } catch (FechaInvalidaException ex) {
            //ex.printStackTrace();
            System.out.println("La fecha presentada es invalida");
        }finally {
            System.out.println(bol.getFecha());
            System.out.println("Esto siempre se muestra");
        }
    }
}