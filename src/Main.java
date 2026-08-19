import modelos.Alumno;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        EmpresaMensajeria empresa = new EmpresaMensajeria();

        int op;
        do {
            System.out.println("1. registrar un paquete ");
            System.out.println("2. imprimir todos los paquetes registrados");
            System.out.println("3. eliminar un paquete");
            System.out.println("4. Mostar reporte");
            System.out.println("5. Salir");
            int opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Ingrese el nombre del destinatario");
                    String nombreDestinatario = sc.next();
                    System.out.println("Ingrese el peso del paquete en kg");
                    double pesoKg = sc.nextDouble();
                    System.out.println("Ingrese el tipo de envio");
                    System.out.println("1. Estandar");
                    System.out.println("2. Express");
                    System.out.println("3. Internacional");
                    int tipoEnvio = sc.nextInt();
                    EstrategiaEnvio estrategia;
                    switch (tipoEnvio) {
                        case 1:
                            estrategia = new EnvioEstandar();
                            break;
                            case 2:
                            estrategia = new EnvioExpress();
                            break;
                            case 3:
                            estrategia = new EnvioInternacional();
                            break;
                            default:
                            estrategia = new EnvioEstandar();
                    }
                    Paquete paquete = new Paquete(nombreDestinatario, pesoKg, estrategia);
                    paquete.save();
                    break;
                case 2:
                    List<Paquete> paquetes = Paquete.getAll();
                    for (Paquete p : paquetes) {
                        System.out.println(p.getId() + " | " + p.getNombreDestinatario() + " | " + p.getPesoKg() + " | " + p.getTipoEnvio() + " | " + p.calcularCosto());
                    }

                    break;
                case 3:
                    System.out.println("Ingrese el nombre del destinatario del paquete que desea eliminar");
                    String nombre = sc.next();
                    Paquete.delete(nombre);
                    break;
                case 4:
                    empresa.generarReporte();
                    System.out.println("Reporte generado");

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