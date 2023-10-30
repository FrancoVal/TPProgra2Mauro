public class Paquete {
    private int id;
    private double volumen;
    private double precio;
    private String tipoPaquete;
    private Cliente cliente;
    private double costoDeEnvio;

    public Paquete(int id, double volumen, double precio, String tipoPaquete, Cliente cliente) {
        this.id = id;
        this.volumen = volumen;
        this.precio = precio;
        this.tipoPaquete = tipoPaquete;
        this.cliente = cliente;

        this.costoDeEnvio = calcularCostoDeEnvio();
    }

    //NO SE SI ESTA BIEN, FALTA HACER
    private double calcularCostoDeEnvio() {
        double costo = 0.0;

        if ("Normal".equals(tipoPaquete)) {
            costo = volumen * 0.1;
        } else if ("Fragil".equals(tipoPaquete)) {
            costo = volumen * 0.2;
        }

        return costo;
    }

    //CREA PAQUETE
    public static Paquete crearPaquete(int id, double volumen, double precio, String tipoPaquete, Cliente cliente) {
        if (id < 0) {
            throw new IllegalArgumentException("El ID del paquete no puede ser negativo.");
        }

        if (volumen <= 0) {
            throw new IllegalArgumentException("El volumen del paquete debe ser mayor que cero.");
        }

        if (precio <= 0) {
            throw new IllegalArgumentException("El precio del paquete debe ser mayor que cero.");
        }

        if (tipoPaquete == null || tipoPaquete.isEmpty()) {
            throw new IllegalArgumentException("El tipo de paquete no puede ser nulo o vacío.");
        }

        if (cliente == null) {
            throw new IllegalArgumentException("El cliente del paquete no puede ser nulo.");
        }

        return new Paquete(id, volumen, precio, tipoPaquete, cliente);
    }



}
