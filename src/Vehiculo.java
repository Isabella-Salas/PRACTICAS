import modelos.Conexión;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Vehiculo {

    private int id;
    private String placa;
    private int horas_Estacionamiento;
    private Tarifa tarifa;

    public Vehiculo(String placa, int horas_Estacionamiento, Tarifa tarifa) throws Exception {
        this.placa = placa;
        this.horas_Estacionamiento = horas_Estacionamiento;
        this.tarifa = tarifa;
    }
    private Vehiculo(int id, String placa, int horas_Estacionamiento, Tarifa tarifa) throws Exception{
        this.id = id;
        this.placa = placa;
        this.horas_Estacionamiento = horas_Estacionamiento;
        this.tarifa = tarifa;
    }
    public double calcularCostoEstacionamiento() {
        return tarifa.calcular(horas_Estacionamiento);
    }
    public boolean save() throws Exception{
        try(
                Connection connection = Conexión.getConexion();
                PreparedStatement stmt = connection.prepareStatement("INSERT INTO Vehiculos(placa, horas_Estacionamiento, tarifa) values (?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS)
                )
        {
            stmt.setString(1, this.placa);
            stmt.setInt(2, this.horas_Estacionamiento);
            stmt.setString(3, this.tarifa.getTipo());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                this.id = rs.getInt(1);
            }
        }
        return false;
    }
    public static List<Vehiculo> getAll() throws Exception {
        List<Vehiculo> vehiculos = new ArrayList<>();

        try (
                Connection connection = Conexión.getConexion();
                PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Vehiculos");
                ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String placa = rs.getString("placa");
                int horas = rs.getInt("horas_Estacionamiento");
                String tipo = rs.getString("tipo_tarifa");

                Tarifa tarifa;
                switch (tipo) {
                    case "MOTO":
                        tarifa = new TarifaMoto();
                        break;
                    case "CAMION":
                        tarifa = new TarifaCamion();
                        break;
                    default:
                        tarifa = new TarifaAuto();
                        break;
                }

                Vehiculo vehiculo = new Vehiculo(id, placa, horas, tarifa);
                vehiculos.add(vehiculo);
            }
        }

        return vehiculos;
    }
    public static int deletebyPlaca(String placa) throws Exception{ //este borra solo uno
        try(
                Connection connection = Conexión.getConexion();
                PreparedStatement stmt = connection.prepareStatement("DELETE FROM Animal WHERE placa = ?");
        )
        {
            stmt.setString(1, placa);
            return stmt.executeUpdate();
        }

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public int getHoras_Estacionamiento() {
        return horas_Estacionamiento;
    }
    public void setHoras_Estacionamiento(int horas_Estacionamiento) {
        this.horas_Estacionamiento = horas_Estacionamiento;
    }
    public Tarifa getTarifa() {
        return tarifa;
    }



}
