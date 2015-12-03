public class Hotel {

    String nombreHotel;
    String[] localizacion;
    String direccion;
    int numCuartos;
    double precioCuarto;
    double precioDesayuno;

    public Hotel() {
        nombreHotel = new String();
        localizacion = new String[2];
        direccion = new String();
        numCuartos = 0;
        precioCuarto = 0;
        precioDesayuno = 0;
    }

    public Hotel(String nomh, String[] loc, String dir, int numc, double precc, double precd) {
        nombreHotel = nomh;
        localizacion = loc;
        direccion = dir;
        numCuartos = numc;
        precioCuarto = precc;
        precioDesayuno = precd;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public String[] getLocalizacion() {
        return localizacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getNumCuartos() {
        return numCuartos;
    }

    public double getPrecioCuarto() {
        return precioCuarto;
    }

    public double getPrecioDesayuno() {
        return precioDesayuno;
    }

    public void setNombreHotel(String nomh) {
        nombreHotel = nomh;
    }

    public void setLocalizacion(String[] loc) {
        localizacion = loc;
    }

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
