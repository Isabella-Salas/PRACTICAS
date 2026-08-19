public abstract class Vehiculo {

    private int id;
    private String placa;
    private int horas_Estacionamiento;
    private Tarifa tarifa;

    public Vehiculo(String placa, int horas_Estacionamiento, Tarifa tarifa) throws Exception {
        this.placa = placa;
        this.horas_Estacionamiento = horas_Estacionamiento;
        this.tarifa = tarifa;
    }
    private Vehiculo(int id, String placa, int horas_Estacionamiento, Tarifa tarifa) throws Exception{
        this.id = id;
        this.placa = placa;
        this.horas_Estacionamiento = horas_Estacionamiento;
        this.tarifa = tarifa;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public int getHoras_Estacionamiento() {
        return horas_Estacionamiento;
    }
    public void setHoras_Estacionamiento(int horas_Estacionamiento) {
        this.horas_Estacionamiento = horas_Estacionamiento;
    }
    public Tarifa getTarifa() {
        return tarifa;
    }



}
