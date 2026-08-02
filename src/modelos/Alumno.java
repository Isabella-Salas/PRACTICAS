package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    //metodos
    public void save()throws Exception {
        try (Connection connection = Conexión.getConexion();
             PreparedStatement stmt = connection.prepareStatement(("INSERT INTO Alumnos(nombre) values (?)  "), java.sql.Statement.RETURN_GENERATED_KEYS);
             // el java sql es para que regresa la llave que se genero
        ) {
            stmt.setString(1, this.nombre); // this. nombre se saca del atributo del objeto alumno
            stmt.executeUpdate(); //avisa que traiga las fk
            ResultSet rs = stmt.getGeneratedKeys(); //dame las llaves foraneas que trajiste y genera el result set
            {
                if (rs.next()) {
                    this.id = rs.getInt(1);
                }
            }
        }
    }
    public static List<Alumno> getAll() throws Exception {
        try(
                Connection connection = Conexión.getConexion();
                PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Alumnos");
        )
        {
            ResultSet rs = stmt.executeQuery();
            List<Alumno> alumnos = new ArrayList<>();
            while (rs.next()) {
                Alumno a = new Alumno(rs.getInt("id"),(rs.getString("matricula")),
                        (rs.getString("nombre")),(rs.getInt("edad")),
                        (rs.getString("sexo")),(rs.getString("correo")));
                alumnos.add(a);
            }
            return alumnos;
        }
    }

    //getters y setters
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
