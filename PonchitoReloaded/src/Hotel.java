public class Hotel{
	
	String nombreHotel;
	int localizacion;
	String direccion;
	int numCuartos;
	double precioCuarto;
	double preioDesayuno;
	
	public Hotel(){
		nombreHotel=new String();
		localizacion=0;
		direccion= new String();
		numCuartos=0;
		precioCuarto=0;
		preioDesayuno=0;
	}
	
	public Hotel(String nomh, int loc, String dir, int numc, double precc, double precd){
		nombreHotel=nomh;
		localizacion=loc;
		direccion= dir;
		numCuartos=numc;
		precioCuarto=precc;
		preioDesayuno=precd;
	}
	
	public String getNombreHotel(){return nombreHotel;}
	public int getLocalizacion(){return localizacion;}
	public String getDireccion(){return direccion;}
	public int getNumCuartos(){return numCuartos;}
	public double getPrecioCuarto(){return precioCuarto;}
	public double getPreioDesayuno(){return preioDesayuno;}
	
	public void setNombreHotel(String nomh){
		nombreHotel=nomh;
	}
	public void setLocalizacion(int loc){
		localizacion=loc;
	}
	public void setDireccion(String dir){
		direccion= dir;
	}
	public void setNumCuartos(int numc){
		numCuartos=numc;
	}
	public void setPrecioCuarto(double precc){
		precioCuarto=precc;
	}
	public void setPreioDesayuno(double precd){
		preioDesayuno=precd;
	}
