public class Cliente {
    private Double DNI;
    private String nombre;
    private String direccion;

    public Cliente(Double DNI, String nombre, String direccion) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
    }


    //CREA CLIENTE
    public Cliente crearCliente(Double DNI, String nombre, String direccion) {
        if (DNI == null || DNI.isEmpty() || nombre == null || nombre.isEmpty() || direccion == null || direccion.isEmpty()) {
            throw new IllegalArgumentException("Los datos del cliente no pueden ser nulos o vacíos.");
        }

        return new Cliente(DNI, nombre, direccion);
    }

    public D obtenerDni() {
        return disponible;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "DNI='" + DNI + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
