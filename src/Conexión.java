public class Conexión {

    static String server = "localhost";
    static int port = 1433;
    static String database = "Practica_Alumno";
    static String user = "sa";
    static String password = "isa2006";

    public static String getCadenaConexion(){
        return String.format(
                "jdbc:sqlserver://%s:%s;" +
                        "databaseName=%s;" +
                        "user=%s;" +
                        "password=%s;" +
                        "encrypt=true;" +
                        "trustServerCertificate=true;",
                server, port, database, user, password
        );
    }

}
