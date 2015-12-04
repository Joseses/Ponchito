import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Circuito {
    private int idcircuito;
    private String descripcion;
    private String ciudadSalida; //jaja
    private String paisSalida;
    private String ciudadLlegada;
    private String paisLlegada;
    private String duracion;
    private double precio;
    private ArrayList<LugarVisitar> etapa;

    private String fecha;
    public Puente puente;

    public Circuito() {
        idcircuito=0;
        descripcion= "";
        ciudadSalida="";
        paisSalida="";
        ciudadLlegada="";
        paisLlegada="";
        duracion = "";
        precio = 0;
        etapa = new ArrayList<LugarVisitar>();
    }

    public Circuito(int id, String des, String csal, String psal, String clle, String plle, String dur, double p) {
        idcircuito=id;
        descripcion= des;
        ciudadSalida=csal;
        paisSalida=psal;
        ciudadLlegada=clle;
        paisLlegada=plle;
        duracion = dur;
        precio = p;
    }

    public int getIdcircuito(){return idcircuito;}
    public String getDescripcion(){return descripcion;}
    public String getCSalida(){return ciudadSalida;}
    public String getPSalida(){return paisSalida;}
    public String getCLlegada(){return ciudadLlegada;}
    public String getPLlegada(){return paisLlegada;}
    public String getDuracion(){return duracion;}
    public double getPrecio(){return precio;}

    public void setIdcircuito(int id){idcircuito=id;}
    public void setDescripcion(String des){descripcion= des;}
    public void getCSalida(String csal){ ciudadSalida=csal;}
    public void getPSalida(String psal){paisSalida=psal;}
    public void getCLlegada(String clle){ciudadLlegada=clle;}
    public void getPLlegada(String plle){paisLlegada=plle;}
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

    public void sqlfyThisCircuit()throws Exception  {

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

        String sql ="("+"'"+getIdcircuito()+"'"+","+"'"+getDescripcion()+"'"+","+"'"+getCSalida()+"'"+","
                +"'"+getPSalida()+"'"+","+"'"+getCLlegada()+"'"+","+"'"+getPLlegada()+"'"+","+"'"+getDuracion()+"'"+","
                +"'"+getPrecio()+"'"+")";
        System.out.println(sql);//

        rs = puente.getQueryResults("Inser into circuito(descripcion, ciudadSalida, paisSalida, ciudadLlegada, paisLlegada, duracion," +
                "precio) VALUES " +  sql);
    }
}
