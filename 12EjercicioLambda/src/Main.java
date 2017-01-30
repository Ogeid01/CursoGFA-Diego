import java.util.ArrayList;

/**
 * Created by di.ruizdechavez on 14/01/2017.
 */
public class Main {
    public static void main(String[] args) {
        IArreglos pares = (ArrayList<Integer> a) -> {
            ArrayList<Integer> b = new ArrayList<Integer>();
            for(int i=0;i<a.length;i++)
            {
                if (a[i]%2==0) b.add(a[i]);
            }
            return b;
        };
        IArreglos nones = (ArrayList<Integer> a) -> {
            ArrayList<Integer> b = new ArrayList<Integer>();
            for(int i=0;i<a.length;i++)
            {
                if (a[i]%2!=0) b.add(a[i]);
            }
            return b;
        };

        IArreglos imprime = (ArrayList<Integer> a) -> {
            String b = "";
            for(int i=0;i<a.length;i++)
            {
                b = b + (i==0 ? "" : ", ") + a;
            }
            System.out.println(b);
            return null;
        };

        ArrayList<Integer> arreglo = new

        imprime.operacion(arreglo);
    }
}
