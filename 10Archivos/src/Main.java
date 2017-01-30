import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);

        System.out.println("ingresa el codigo de error");
        int codigoError = s.nextInt();
        System.out.println("ingresa la descripcion del error");
        String desc = s.nextLine();

        Error e1 = new Error(codigoError,desc);
        e1.escribir("D:\\TEMP\\E1.txt");
    }
}
