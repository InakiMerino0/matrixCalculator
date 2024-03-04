import java.util.InputMismatchException;
import java.util.Scanner;

public class EquationSystemSelector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Variables generales�
        int exe = 0;

        System.out.println("Ingrese 1 para sistema de 2x3");
        System.out.println("Ingrese 2 para sistema de 3x4");
        System.out.println("Solo pueden ser de 2x3 o 3x4, siendo la ultima columna la que representa la matriz independiente");

        boolean firstIteration = true;
        try {
            cicle:
            while (true) {
                exe = scanner.nextInt();
                if (exe == 1 || exe == 2) {
                    break cicle;
                }
                System.out.println("Ingrese 1 para sistema de 2x3");
                System.out.println("Ingrese 2 para sistema de 3x4");
                System.out.println("Solo pueden ser de 2x3 o 3x4, siendo la ultima columna la que representa la matriz independiente");
            }
        } catch (InputMismatchException e) {
            System.err.println("Error: debe ingresar un tipo de dato valido");
            main(args);
            System.exit(0);
        }

        if (exe == 1) {
            GaussJordan.gaussJordan2x3();
        } else {
            GaussJordan.gaussJordan3x4();
        }
    }
}
