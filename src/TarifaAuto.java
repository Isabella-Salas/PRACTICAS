public class TarifaAuto implements Tarifa{

    @Override
    public Double calcular(int horas) {
        return (double) horas * 2;
    }
}
