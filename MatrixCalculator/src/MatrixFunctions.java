import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrixFunctions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Variables generales
        boolean square = false;
        int rows = 0, cols = 0;

        System.out.println("Ingrese cuantas filas y columnas tendra la matriz con la que desea operar\n, teniendo un limite de orden 3, pueden no ser cuadradas,\n pero las operaciones se restringiran respectivamente.");

        try {
            System.out.println("Ingrese filas");
            rows = scanner.nextInt();

            System.out.println("Ingrese columnas");
            cols = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Error: ingrese un tipo de dato valido");
            main(args);
            System.exit(0);
        }

        //Clasificacion de matriz segun sus subindices
        if ((rows > 0) && (cols > 0) && (rows < 4) && (cols < 4)) {
            if (rows == cols) {
                System.out.println("La matriz ingresada es cuadrada");
                square = true;
            }
            else if (rows != cols) {
                System.out.println("La matriz ingresada no es cuadrada, se restringen las operaciones.");
            }
        }
    }
}
