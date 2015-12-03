public class Simulacion {

	private int idestimacion;
	private String cliente;
	private String nombrePersona;
	private String fechaSalida;
	private String fechaLlegada;
	private int numPersonas;
	private int localizacion;
	private double precio;
    private Circuito[] circuitos;
    private Hotel[] hoteles;
	
	public Simulacion(){
		idestimacion = 0;
		cliente = new String();
		nombrePersona = new String();
		fechaSalida = new String();
		fechaLlegada = new String();
		numPersonas = 0;
		localizacion = 0;
		precio = 0;
	}
	
	public Simulacion(int id, String uncliente, String nombre, String fs, String fll, int per, int loc, double pre){
		idestimacion = id;
		cliente = uncliente;
		nombrePersona = nombre;
		fechaSalida = fs;
		fechaLlegada= fll;
		numPersonas = per;
		localizacion = loc;
		precio = pre;
	}
	
	public int getIdestimacion(){return idestimacion;}
	public String getCliente(){return cliente;}
	public String getNombrePersona(){return nombrePersona;}
	public String getFechaSalida(){return fechaSalida;}
	public String getFechaLlegada(){return fechaLlegada;}
	public int getNumPersonas(){return numPersonas;}
	public int getLocalizacion(){return localizacion;}
	public double getPrecio(){return precio;}
	
	public void setIdestimacion(int id){
		idestimacion = id;
	}
	public void setCliente(String uncliente){
		cliente = uncliente;
	}
	public void setNombrePersona(String nombre){
		nombrePersona = nombre;
	}
	public void setFechaSalida(String fs){
		fechaSalida = fs;
	}
	public void setFechaLlegada(String fll){
		fechaLlegada= fll;
	}
	public void setNumPersonas(int per){
		numPersonas = per;
	}
	public void setLocalizacion(int loc){
		localizacion = loc;
	}
	public void setPrecio(double pre){
		precio = pre;
	}
	
}
