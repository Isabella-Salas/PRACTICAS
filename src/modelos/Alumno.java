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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
