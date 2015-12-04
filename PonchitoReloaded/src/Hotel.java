public class Hotel {

    String nombreHotel;
    String ciudad;
    String pais; //www
    String direccion;
    int numCuartos;
    double precioCuarto;
    double precioDesayuno;

    public Hotel() {
        nombreHotel = "";
        ciudad = "";
        pais = "";
        direccion = "";
        numCuartos = 0;
        precioCuarto = 0;
        precioDesayuno = 0;
    }

    public Hotel(String nomh, String ciu, String pa, String dir, int numc, double precc, double precd) {
        nombreHotel = nomh;
        ciudad = ciu;
        pais=pa;
        direccion = dir;
        numCuartos = numc;
        precioCuarto = precc;
        precioDesayuno = precd;
    }

    public String getNombreHotel() {return nombreHotel;}
    public String getCiudad(){return ciudad; }
    public String getPais(){return pais; }
    public String getDireccion() {return direccion;}
    public int getNumCuartos() {return numCuartos;}
    public double getPrecioCuarto() {
        return precioCuarto;
    }
    public double getPrecioDesayuno() {
        return precioDesayuno;
    }

    public void setNombreHotel(String nomh) {
        nombreHotel = nomh;
    }
    public void setCiudad(String ciu) {
        ciudad = ciu;
    }
    public void setPais(String pa){pais = pa;}
    public void setDireccion(String dir) {
        direccion = dir;
    }
    public void setNumCuartos(int numc) {
        numCuartos = numc;
    }
    public void setPrecioCuarto(double precc) {
        precioCuarto = precc;
    }
    public void setPreioDesayuno(double precd) {
        precioDesayuno = precd;
    }
}
