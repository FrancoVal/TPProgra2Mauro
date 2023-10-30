import java.util.HashMap;

public class EmpresaAmazing {

    public HashMap<Integer, Pedido> listaPedidos;
    public HashMap<String, Transporte> listaTransportes;
    public String cuit;
    public Double facturacion;

    public EmpresaAmazing(String cuit) {
        this.cuit = cuit;
        this.listaPedidos = new HashMap<>();
        this.listaTransportes = new HashMap<>();
    }

//    CREA UNA EMPRESA
    public static EmpresaAmazing crear(String cuit) {
        if (cuit == null || cuit.isEmpty()) {
            throw new IllegalArgumentException("El CUIT no puede ser nulo o vacío.");
        }
        return new EmpresaAmazing(cuit);
    }
// REGSITRA PEDIDO
    public void registrarPedido(String nombreCliente, String direccionAentregar, Integer DNI) {
        listaPedidos.put(DNI, (Pedido.crearPedido(nombreCliente, direccionAentregar, DNI)));
    }
// AGREGA PAQUETE
    public void registrarPedido(String nombreCliente, String direccionAentregar, Integer DNI) {
        listaPedidos.put(DNI, (Pedido.crearPedido(nombreCliente, direccionAentregar, DNI)));
    }
    public int Paquete agregarPaquete(int codPedido, int volumen, int precio, int costoEnvio);
    public  int Paquete agregarPaquete(int codPedido, int volumen, int precio, int porcentaje, int adicional);
    public boolean quitarPaquete(int codPaquete);
    public void registrarAutomovil(String patente, int volMax, int valorViaje, int maxPaq);
    public void registrarUtilitario(String patente, int volMax, int valorViaje, int valorExtra);
    public void registrarCamion(String patente, int volMax, int valorViaje, int adicXPaq);
    public static String cargarTransporte(String patente);
    public double costoEntrega(String patente);
    public double facturacionTotalPedidosCerrados();
    public Map<Integer,String> pedidosNoEntregados();
    public static double cerrarPedido (int codPedido);

    //Aux:

    private static Boolean existePedido(Int idPedido);
    private static Boolean existeCliente(Int idCliente);
    private static Cliente buscarCliente(Int idCliente);
    private static Boolean clienteTienePedidoAbierto(Int idCliente)
    private static Boolean existePaquete(Int idPaquete)
    private static Boolean existeTransporte(String patente)
    private static Transporte buscarTransporte(String patente)


    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}