package modelos;

public class Alumno {
    private int id;
    private String matricula;
    private String nombre;
    private int edad;
    private String sexo;
    private String correo;

    public Alumno(int id, String matricula, String nombre, int edad, String sexo, String correo) throws Exception{
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.correo = correo;
    }

}
