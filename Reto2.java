package reto2;
// Este es el codigo que se pasa para evaluacion automatica:
import java.util.HashMap;
import java.util.Scanner;
class Reto2{
    private final Scanner scanner = new Scanner(System.in);
   
    public String read(){
        return this.scanner.nextLine();
    }
    public void run(){
       // Entrada de datos
       String operacion = read();
       String[] entrada = read().split(" ");
       //Operaciones
       BaseDatosProductos l1 = new BaseDatosProductos();
       Producto prod = new Producto(Integer.parseInt(entrada[0]), 
               entrada[1],
               Double.parseDouble(entrada[2]),
               Integer.parseInt(entrada[3]));
       if(operacion.equals("AGREGAR") && !(l1.listaProductos.containsKey(prod.getCodigo()))){
           l1.agregar(prod);
           // Generar informe
           System.out.println(String.format("%.1f", l1.generarInforme()));
       }
       else if(operacion.equals("BORRAR") && (l1.listaProductos.containsKey(prod.getCodigo()))){
           l1.borrar(prod);
           // Generar informe
           System.out.println(String.format("%.1f", l1.generarInforme()));
       }
       else if(operacion.equals("ACTUALIZAR") && (l1.listaProductos.containsKey(prod.getCodigo()))){
           l1.actualizar(prod); 
           // Generar informe
           System.out.println(String.format("%.1f", l1.generarInforme()));
       }
       else{
           System.out.println("ERROR");
       }
      
    }
    public static void main(String[] args) {
        Reto2 main = new Reto2();
        main.run();
    }
}

class Producto{
    int codigo;     
    String nombre;     
    double precio;     
    int inventario;     
    // Constructor:
    public Producto(int codigo, String nombre, double precio, int inventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }
    // getters y setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }
    
}

class BaseDatosProductos{
    // Atributo listaproductos:
    HashMap<Integer, Producto> listaProductos = new HashMap<>();
    // Constructor
    public BaseDatosProductos() {
        listaProductos.put(1, new Producto(1, "Manzanas", 5000.0, 25));         
        listaProductos.put(2, new Producto(2, "Limones", 2300.0, 15));         
        listaProductos.put(3, new Producto(3, "Peras", 2700.0, 33));         
        listaProductos.put(4, new Producto(4, "Arandanos", 9300.0, 5));         
        listaProductos.put(5, new Producto(5, "Tomates", 2100.0, 42));         
        listaProductos.put(6, new Producto(6, "Fresas", 4100.0, 3));         
        listaProductos.put(7, new Producto(7, "Helado", 4500.0, 41));         
        listaProductos.put(8, new Producto(8, "Galletas", 500.0, 8));
        listaProductos.put(9, new Producto(9, "	Chocolates", 3500.0, 80));
        listaProductos.put(10,new Producto(10, "Jamon", 15000.0, 10));
    }   
    //Metodos 
    //public double generarInforme(){
        //double var1 = 0.0;
        //for(int i=1;i<=listaProductos.size();i++){
             //var1 += listaProductos.get(i).getPrecio()*listaProductos.get(i).getInventario();
    public double generarInforme(){
        double var1 = 0.0;
        for(Producto x: listaProductos.values()){
             var1 += x.getPrecio()*x.getInventario();
       }
        return var1;
    }
    public void agregar(Producto prod){
        listaProductos.put(prod.getCodigo(), prod);
    }
    public void actualizar(Producto prod){
        listaProductos.replace(prod.getCodigo(), prod);
    }
    public void borrar(Producto prod){
        listaProductos.remove(prod.getCodigo());
}
}