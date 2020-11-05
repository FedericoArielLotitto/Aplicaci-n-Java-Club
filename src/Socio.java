
import java.util.ArrayList;
import java.util.HashSet;

public class Socio implements MovimientosDeSocio {
    private String nombre ; 
    private int id;
    private Club club ;
    public ArrayList<Autorizada> autorizados = new ArrayList<>();
  //  HashSet<Factura> cuenta ;
    public int getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public Socio(String nombre, int id, Club club){
      this.nombre = nombre;
      this.id = id;
      this.club = club;
      
    }
    
    @Override
    public void comprar(Restaurant r) {
        
        r.emitirFactura(this);
        
    }
    
    
    @Override
    public void cancelarFactura(int posicion) {
        club.cancelarFactura(posicion);

    }
    public void agregarInvitado(Autorizada autorizada){
        autorizados.add(autorizada);
    }
    public void registrarAutorizado(Autorizada autorizada){
        club.registrarInvitado(this, autorizada);
    }
     
    
}


