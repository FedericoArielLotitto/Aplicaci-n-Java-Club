public class Factura {

    private String producto;

    private double valor;

    private Socio consumidor;

    public Factura(String producto, double valor, Socio consumidor) {
        this.producto = producto;
        this.valor = valor;
        this.consumidor = consumidor;
    }

    public String getProducto() {
        return producto;
    }

    public double getValor() {
        return valor;
    }

    public Socio getConsumidor() {
        return consumidor;
    }

    public void mostrarInfo() {
        
        System.out.println("Producto : " + getProducto());
        System.out.println("Valor : " + getValor());
        System.out.println("Consumidor final : " + getConsumidor());
    
    }
}
