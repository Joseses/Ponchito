import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class LugarVisitar {
    private SimpleStringProperty nombre;
    private SimpleStringProperty ciudad;
    private SimpleStringProperty pais; //
    private SimpleStringProperty direccion;
    private SimpleStringProperty descripcion;
    private SimpleDoubleProperty precio;
    private SimpleDoubleProperty duracion;

    public LugarVisitar(){
        nombre = new SimpleStringProperty();
        ciudad=new SimpleStringProperty();
        pais=new SimpleStringProperty();
        direccion = new SimpleStringProperty();
        descripcion = new SimpleStringProperty();
        precio = new SimpleDoubleProperty();
    }

    public LugarVisitar(String nom, String ciu, String pa, String dir, String des, double p){
        nombre = new SimpleStringProperty(nom);
        ciudad = new SimpleStringProperty(ciu);
        pais=new SimpleStringProperty(pa);
        direccion = new SimpleStringProperty(dir);
        descripcion = new SimpleStringProperty(des);
        precio = new SimpleDoubleProperty(p);
    }

    public String getNombre() {
        return nombre.get();
    }

    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getCiudad() {
        return ciudad.get();
    }

    public SimpleStringProperty ciudadProperty() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad.set(ciudad);
    }

    public String getPais() {
        return pais.get();
    }

    public SimpleStringProperty paisProperty() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais.set(pais);
    }

    public String getDireccion() {
        return direccion.get();
    }

    public SimpleStringProperty direccionProperty() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion.set(direccion);
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public SimpleStringProperty descripcionProperty() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    public double getPrecio() {
        return precio.get();
    }

    public SimpleDoubleProperty precioProperty() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio.set(precio);
    }

    public double getDuracion() {
        return duracion.get();
    }

    public SimpleDoubleProperty duracionProperty() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion.set(duracion);
    }
}