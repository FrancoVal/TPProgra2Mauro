import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int DNI;
    private String numeroPedido;
    private String nombreCliente;
    private String direccionEntrega;
    private List<Paquete> carritoDePaquetes;
    private boolean pedidoCerrado;
    private double precioDePedido;

    public Pedido(String numeroPedido, String nombreCliente, String direccionEntrega) {
        this.numeroPedido = numeroPedido;
        this.nombreCliente = nombreCliente;
        this.direccionEntrega = direccionEntrega;
        this.carritoDePaquetes = new ArrayList<>();
        this.pedidoCerrado = false;
        this.precioDePedido = 0.0;
    }

    // AGREGA PAQUETE A PEDIO
    public void agregarPaquete(String numeroPedido, Paquete paquete) {
        if (pedidoCerrado) {
            throw new IllegalArgumentException("El pedido está cerrado, no se pueden agregar paquetes.");
        }

        carritoDePaquetes.add(paquete);
        precioDePedido += paquete.getCostoDeEnvio();
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
