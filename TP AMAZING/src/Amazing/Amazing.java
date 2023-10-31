package Amazing;
import java.util.HashMap;

public class Amazing {

    public HashMap<Integer, Pedido> listaPedidos;
//    public HashMap<String, Transporte> listaTransportes;
    public String cuit;
    public Double facturacion;

    public Amazing(String cuit) {
        this.cuit = cuit;
        this.listaPedidos = new HashMap<>();
//        this.listaTransportes = new HashMap<>();
    }

    //    CREA UNA EMPRESA
    public Amazing crear(String cuit) {
    	
        if (cuit == null || cuit.isEmpty()) {
        	
            throw new IllegalArgumentException("El CUIT no puede ser nulo o vacío.");
        }
        
        return new Amazing(cuit);
    }

    // REGSITRA PEDIDO
    public Integer registrarPedido(String nombreCliente, String direccionAentregar, Integer DNI) {
    	
        Pedido ped = new Pedido(nombreCliente,  direccionAentregar,  DNI);
        this.listaPedidos.put(idPedido(), ped);
        return idPedido();
        
    }

    // AGREGA PAQUETE ESPECIAL
    public int agregarPaquete(int codPedido, int volumen, int precio, int porcentaje, int adicional) {
    	
    	if (this.listaPedidos.get(codPedido) != null){
    		
    		this.listaPedidos.get(codPedido).agregarPaquete(codPedido, volumen, precio, porcentaje, adicional);	
    		return idPaquete();
    	}
    	
    	else {
    		
    		throw new IllegalArgumentException("El ID del pedido no se encuentra.");
    		
    	}
    }
    // AGREGA PAQUETE ORDINARIO
    public int agregarPaquete(int codPedido, int volumen, int precio, int porcentaje) {
    	
    	if (this.listaPedidos.get(codPedido) != null){
    		
    		this.listaPedidos.get(codPedido).agregarPaquete(codPedido, volumen, precio, porcentaje);	
    		return idPaquete();
    	}
    	
    	else {
    		
    		throw new IllegalArgumentException("El ID del pedido no se encuentra.");
    		
    	}
    }

  /*  public int Paquete agregarPaquete(int codPedido, int volumen, int precio, int costoEnvio);
    public  int Paquete agregarPaquete(int codPedido, int volumen, int precio, int porcentaje, int adicional);
    public boolean quitarPaquete(int codPaquete);
    public void registrarAutomovil(String patente, int volMax, int valorViaje, int maxPaq);
    public void registrarUtilitario(String patente, int volMax, int valorViaje, int valorExtra);
    public void registrarCamion(String patente, int volMax, int valorViaje, int adicXPaq);
    public static String cargarTransporte(String patente);
    public double costoEntrega(String patente);
    public double facturacionTotalPedidosCerrados();
    public Map<Integer,String> pedidosNoEntregados();
    public static double cerrarPedido (int codPedido);*/

    //Aux:
    private static int idPedido() {
    	
        return Pedido.obtenerIdPedido();
        
    }
    
    private static int idPaquete() {
    	
    	 return Pedido.idPaquete();
    	 
    }

    /*private int Integer idPedido(Pedido p){
        return p.obtenerIdPedido();
    }*/
/*
    private static Boolean existePedido(Int idPedido);
    private static Boolean existeCliente(Int idCliente);
    private static Cliente buscarCliente(Int idCliente);
    private static Boolean clienteTienePedidoAbierto(Int idCliente)
    private static Boolean existePaquete(Int idPaquete)
    private static Boolean existeTransporte(String patente)
    private static Transporte buscarTransporte(String patente)
*/


    public static void main(String[] args) {
        Amazing empresa = new Amazing("30-456789-2");

        int p1 = empresa.registrarPedido("Angel Gutierrez",  "San Martin 321", 28324132);
        int p2 = empresa.registrarPedido("Marta Benitez",  "Pasco 1020", 19456398);
        int p3 = empresa.registrarPedido("Daniel Constanzo",  "J.Verdi 876", 35678901);
        int p4 = empresa.registrarPedido("Beatriz Espinoza",  "L.Alberdi 549", 20345678);
        int p5 = empresa.registrarPedido("Angel Gutierrez",  "Madariaga 321", 28324132);
        int p6 = empresa.registrarPedido("Beatriz Espinoza", "L.Alberdi 549", 20345678);

        int paq1= empresa.agregarPaquete(p1, 1235, 2890, 1000);
        int paq2= empresa.agregarPaquete(p4, 1290, 5500, 1100);
        int paq3= empresa.agregarPaquete(p1, 5400, 13400, 3, 400);
        int paq4= empresa.agregarPaquete(p6, 800, 2890, 1000);
        int paq5= empresa.agregarPaquete(p3, 1800, 3500, 1000);
        int paq6= empresa.agregarPaquete(p1, 3800, 13400, 3, 400);
        int paq7= empresa.agregarPaquete(p6, 17000, 28900, 1000);
        int paq8= empresa.agregarPaquete(p1, 35000, 134000, 3, 400);
        int paq9= empresa.agregarPaquete(p4, 120000, 56000, 2, 1100);
        int paq10= empresa.agregarPaquete(p6, 1500, 3890, 1000);

    }


}