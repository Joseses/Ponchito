public class LugarVisitar {
	private String nombre;
	private String[] localizacion;
	private String direccion;
	private String descripcion;
	private double precio;
	
	public LugarVisitar(){
		nombre = "";
		localizacion = new String[2];
		direccion = "";
		descripcion = "";
		precio = 0;
	}
	
	public LugarVisitar(String nom, String[] loc, String dir, String des, double p){
		nombre = nom;
		localizacion = loc;
		direccion = dir;
		descripcion = des;
		precio = p;
	}
	
	public String getNombre(){return nombre;}
	public String[] getLocalizacion(){return localizacion;}
	public String getDireccion(){return direccion;}
	public String getDescripcion(){return descripcion;}
	public double getPrecio(){return precio;}
	public void setNombre(String nom){
		nombre = nom;	
	}
	public void setLocalizacion(String[] loc){localizacion = loc;}
	public void setDireccion(String dir){direccion = dir;}
	public void setDescripcion(String des){descripcion = des;}
	public void setPrecio(int p){precio = p;}

}
