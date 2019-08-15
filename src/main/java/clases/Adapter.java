package clases;

import java.util.ArrayList;
import java.util.List;

public class Adapter implements AdapterI {
	
	private List<ServicioClima> servicios = new ArrayList<ServicioClima>();
	private ServicioClima servicio;
	
	public double recibirTemperatura(Ubicacion ubicacion) {
		return servicio.getTemperatura(ubicacion);
	}
	
	public void setServicio() {
		for(ServicioClima servicio: this.servicios) {
			if(servicio.estaDisponible()) {
				this.servicio = servicio;
				break;
			}
		}
	}
	
	public boolean noHayServicio() {
		return this.servicio == null;
	}
	
	public void agregarServicio(ServicioClima unServicio) {
		this.servicios.add(unServicio);
	}
	
	public String servicio() {
		return this.servicio.servicio();
	}
}