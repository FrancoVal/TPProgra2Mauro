import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pedido {
    private Integer DNI;
    private String nombreCliente;
    private String direccionEntrega;
    private HashMap<Integer, Paquete> carritoDePaquetes;
    private Boolean pedidoCerrado;
    private Float precioDePedido;

    public Pedido(String nombreCliente, String direccionEntrega, Integer DNI) {
        this.DNI = DNI;
        this.nombreCliente = nombreCliente;
        this.direccionEntrega = direccionEntrega;
        this.carritoDePaquetes = new HashMap<>();
        this.pedidoCerrado = false;
        this.precioDePedido = 0.0F;
    }
    //CREA PEDIDO
    public static Pedido crearPedido(String nombreCliente, String direccionEntrega, Integer DNI) {

        if (nombreCliente == null || nombreCliente.isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede ser nulo o vacío.");
        }

        if (direccionEntrega == null || direccionEntrega.isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede ser nula o vacía.");
        }

        if (DNI <= 0) {
            throw new IllegalArgumentException("El DNI debe ser un valor positivo.");
        }

        return new Pedido(nombreCliente, direccionEntrega, DNI);
    }

    // AGREGA PAQUETE A PEDIO
    public void agregarPaquete(String numeroPedido, Paquete paquete) {

    }

    // QUITA PAQUETE D PEDIDO
    public void quitarPaquete(int idPaquete) {
        if (pedidoCerrado) {
            throw new IllegalArgumentException("El pedido está cerrado, no se pueden quitar paquetes.");
        }

        Paquete paqueteAQuitar = null;
        for (Paquete paquete : carritoDePaquetes) {
            if (paquete.getId() == idPaquete) {
                paqueteAQuitar = paquete;
                break;
            }
        }

        if (paqueteAQuitar != null) {
            carritoDePaquetes.remove(paqueteAQuitar);
            precioDePedido -= paqueteAQuitar.getCostoDeEnvio();
        } else {
            throw new IllegalArgumentException("El paquete con el ID especificado no se encuentra en el carrito.");
        }
    }

    // CIERRA PEDIDO
    public void cerrarPedido() {
        if (pedidoCerrado) {
            throw new IllegalArgumentException("El pedido ya está cerrado.");
        }

        pedidoCerrado = true;
    }

    // DEVUELVE PRECIO APAGAR DE CLEINTE
    public double precioAPagar() {
        return precioDePedido;
    }

    // DEVUELVE ESTADO DE PDIDO
    public boolean obtenerEstadoDePedido() {
        return pedidoCerrado;
    }

    // DEVUELVE NOMBRE CLEINTE
    public String obtenerCliente() {
        return nombreCliente;
    }

}
