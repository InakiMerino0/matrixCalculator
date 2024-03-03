import java.util.InputMismatchException;
import java.util.Scanner;

class CalcMain {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Selector
        int exe = 0;

        //Exe: (selector general: calculo matricial o reduccion)
        System.out.println("Ingrese 1 si desea resolver un sistema de ecuaciones");
        System.out.println("Ingrese 2 si desea realizar operaciones con matrices.");

        boolean firstIteration = true;
        try {
            do {
                exe = s.nextInt();
                if (!firstIteration) {
                    System.out.println("Error: ingrese uno o dos");
                }
                firstIteration = false;
            } while (exe != 1 || exe != 2) ;
        } catch (InputMismatchException e) {
            System.err.println("Error: debe ingresar un tipo de dato valido");
            main(args);
            System.exit(0);
        }

        if (exe == 1) {
            EquationSystem.main(new String[0]);
        } else {
            MatrixFunctions.main(new String[0]);
        }
    }
}
