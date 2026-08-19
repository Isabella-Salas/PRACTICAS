import java.util.List;

public class EmpresaMensajeria {

    public void registrarPaquete(Paquete paquete) throws Exception {
        if (paquete.save()) {
            System.out.println("Paquete guardado en BD : " + paquete.getId());
        } else {
            System.out.println("No se pudo guardar el paquete.");
        }
    }

    public void generarReporte() throws Exception {
        List<Paquete> paquetes = Paquete.getAll();
        double totalRecaudado = 0;

        System.out.println("Reporte de envios");
        for (Paquete p : paquetes) {
            double costo = p.calcularCosto();
            totalRecaudado += costo;
            System.out.println(p.getId() + " | " + p.getNombreDestinatario() + " | " + p.getPesoKg() + " | " + p.getTipoEnvio() + " | " + costo);
        }
        System.out.println("Total recaudado" + totalRecaudado);
    }
}
