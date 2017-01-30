/**
 * Created by di.ruizdechavez on 10/01/2017.
 */
import matematicas.Matematicas;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        //Matematicas mat = new Matematicas();
        Scanner lector = new Scanner(System.in);

        float a,b;

        System.out.println("Iralo, amos a jugar con dos números \nIntroduce el primer número: ");
        a = lector.nextFloat();
        System.out.println("Introduce el segundo número:");
        b = lector.nextFloat();
        System.out.println("La suma es: " + Matematicas.suma(a,b));
        System.out.println("La resta es: " + Matematicas.resta(a,b));
        System.out.println("La multiplicación es: " + Matematicas.multiplicacion(a,b));
        System.out.println("La división es: " + Matematicas.division(a,b));
    }
}
