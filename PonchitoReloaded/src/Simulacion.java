import java.util.ArrayList;

public class Simulacion {

	private int idestimacion;
	private String cliente;
	private String nombrePersona;
	private String fechaSalida;
	private String fechaLlegada;
	private int numPersonas;
	private String[] localizacion;
	private double precio;
    private ArrayList<Circuito> circuitos;
    private ArrayList<Hotel> hoteles;
	
	public Simulacion(){
		idestimacion = 0;
		cliente = "";
		nombrePersona = "";
		fechaSalida = "";
		fechaLlegada = "";
		numPersonas = 0;
		localizacion = new String[2];
		precio = 0;
        circuitos = new ArrayList<Circuito>();
	}
	
	public Simulacion(int id, String uncliente, String nombre, String fs, String fll, int per, String[] loc, double pre){
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
	public String[] getLocalizacion(){return localizacion;}
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
	public void setLocalizacion(String[] loc){
		localizacion = loc;
	}
	public void setPrecio(double pre){
		precio = pre;
	}

    public ArrayList<Circuito> getCircuitos() {
        return circuitos;
    }

    public void setCircuitos(ArrayList<Circuito> circuitos) {
        this.circuitos = circuitos;
    }

    public void addCircuito(Circuito circuito) {
        this.circuitos.add(circuito);
    }

    public ArrayList<Hotel> getHoteles() {
        return hoteles;
    }

    public void setHoteles(ArrayList<Hotel> hoteles) {
        this.hoteles = hoteles;
    }

    public void addHotel(Hotel hotel) {
        this.hoteles.add(hotel);
    }
}
