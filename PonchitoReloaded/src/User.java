public class User
{
	private String nombre;
	private String apellidos;
	
	public User(){
		nombre = new String();
		apellidos = new String();
	}
	
	public User(String unNombre, String unApellido){
		nombre = unNombre;
		apellidos = unApellido;
	}
	
	public String getNombre(){return nombre;}
	public String getApellidos(){return apellidos;}
	public void setNombre(String unNombre){
		nombre=unNombre;
		return nombre;
	}
	public void setApellidos(String unApellido){
		apellidos=unApellido;
		return apellidos;
	}
	
}
