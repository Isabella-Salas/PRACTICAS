public class TarifaCamion implements Tarifa {

    @Override
    public Double calcular(int horas){
        return (horas * 4.0) + 5.00;
    }

}
