// ESTE ES EL MENU DEL RESTAURANT

public class Menu {
    private String nombre;
    private double precio;
    
    public Menu(String nombre, double precio){
        this.nombre = nombre;
        this.precio  = precio;
        
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    
    public void mostrarInfo(){
        System.out.println(getNombre() + " " + getPrecio()  );
    }
   
}
