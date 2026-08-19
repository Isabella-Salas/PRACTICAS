import modelos.Alumno;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int op;
        do {
            System.out.println("1. registrar un paquete ");
            System.out.println("2. imprimir todos los paquetes registrados");
            System.out.println("3. eliminar un paquete por id");
            System.out.println("4. Mostar reporte");
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
                    System.out.println("Ingrese el id del paquete que desea eliminar");
                    int idEliminar = sc.nextInt();
                    Alumno.deletebyMatricula(matriculaEliminar);
                    break;

                case 6:
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