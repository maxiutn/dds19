package clases;

public class Ubicacion {

	private double latitud;
	private double longitud;
	
	public Ubicacion(double latitud, double longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
	public double getLatitud() {
		return this.latitud;
	}
	
	public double getLongitud() {
		return this.longitud;
	}
}
