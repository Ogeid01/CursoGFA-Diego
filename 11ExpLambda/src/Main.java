/**
 * Created by di.ruizdechavez on 14/01/2017.
 */
public class Main {
    public static void main(String[] args) {
        IMatematicas suma = (float a, float b) -> a+b;
        IMatematicas resta = (float a, float b) -> a-b;
        IMatematicas multiplicacion = (float a, float b) -> a*b;
        IMatematicas division = (float a, float b) -> a/b;

        float a=20f , b=40f;
        System.out.println(a + " + " + b + " = " + operar(a,b, suma));
        System.out.println(a + " - " + b + " = " + operar(a,b, resta));
        System.out.println(a + " * " + b + " = " + operar(a,b, multiplicacion));
        System.out.println(a + " / " + b + " = " + operar(a,b, division));
    }

    static float operar(float a, float b, IMatematicas operacion)
    {
        return operacion.operacion(a,b);
    }
}
