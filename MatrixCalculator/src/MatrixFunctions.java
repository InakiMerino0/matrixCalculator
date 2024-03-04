import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrixFunctions {
    public static void add(int rows, int cols) {
        float[][] result = new float[rows][cols];
        float[][] matrix1 = new float[rows][cols];
        float[][] matrix2 = new float[rows][cols];

        System.out.println("Ingrese la matriz 1");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println("Ingrese el numero con los subindices: " + (i + 1) + " " + (j + 1));
                matrix1[i][j] = tryCatch(i,j);
            }
        }

        System.out.println("Ingrese la matriz 2");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix2[i][j] = tryCatch(i,j);
            }
        }

        System.out.println("El resultado de la operacion es:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
                System.out.print(result[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void subtract(int rows, int cols) {
        float[][] result = new float[rows][cols];
        float[][] matrix1 = new float[rows][cols];
        float[][] matrix2 = new float[rows][cols];

        System.out.println("Ingrese la matriz 1");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println("Ingrese el numero con los subindices: " + (i + 1) + " " + (j + 1));
                matrix1[i][j] = tryCatch(i,j);
            }
        }

        System.out.println("Ingrese la matriz 2");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix2[i][j] = tryCatch(i,j);
            }
        }

        System.out.println("El resultado de la operacion es:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
                System.out.print(result[i][j] + " ");
            }
            System.out.print(" ");
        }
    }

    public static void scalarTimes(int rows, int cols){
        Scanner scanner = new Scanner(System.in);

        float[][] matrix = new float[rows][cols];
        float[][] result = new float[rows][cols];
        float k = 0;

        System.out.println("Ingrese la matriz " + rows + "x" + cols + " a multiplicar por escalar");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println("Ingrese el numero con los subindices: " + (i + 1) + " " + (j + 1));
                matrix[i][j] = tryCatch(i,j);
            }
        }

        System.out.println("Ingrese el escalar por el que desea multiplicar la matriz.");
        try {
            k = scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.err.println("Ingrese un tipo valido");
            System.exit(1);
        }

        //operacion y printeo
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] * k;
                System.out.print(result[i][j] + " ");
            }
            System.out.println(" ");
        }
    }


    public static void matrixTimes(int rows, int cols) {
        Scanner scanner = new Scanner(System.in);

        //Variables generales
        float[][] matrix1 = new float[rows][cols];
        int cols2 = 0;

        System.out.println("Ingrese la matriz 1, del orden dado");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println("Ingrese el numero con los subindices: " + (i + 1) + " " + (j + 1));
                matrix1[i][j] = tryCatch(i,j);
            }
        }

        System.out.println("Ingrese la cantidad de columnas de la segunda matriz, la cantidad de filas se dispone igual a la cantidad de columnas de la matriz 1, ya que de lo contrario la operacion no podria realizarse.");

        try {
            cols2 = scanner.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("Error: Ingrese un tipo valido");
        }

        //Definimos el resto de variables, una vez ingresado el dato de columnas
        float[][] matrix2 = new float[cols][cols2];
        float[][] result = new float[rows][cols2];

        System.out.println("Ingrese la matriz 2");
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < cols2; j++) {
                System.out.println("Ingrese el numero con los subindices: " + (i + 1) + " " + (j + 1));
                matrix2[i][j] = tryCatch(i,j);
            }
        }


        //Operacion
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < cols; k++) {
                    result[i][j] = result[i][j] + (matrix1[i][k] * matrix2[k][j]);
                }
            }
        }


        //Mostrar el resultado del producto
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println(" ");
        }
    }


    public static float adjunto(float n2, float n3, float n4, float n5) {
        float result = (n2 * n3) - (n4 * n5);
        return result;
    }

    public static void reverse3x3 () {
        float[][] matrix = new float[3][3];
        float[][] tras = new float[3][3];
        float[][] adj = new float[3][3];
        float aux = 0;
        float determinante = 0;

        System.out.println("Ingrese la matriz 3x3 de la cual quiere conocer su inversa.");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Ingrese el numero con los subindices: " + (i + 1) + " " + (j + 1));
                matrix[i][j] = tryCatch(i,j);
            }
        }

        //determinante
        determinante = ((matrix[0][0] * matrix[1][1] * matrix[2][2]) + (matrix[1][0] * matrix[2][1] * matrix[0][2]) + (matrix[2][0] * matrix[0][1] * matrix[1][2])) - ((matrix[0][2] * matrix[1][1] * matrix[2][0]) + (matrix[1][2] * matrix[2][1] * matrix[0][0]) + (matrix[2][2] * matrix[0][1] * matrix[1][0]));

        //traspuesta
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tras[j][i] = matrix[i][j];
            }
        }

        //adjunta de la trasp�esta

        adj[0][0] = adjunto(tras[1][1], tras[2][2], tras[1][2], tras[2][1]);
        adj[0][1] = -1 * (adjunto(tras[1][0], tras[2][2], tras[2][0], tras[1][2]));
        adj[0][2] = adjunto(tras[1][0], tras[2][1], tras[2][0], tras[1][1]);

        adj[1][0] = -1 * (adjunto(tras[0][1], tras[2][2], tras[2][1], tras[0][2]));
        adj[1][1] = adjunto(tras[0][0], tras[2][2], tras[2][0], tras[0][2]);
        adj[1][2] = -1 * (adjunto(tras[0][0], tras[2][1], tras[2][0], tras[0][1]));

        adj[2][0] = adjunto(tras[0][1], tras[1][2], tras[1][1], tras[0][2]);
        adj[2][1] = -1 * (adjunto(tras[0][0], tras[1][2], tras[1][0], tras[0][2]));
        adj[2][2] = adjunto(tras[0][0], tras[1][1], tras[1][0], tras[0][1]);

        //muestra inversa
        System.out.println("la inversa es:");
        if (determinante != 0) {
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    System.out.print(adj[i][j] + "/" + determinante + " ");
                }
                System.out.println(" ");
            }
        }
        else
        {
            System.out.println("la matriz no tiene inversa");
        }
    }


    public static void reverse2x2() {
        float[][] matrix = new float[2][2];
        float[][] tras = new float[2][2];
        float[][] adj = new float[2][2];
        float aux = 0;
        float determinante = 0;

        System.out.println("Ingrese la matriz 2x2 de la cual quiere conocer su inversa:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println("Ingrese el numero con los subindices: " + (i + 1) + " " + (j + 1));
                matrix[i][j] = tryCatch(i,j);
            }
        }

        //determinante
        determinante = matrix[0][0] * matrix[1][1] - (matrix[0][1] * matrix[1][1] * matrix[1][0]);


        //muestra inversa

        System.out.println("la inversa es:");
        if (determinante != 0) {
            //traspuesta
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    tras[j][i] = matrix[i][j];
                }
            }
            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j <= 1; j++) {
                    System.out.print(tras[i][j] / determinante + " ");
                }
                System.out.println(" ");
            }
        }
        else
        {
            System.out.println("la matriz no tiene inversa");
        }
    }

    //Try catch, aplicando DRY
    public static float tryCatch(int i, int j) {
        Scanner scanner = new Scanner(System.in);

        float[][] matrix = new float[3][3];

        try {
            matrix[i][j] = scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.err.println("Error: ingrese un tipo valido");
            System.exit(1);
        }
        return matrix[i][j];
    }

}
