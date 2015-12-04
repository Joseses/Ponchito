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
        ResultSet rs = puente.getQueryResults("SELECT * FROM lugarVisitar LEFT JOIN localizacion\n" +
                "on lugarVisitar.localizacion = idloc;");
        while(rs.next()) {
            String[] loc = new String[2];
            loc[0] = rs.getString("ciudad");
            loc[1] = rs.getString("pais");
            LugarVisitar lugar = new LugarVisitar(rs.getString("nombre"), loc, rs.getString("direccion"),
                                                rs.getString("descripcion"), rs.getDouble("precio"));
            lugares.add(lugar);
        }
        return lugares;
    }
    
    public ArrayList<Hotel> crearHoteles() throws SQLException {
        ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
        ResultSet rs = puente.getQueryResults("Select * From hotel left join localizacion\n" +
                "on localizacion.idloc = hotel.localizacion;");
        while(rs.next()) {
            String[] loc = new String[2];
            loc[0] = rs.getString("ciudad");
            loc[1] = rs.getString("pais");
            Hotel hotel = new Hotel(rs.getString("nombreHotel"), loc, rs.getString("direccion"),
                                                rs.getInt("numCuartos"), rs.getDouble("precioCuarto"), rs.getDouble("precioDesayuno"));
            hoteles.add(hotel);
        }
        return hoteles;
    }

    public ArrayList<Circuito> crearCircuitos() throws SQLException {
        ArrayList<Circuito> circuitos = new ArrayList<Circuito>();
        ResultSet rs = puente.getQueryResults("Select idcircuito,descripcion,lugarSalida,lugarLlegada,duracion,precio,\n" +
                "l1.ciudad as ciudad1,\n" +
                "l1.pais as pais1, l2.ciudad as ciudad2,l2.pais as pais2 \n" +
                "From circuito natural join (localizacion l1, localizacion l2) \n" +
                "where l1.idloc = circuito.lugarSalida and l2.idloc = circuito.lugarLlegada;");
        while(rs.next()) {
            String[] loc1 = new String[2];
            String[] loc2 = new String[2];
            loc1[0] = rs.getString("ciudad1");
            loc1[1] = rs.getString("pais1");
            loc2[0] = rs.getString("ciudad2");
            loc2[1] = rs.getString("pais2");
            Circuito circuito = new Circuito(rs.getInt("idcircuito"), rs.getString("descripcion"),loc1, loc2,
                    rs.getString("duracion"), rs.getInt("precio"));
            circuitos.add(circuito);
        }
        return circuitos;
    }
}
