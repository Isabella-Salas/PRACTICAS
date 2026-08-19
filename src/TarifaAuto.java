public class TarifaAuto implements Tarifa{

    @Override
    public Double calcular(int horas) {
        return (double) horas * 2;
    }
    @Override
    public String getTipo() {
        return "Auto";
    }
}
