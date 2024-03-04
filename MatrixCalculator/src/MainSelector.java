import java.util.InputMismatchException;
import java.util.Scanner;

class MainSelector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Selector
        int exe = 0;

        //Exe: (selector general: calculo matricial o reduccion)
        System.out.println("Ingrese 1 si desea resolver un sistema de ecuaciones");
        System.out.println("Ingrese 2 si desea realizar operaciones con matrices.");


        try {

            cicle:
            while (true) {
                exe = scanner.nextInt();
                if (exe == 1 || exe == 2) {
                    break cicle;
                }
                System.out.println("Opcion no valida: ");
                System.out.println("Ingrese 1 si desea resolver un sistema de ecuaciones");
                System.out.println("Ingrese 2 si desea realizar operaciones con matrices.");
            }

        } catch (InputMismatchException e) {
            System.err.println("Error: debe ingresar un tipo de dato valido");
            main(args);
            System.exit(0);
        }

        if (exe == 1) {
            EquationSystemSelector.main(new String[0]);
        } else {
            FunctionsSelector.main(new String[0]);
        }
    }
}
