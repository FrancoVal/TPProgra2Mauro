public class Paquete {
    private Integer idPaquete;
    private Double volumen;
    private Float  precio;
    private String direccion;
    private Float costoDeEnvio;

    public Paquete(Integer idPaquete, Double volumen, Float precio, String direccion) {
        this.idPaquete = idPaquete;
        this.volumen = volumen;
        this.precio = precio;
        this.costoDeEnvio = calcularCostoDeEnvio();
    }

    //NO SE SI ESTA BIEN, FALTA HACER
    private double calcularCostoDeEnvio() {
        Float costo = 0.0F;

        if ("Normal".equals(tipoPaquete)) {
            costo = (float) (volumen * 0.1);
        } else if ("Fragil".equals(tipoPaquete)) {
            costo = (float) (volumen * 0.2);
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
