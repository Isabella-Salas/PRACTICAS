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
            System.out.println("id: " + v.getId() + " - placa: " + v.getPlaca() + " - costo: " + costo + "");
        }
        System.out.println("Total :" + totalRecaudado);
    }
}

