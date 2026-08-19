public class EnvioInternacional implements EstrategiaEnvio{
    @Override
    public double calcularCosto(double pesoKg) {
        return (pesoKg * 6.00) + 10.00;
    }
    @Override
    public String getTipo() { return "INTERNACIONAL"; }
}
