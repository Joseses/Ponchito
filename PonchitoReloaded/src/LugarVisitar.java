public class LugarVisitar {
    private String nombre;
    private String ciudad;
    private String pais; //
    private String direccion;
    private String descripcion;
    private double precio;
    private double duracion;

    public LugarVisitar(){
        nombre = "";
        ciudad="";
        pais="";
        direccion = "";
        descripcion = "";
        precio = 0;
    }

    public LugarVisitar(String nom, String ciu, String pa, String dir, String des, double p){
        nombre = nom;
        ciudad = ciu;
        pais=pa;
        direccion = dir;
        descripcion = des;
        precio = p;
    }

    public String getNombre(){return nombre;}
    public String getCiudad(){return ciudad;}
    public String getPais(){return pais;}
    public String getDireccion(){return direccion;}
    public String getDescripcion(){return descripcion;}
    public double getPrecio(){return precio;}
    public void setNombre(String nom){
        nombre = nom;
    }
    public void setCiudad(String ciu){ciudad = ciu;}
    public void setPais(String pa){pais=pa;}
    public void setDireccion(String dir){direccion = dir;}
    public void setDescripcion(String des){descripcion = des;}
    public void setPrecio(int p){precio = p;}

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
}