import java.util.InputMismatchException;
import java.util.Scanner;

public class GaussJordan {
    public static void gaussJordan2x3() {
        Scanner scanner = new Scanner(System.in);

        float[][] matrix = new float[2][3];
        float aux = 0;
        //Variables del sistema de ecuaciones
        float x1 = 0, x2 = 0, x3 = 0;

        System.out.println("Ingrese los datos de la matriz 2x3 por fila: ");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                try {
                    matrix[i][j] = scanner.nextFloat();
                } catch (InputMismatchException e) {
                    System.err.println("Error: ingrese un tipo valido para float");
                }
            }
        }

        //Primer pivote
        if (matrix[0][0] != 1) {
            aux = 1 / matrix[0][0];
            for (int i = 0; i < 3; i++) {
                matrix[0][i] = matrix[0][i] * aux;
            }
        }

        //Col 1 0
        if (matrix[1][0] != 0) {
            aux = -(matrix[1][0]);
            for (int i = 0; i <= 2; i++) {
                matrix[1][i] = matrix[1][i] + matrix[0][i] * aux;
            }
        }

        //segundo pivote
        if (matrix[1][1] != 1) {
            aux = 1 / matrix[1][1];
            for (int i = 0; i <= 2; i++) {
                matrix[1][i] = matrix[1][i] * aux;
            }
        }
        //columna 2  0
        if (matrix[0][1] != 0) {
            aux = -(matrix[0][1]);
            for (int i = 0; i <= 2; i++) {
                matrix[0][i] = matrix[0][i] + matrix[1][i] * aux;
            }
        }

        //solucion
        x2 = matrix[1][2];
        x1 = matrix[0][2];

        System.out.println("La matriz reducida a Gauss es: ");
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 2; j++) {
                System.out.println(matrix[i][j] + "  ");;
            }
        }
        System.out.println("La solucion es: x1 = " +  x1 + ", x2 = " + x2);
    }

    public static void gaussJordan3x4() {
        Scanner scanner = new Scanner(System.in);
        float[][] matrix = new float[3][4];
        float aux = 0;
        float x1 = 0, x2 = 0, x3 = 0;

        System.out.println("Ingrese la matriz 3x4 fila por fila");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    matrix[i][j] = scanner.nextFloat();
                } catch(InputMismatchException e) {
                    System.err.println("Error: ingrese un tipo valido para float");
                }
            }
        }

        //primer pivote
        if (matrix[0][0] != 1) {
            aux = 1 / matrix[0][0];
            for (int i = 0; i < 4; i++) {
                matrix[0][i] = matrix[0][i] * aux;
            }
        }
        //columna 1 primer 0
        if (matrix[1][0] != 0) {
            aux = -(matrix[1][0]);
            for (int i = 0; i < 4; i++) {
                matrix[1][i] = matrix[1][i] + matrix[0][i] * aux;
            }
        }
        //columna 1 segundo 0
        if (matrix[2][0] != 0) {
            aux = -(matrix[2][0]);
            for (int i = 0; i < 4; i++) {
                matrix[2][i] = matrix[2][i] + matrix[0][i] * aux;
            }
        }
        //segundo pivote
        if (matrix[1][1] != 1) {
            aux = 1 / matrix[1][1];
            for (int i = 0; i < 4; i++) {
                matrix[1][i] = matrix[1][i] * aux;
            }
        }
        //columna 2 primer cero
        if (matrix[0][1] != 0) {
            aux = -(matrix[0][1]);
            for (int i = 0; i < 4; i++) {
                matrix[0][i] = matrix[0][i] + matrix[1][i] * aux;
            }
        }
        //columna 2 segundo 0
        if (matrix[2][1] != 0) {
            aux = -(matrix[2][1]);
            for (int i = 0; i < 4; i++) {
                matrix[2][i] = matrix[2][i] + matrix[1][i] * aux;
            }
        }

        //tercer pivote
        if (matrix[2][2] != 1) {
            aux = 1 / matrix[2][2];
            for (int i = 0; i < 4; i++) {
                matrix[2][i] = matrix[2][i] * aux;
            }
        }
        //columna 3 primer 0
        if (matrix[0][2] != 0) {
            aux = -(matrix[0][2]);
            for (int i = 0; i < 4; i++) {
                matrix[0][i] = matrix[0][i] + matrix[2][i] * aux;
            }
        }
        //columna 3 segundo 0
        if (matrix[1][2] != 0) {
            aux = -(matrix[1][2]);
            for (int i = 0; i < 4; i++) {
                matrix[1][i] = matrix[1][i] + matrix[2][i] * aux;
            }
        }
        //solucion
        x3 = matrix[2][3];
        x2 = matrix[1][3];
        x1 = matrix[0][3];


        //Printeo resultados
        System.out.println("La matriz reducida es: ");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(matrix[i][j] + " ");;
            }
        }

        System.out.println("La solucion es: " + " x1 = " + x1 + ", x2 = " + x2 + ", x3 = " + x3);
    }
}
