
import java.util.ArrayList;

public class Restaurant {

    public Club c;
    public ArrayList<Menu> menues = new ArrayList<>();

    public Restaurant(Club c) {
        this.c = c;
    }

    public void mostrarMenu() {
        for (int i = 0; i < menues.size(); i++) {
            System.out.print((i +1) + " ");
            menues.get(i).mostrarInfo();    
            
        }
    }

    public void emitirFactura(Socio usuario) {
        mostrarMenu();
        
        c.guardarFactura(new Factura(menues.get(0).getNombre(), menues.get(0).getPrecio(), usuario));

    }

    public void agregarMenu(Menu menu) {
        menues.add(menu);
    }

}
