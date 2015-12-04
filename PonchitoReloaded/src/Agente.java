import java.sql.SQLException;
import java.util.ArrayList;

public class Agente extends User {
    public static MetaCreador metaCreador;

    public Agente(){
        super();
    }

    public Agente(String n, String a, String e, String t){
        super(n,a,e,t,true);
    }

    public ArrayList<LugarVisitar> getLugares() throws SQLException {
        return metaCreador.crearLugar();
    }
}
