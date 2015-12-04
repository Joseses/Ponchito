import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Circuito {
	private int idcircuito;
	private String descripcion;
	private String[] lugarSalida;
	private String[] lugarLlegada;
	private String duracion;
	private double precio;
    private ArrayList<LugarVisitar> etapa;

    private String fecha;
	public Puente puente;
	
	public Circuito() {
		idcircuito=0;
		descripcion= "";
		lugarSalida= new String[2];
		lugarLlegada= new String[2];
		duracion = "";
		precio = 0;
        etapa = new ArrayList<LugarVisitar>();
	}
	
	public Circuito(int id, String des, String[] sal, String[] lle, String dur, int p) {
		idcircuito=id;
		descripcion= des;
		lugarSalida=sal;
		lugarLlegada=lle;
		duracion = dur;
		precio = p;
	}
	
	public int getIdcircuito(){return idcircuito;}
	public String getDescripcion(){return descripcion;}
	public String[] getLugarSalida(){return lugarSalida;}
	public String[] getLugarLlegada(){return lugarLlegada;}
	public String getDuracion(){return duracion;}
	public double getPrecio(){return precio;}
	
	public void setIdcircuito(int id){idcircuito=id;}
	public void setDescripcion(String des){descripcion= des;}
	public void setLugarSalida(String[] sal){lugarSalida=sal;}
	public void setLugarLlegada(String[] lle){lugarLlegada=lle;}
	public void setDuracion(String dur){duracion = dur;}
	public void setPrecio(int p){precio = p;}

    public ArrayList<LugarVisitar> getEtapa() {
        return etapa;
    }

    public void setEtapa(ArrayList<LugarVisitar> etapa) {
        this.etapa = etapa;
    }

    public void addEtapa(LugarVisitar lugarVisitar) {
        this.etapa.add(lugarVisitar);
    }

    public String sqlfyThisCircuit()throws Exception  {

		puente = new Puente("beto");

		MetaCreador metaCreador = new MetaCreador(puente);
		ResultSet rs = puente.getQueryResults("Select Max(idcircuito) from circuito;");
        rs.next();
        int max  = rs.getInt("Max(idcircuito)");
        if(max==0){
            max=1;
        }
        else
            max=max+1;

        String sql=" ";//="("+getIdcircuito()+","+getDescripcion()+","+getLugarSalida()+","+getLugarLlegada()+","+getDuracion()+","+getPrecio()

        return sql;
    }
}
