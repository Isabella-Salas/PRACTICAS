public class EnvioExpress implements EstrategiaEnvio{
    @Override
    public double calcularCosto(double pesoKg) {
        return (pesoKg * 4.50) + 3.00;
    }
    @Override
    public String getTipo() { return "EXPRESS"; }
}
