
import java.util.ArrayList;
import java.util.HashSet;

public class Club {
    
    private String nombre; 
            
    protected ArrayList<Factura> facturas = new ArrayList<>();
    
    public ArrayList<Restaurant> restaurants = new ArrayList<>();
            
    public ArrayList<Socio> socios = new ArrayList<>() ;

    protected ArrayList<Autorizada> autorizados = new ArrayList<>();

    public Club(String nombre){
        this.nombre = nombre;
    }
    public void agregarRestaurant(Restaurant rest){
        restaurants.add(rest);
        
    }
    public void registrarSocio(Socio soc){
        socios.add(soc);
        System.out.println("Registré al socio!");
    }

    public boolean esSocio(int id ){
       for(Socio i : socios ){
           if(i.getId() == id){
               return true;
           }
       }
       return false;
        
        
    }
    
    public Socio devolverSocio(int id){
        for(Socio i : socios ){
           if(i.getId() == id){
               return i;
           }
       }
        return null;
        
    }
    
    public Autorizada devolverAutorizado(String nombreAutorizada){
        for(Autorizada autorizado : autorizados){
            if(autorizado.getNombre().equalsIgnoreCase(nombreAutorizada)){
                return  autorizado;
            }
        }
        return null;
    }
    
    public void cancelarFactura(int posicion){
       if(facturas.remove(facturas.get(posicion))){
           System.out.println("Factura cancelada n° " + posicion );
       } 
        
    }
    
    
   public void guardarFactura(Factura f){
       facturas.add(f);
   }
   
   public void mostrarFacturas(Socio usuario){
       
       
       facturas.forEach( (Factura n) -> {
          
            if(n.getConsumidor().getId() == usuario.getId())
            {
                System.out.println("Numero de factura: "+ facturas.indexOf(n) +"\nProducto: " + n.getProducto()+ "\nPrecio: " + n.getValor() + "\nConsumidor: " + n.getConsumidor().getNombre());
                System.out.println("-------------------------------");
           
            } 
                
       
       });
       
   }
   
   public void registrarInvitado(Socio socio, Autorizada autorizada){
       autorizados.add(autorizada);
       System.out.println("AGREGUÉ AL INVITADO");
       socio.agregarInvitado(autorizada);
       
   }

   public boolean verificarInvitado(String nombreAutorizada){
       for(int i = 0; i < autorizados.size(); i++){
            if(nombreAutorizada.equalsIgnoreCase(autorizados.get(i).getNombre())){
                return true;
            }
            
        }
        return false;
       
       
       
       
       
   }
}
