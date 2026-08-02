public class TarifaMoto implements Tarifa{

    @Override
    public Double calcular(int horas){
        return horas  * 1.0;
    }
}
