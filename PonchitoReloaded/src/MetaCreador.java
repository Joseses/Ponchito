import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MetaCreador {
    Puente puente;

    public MetaCreador(Puente puente) {
        this.puente = puente;
    }

    public ArrayList<LugarVisitar> crearLugar() throws SQLException {

        ArrayList<LugarVisitar> lugares = new ArrayList<LugarVisitar>();
        ResultSet rs = puente.getQueryResults("SELECT * FROM lugarVisitar natural join ciudad;");
        while(rs.next()) {
            LugarVisitar lugar = new LugarVisitar(rs.getString("nombre"),rs.getString("ciudad"),
                    rs.getString("pais"), rs.getString("direccion"), rs.getString("descripcion"),
                    rs.getDouble("precio"));
            lugares.add(lugar);
        }
        return lugares;
    }

    public ArrayList<Hotel> crearHoteles() throws SQLException {
        ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
        ResultSet rs = puente.getQueryResults("Select  *\n" +
                "from ciudad natural join hotel;");
        while(rs.next()) {
            Hotel hotel = new Hotel(rs.getString("nombreHotel"), rs.getString("ciudad"), rs.getString("pais"),
                    rs.getString("direccion"), rs.getInt("numCuartos"), rs.getDouble("precioCuarto"),
                    rs.getDouble("precioDesayuno"));
            hoteles.add(hotel);
        }
        return hoteles;
    }

    public ArrayList<Circuito> crearCircuitos() throws SQLException {
        ArrayList<Circuito> circuitos = new ArrayList<Circuito>();
        ResultSet rs = puente.getQueryResults("Select  * from circuito;");
        while(rs.next()) {
            Circuito circuito = new Circuito(rs.getInt("idcircuito"), rs.getString("descripcion"),rs.getString("ciudadSalida"),
                    rs.getString("paisSalidad"),rs.getString("ciudadLlegada"),rs.getString("paisLlegada"), rs.getString("duracion"),
                    rs.getDouble("precio"));
            circuitos.add(circuito);
        }
        return circuitos;
    }

    public Agente getAgentByEMAIL(String email) throws SQLException {
        Agente agente = null;
        ResultSet rs = puente.getQueryResults("SELECT * FROM cliente WHERE email='"+email+"' AND" +
                "cliente="+1+" LIMIT 1;");
        if(rs.next()) {
            agente = new Agente(rs.getString("nombre"),rs.getString("apellidos"),
                    rs.getString("email"), rs.getString("tipo"));
        }
        return agente;
    }
}
