public class Autorizada implements MovimientosDeSocio {
    public String nombre;
    private Socio socio;

    public Autorizada(String nombre, Socio socio){
        this.nombre = nombre;
        this.socio = socio;
    }

 
   
    public Socio getSocioQueMeautorizo(){
        return socio;
    }

    @Override
    public void comprar(Restaurant r) {
        socio.comprar(r);
    }

    @Override
    public String getNombre() {
        return nombre;
    
    }

    @Override
    public void cancelarFactura(int posicion) {
       
    }
}
