import modelos.Alumno;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Falta por investigar como hare el main con lo de bd, pero mientras dejare el menu

        Scanner sc = new Scanner(System.in);

        int op;
        do {
            System.out.println("1. registrar un carro ");
            System.out.println("2. imprimir todos los carros registrados");
            System.out.println("3. eliminar un carro por placa");
            System.out.println("4. Reporte");
            System.out.println("5. Salir");
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
                    System.out.println("Saliendo del programa");

                    break;
            }
            System.out.println("¿Desea continuar?");
            System.out.println("1. Si");
            System.out.println("2. No");
            op = sc.nextInt();
        }while (op == 1);

    }
}