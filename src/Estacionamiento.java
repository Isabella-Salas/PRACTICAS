import java.util.List;

public class Estacionamiento {

    public void registrarVehiculo(Vehiculo vehiculo) throws Exception {
        if (vehiculo.save()) {
            System.out.println("Vehículo registrado en BD con ID: " + vehiculo.getId());
        } else {
            System.out.println("No se pudo registrar el vehículo.");
        }
    }

    public void imprimirReporte() throws Exception {
        List<Vehiculo> vehiculos = Vehiculo.getAll();
        double totalRecaudado = 0;

        System.out.println("\n========== REPORTE DE ESTACIONAMIENTO ==========");
        for (Vehiculo v : vehiculos) {
            double costo = v.calcularCostoEstacionamiento();
            totalRecaudado += costo;
            System.out.printf("ID: %d | Placa: %s | Horas: %d | Tipo: %s | Total: $%.2f USD%n",
                    v.getId(), v.getPlaca(), v.getHoras_Estacionamiento(),
                    v.getTarifa().getTipo(), costo);
        }
        System.out.printf("Reporte total: ", totalRecaudado);
    }
}

