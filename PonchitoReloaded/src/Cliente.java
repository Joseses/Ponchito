public class Cliente extends User
{
	private String email;
	private String tipo;
	private boolean empleado;
	
	public Cliente(){
		super();
		email = new String();
		tipo = new String();
		empleado = false;
	}
	
	public Cliente(String unEmail, String unTipo, boolean emplea){
		email=unEmail;
		tipo=unTipo;
		empleado=emplea;
		
	}
	
	public String getEmail(){return email;}
	public String getTipo(){return tipo;}
	public boolean getEmpleado(){return empleado;}
	
	public void setEmail(String unEmail){
		email=unEmail;
	}
	public void setTipo(String unTipo){
		tipo=unTipo;
	}
	public void setEmpleado(boolean emplea){
		empleado=emplea;
	}
	
}
