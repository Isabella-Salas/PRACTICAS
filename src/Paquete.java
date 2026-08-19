import modelos.Conexión;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Paquete {

    private static int id;
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
    public boolean save()throws Exception {
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
        return false;
    }
    public static List<Paquete> getAll() throws Exception {
        List<Paquete> paquetes = new ArrayList<>();

        try (
                Connection connection = Conexión.getConexion();
                PreparedStatement stmt = connection.prepareStatement("SELECT * FROM paquetes");
                ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String destinatario = rs.getString("nombre_destinatario");
                double pesoKg = rs.getDouble("peso_kg");
                String tipo = rs.getString("tipo_envio");

                EstrategiaEnvio estrategiaEnvio;
                switch (tipo) {
                    case "EXPRESS":
                        estrategiaEnvio = new EnvioExpress();
                        break;
                    case "INTERNACIONAL":
                        estrategiaEnvio = new EnvioInternacional();
                        break;
                    default:
                        estrategiaEnvio = new EnvioEstandar();
                        break;
                }

                Paquete paquete = new Paquete(id, destinatario, pesoKg, estrategiaEnvio);
                paquetes.add(paquete);
            }
        }

        return paquetes;
    }
    public static int delete(String nombreDestinatario) throws Exception{ //este borra solo uno
        try(
                Connection connection = Conexión.getConexion();
                PreparedStatement stmt = connection.prepareStatement("DELETE FROM paquetes WHERE nombreDestinatario = ?");
        )
        {
            stmt.setString(1, nombreDestinatario);
            return stmt.executeUpdate();
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
