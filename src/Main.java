import modelos.Alumno;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Falta por investigar como hare el main con lo de bd, pero mientras dejare el menu

        Scanner sc = new Scanner(System.in);

        int op;
        do {
            System.out.println("1. registrar un alumno ");
            System.out.println("2. imprimir todos los alumnos registrados");
            System.out.println("3. modificar a un alumno por matricula");
            System.out.println("4. eliminar un alumno por matricula");
            System.out.println("5. Mostar cantidad de alumnos por sexo");
            System.out.println("6. Salir");
            int opcion = sc.nextInt();
            switch (opcion){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
            }
            System.out.println("¿Desea continuar?");
            System.out.println("1. Si");
            System.out.println("2. No");
            op = sc.nextInt();
        }while (op == 1);

    }
}