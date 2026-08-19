public class EnvioEstandar implements EstrategiaEnvio {
    @Override
    public double calcularCosto(double pesoKg) {
        return pesoKg * 2.00;
    }
    @Override
    public String getTipo() { return "ESTANDAR"; }

}
