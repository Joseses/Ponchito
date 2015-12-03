public class LugarVisitar
{
	private String nombre;
	private int localizacion;
	private String direccion;
	private String descripcion;
	private int precio;
	
	public LugarVisitar(){
		nombre = new String();
		localizacion = 0;
		direccion = new String();
		descripcion = new String();
		precio = 0;
		
	}
	
	public LugarVisitar(String nom, int loc, String dir, String des, int p){
		nombre = nom;
		localizacion = loc;
		direccion = dir;
		descripcion = des;
		precio = p;
		
	}
	
	public String getNombre(){return nombre;}
	public int getLocalizacion(){return localizacion;}
	public String getDireccion(){return direccion;}
	public String getDescripcion(){return descripcion;}
	public int getPrecio(){return precio;}
	
	public void setNombre(String nom){
		nombre = nom;	
	}
	public void setLocalizacion(int loc){localizacion = loc;}
	public void setDireccion(String dir){direccion = dir;}
	public void setDescripcion(String des){descripcion = des;}
	public void setPrecio(int p){precio = p;}

}
