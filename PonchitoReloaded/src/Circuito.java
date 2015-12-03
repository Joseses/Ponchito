public class Circuito
{
	private int idcircuito;
	private String descripcion;
	private int lugarSalida;
	private int lugarLlegada;
	private String duracion;
	private double precio;
	
	public Circuito()
	{
		idcircuito=0;
		descripcion= new String();
		lugarSalida=0;
		lugarLlegada=0;
		duracion = new String();
		precio = 0;
	}
	
	public Circuito(int id, String des, String sal, String lle, String dur, int p)
	{
		idcircuito=id;
		descripcion= des;
		lugarSalida=sal;
		lugarLlegada=lle;
		duracion = dur;
		precio = p;
	}
	
	public int getIdcircuito(){return idcircuito;}
	public String getDescripcion(){return descripcion;}
	public int getLugarSalida(){return lugarSalida;}
	public int getLugarLlegada(){return lugarLlegada;}
	public String getDuracion(){return duracion;}
	public double getPrecio(){return precio;}
	
	public void setIdcircuito(int id){idcircuito=id;}
	public void setDescripcion(String des){descripcion= des;}
	public void setLugarSalida(String sal){lugarSalida=sal;}
	public void setLugarLlegada(String lle){lugarLlegada=lle;}
	public void setDuracion(String dur){duracion = dur;}
	public void setPrecio(int p){precio = p;}
	
}
