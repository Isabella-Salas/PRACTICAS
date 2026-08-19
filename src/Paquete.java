import modelos.Conexión;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Random;

public class Paquete {

    private int id;
    private String nombreDestinatario;
    private double pesoKg;
    private EstrategiaEnvio estrategia;

    private Paquete(int id, String nombreDestinatario, double pesoKg, EstrategiaEnvio estrategia) throws Exception{
        this.id = id;
        this.nombreDestinatario = nombreDestinatario;
        this.pesoKg = pesoKg;
        this.estrategia = estrategia;
    }
    public Paquete(String nombreDestinatario, double pesoKg, EstrategiaEnvio estrategia) throws Exception{
        this.nombreDestinatario = nombreDestinatario;
        this.pesoKg = pesoKg;
        this.estrategia = estrategia;
    }
    public void save()throws Exception {
        try(
                Connection conn = Conexión.getConexion();
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO Paquetes(nombreDestinatario,pesoKg,tipoEnvio) values (?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS)
                )
        {
            stmt.setString(1, this.nombreDestinatario);
            stmt.setDouble(2, this.pesoKg);
            stmt.setString(3, this.estrategia.getTipo());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                this.id = rs.getInt(1);
            }
        }
    }





    public double calcularCosto(){
        return this.estrategia.calcularCosto(this.pesoKg);
    }
    public String getTipoEnvio(){
        return this.estrategia.getTipo();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombreDestinatario() {
        return nombreDestinatario;
    }
    public void setNombreDestinatario(String nombreDestinatario) {
        this.nombreDestinatario = nombreDestinatario;
    }
    public double getPesoKg() {
        return pesoKg;
    }
    public void setPesoKg(double pesoKg) {}
}
