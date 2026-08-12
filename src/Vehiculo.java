public abstract class Vehiculo {

    private String placa;
    private int horas_Estacionamiento;
    private Tarifa tarifa;

    public Vehiculo(String placa, int horas_Estacionamiento, Tarifa tarifa) {
        this.placa = placa;
        this.horas_Estacionamiento = horas_Estacionamiento;
        this.tarifa = tarifa;
    }



}
