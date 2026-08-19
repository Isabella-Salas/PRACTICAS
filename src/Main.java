import modelos.Alumno;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Estacionamiento estacionamiento = new Estacionamiento();

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
                    System.out.println("Ingrese la placa del vehiculo: ");
                    String placa1 = sc.next();
                    System.out.println("Ingrese las horas de estacionamiento: ");
                    int horas = sc.nextInt();
                    System.out.println("Ingrese el tipo de vehiculo: ");
                    String tipo = sc.next();
                    Vehiculo v = new Vehiculo(placa1, horas, new TarifaAuto());
                    v.save();

                    break;
                case 2:
                    System.out.println("Lista de vehiculos registrados: ");
                    List<Vehiculo> vehiculos = Vehiculo.getAll();
                    for (Vehiculo ve : vehiculos) {
                        System.out.println(ve);
                    }

                    break;
                case 3:
                    System.out.println("Ingrese la placa del vehiculo que desea eliminar: ");
                    String placa = sc.next();
                    Vehiculo.deletebyPlaca(placa);

                    break;
                case 4:
                    System.out.println("Reporte de vehiculos: ");
                    estacionamiento.imprimirReporte();

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