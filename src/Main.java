import modelos.Alumno;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

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
                        System.out.println("Ingrese los datos del alumno");
                        System.out.println("Matricula");
                        String matricula = sc.next();
                        System.out.println("Nombre");
                        String nombre = sc.next();
                        System.out.println("Edad");
                        int edad = sc.nextInt();
                        System.out.println("Sexo");
                        String sexo = sc.next();
                        System.out.println("Correo");
                        String correo = sc.next();
                        Alumno alumno = new Alumno(matricula,nombre,edad,sexo,correo);
                        alumno.save();
                    break;
                case 2:
                    System.out.println("Alumnos registrados");
                    for (Alumno a : Alumno.getAll()) {
                        System.out.println(a.getMatricula() + " " + a.getNombre() + " " + a.getEdad() + " " + a.getSexo() + " " + a.getCorreo());
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el ID del alumno que desea modificar");
                    int idModificar = sc.nextInt();
                    Alumno alumnonuevo = Alumno.findbyid(idModificar);

                    if (alumnonuevo == null) {
                        System.out.println("No existe un alumno con ese id.");
                        break;
                    }
                    System.out.println("Alumno encontrado: " + alumnonuevo.getNombre());
                    System.out.println("Nuevo nombre " + alumnonuevo.getNombre());
                    String nuevoNombre = sc.nextLine();
                    if (nuevoNombre.isEmpty()) {
                        alumnonuevo.setNombre(nuevoNombre);
                    }
                    break;
                case 4:
                    System.out.println("Ingrese la matricula del alumno que desea eliminar");
                    String matriculaEliminar = sc.next();
                    Alumno.deletebyMatricula(matriculaEliminar);
                    break;
                case 5:
                    System.out.println("Ingrese el sexo que desea consultar");
                    String sexoConsultar = sc.next();
                    List<Alumno> alumnos = Alumno.getAll();
                    int total = 0;
                    for (Alumno a : alumnos) {
                        if (a.getSexo().equals(sexoConsultar)) {
                            total++;
                        }
                        System.out.println("El sexo " + sexoConsultar + " tiene " + total + " alumnos");
                    }
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