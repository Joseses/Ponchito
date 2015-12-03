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
            Hotel hotel = new LugarVisitar(rs.getString("nombreHotel"), loc, rs.getString("direccion"),
                                                rs.getString("numCuartos"), rs.getDouble("precioCuarto"), rs.getDouble("precioDesayuno"));
            hoteles.add(hotel);
        }
        return hoteles;
    }
}
