public class User {
	private String nombre;
	private String apellidos;
    private String email;
    private String tipo;
    private boolean empleado;
	
	public User(){
		nombre = "";
		apellidos = "";
        email = "";
        tipo="";
        empleado = false;
	}
	
	public User(String n, String a, String e, String t, boolean emp){
		nombre = n;
        apellidos = a;
        email = e;
        tipo = t;
        empleado = emp;
	}
	
	public String getNombre(){return nombre;}
	public String getApellidos(){return apellidos;}
	public void setNombre(String unNombre){
		nombre=unNombre;
	}
	public void setApellidos(String unApellido){
		apellidos=unApellido;
	}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEmpleado() {
        return empleado;
    }

    public void setEmpleado(boolean empleado) {
        this.empleado = empleado;
    }
}
