import java.util.InputMismatchException;
import java.util.Scanner;

public class FunctionsSelector {
    public static void main(String[] args) {
        //Variables generales
        Scanner scanner = new Scanner(System.in);
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
                Square(rows, cols);
            }
            else if (rows != cols) {
                System.out.println("La matriz ingresada no es cuadrada, se restringen las operaciones.");
                nonSquare(rows, cols);
            }
        }
    }


    public static void Square(int rows, int cols) {
        Scanner scanner = new Scanner(System.in);
        //Selector general
        int oper = 0;

        System.out.println("Seleccione la operacion que desea realizar:");
        System.out.println("1: Multiplicacion por escalar");
        System.out.println("2: Producto entre matrices");
        System.out.println("3: Suma");
        System.out.println("4: Resta");
        System.out.println("5: Inversa");
        try {
            oper = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Error: ingrese un tipo valido");
        }

        switch (oper) {
            case 1:
                MatrixFunctions.scalarTimes(rows, cols);
                break;
            case 2:
                MatrixFunctions.matrixTimes(rows, cols);
                break;
            case 3:
                MatrixFunctions.add(rows, cols);
                break;
            case 4:
                MatrixFunctions.subtract(rows, cols);
                break;
            case 5:
                if (rows == 3) {
                    MatrixFunctions.reverse3x3();
                }
                else {
                    MatrixFunctions.reverse2x2();
                }
                break;
            default:
                System.out.println("No se ha ingresado una opcion valida.");
        }

    }

    public static void nonSquare(int rows, int cols) {
        Scanner scanner = new Scanner(System.in);
        int oper = 0;
        System.out.println("Seleccione la operacion que desea realizar:");
        System.out.println("1: Multiplicacion por escalar");
        System.out.println("2: Producto entre matrices");
        System.out.println("3: Suma");
        System.out.println("4: Resta");

        oper = scanner.nextInt();

        switch (oper) {
            case 1:
                MatrixFunctions.scalarTimes(rows, cols);
                break;
            case 2:
                MatrixFunctions.matrixTimes(rows, cols);
                break;
            case 3:
                MatrixFunctions.add(rows, cols);
                break;
            case 4:
                MatrixFunctions.subtract(rows, cols);
                break;
            default:
                System.out.println("No se ha ingresado una opcion valida");
        }
    }
}
