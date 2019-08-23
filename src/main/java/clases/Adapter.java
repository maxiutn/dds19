package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Adapter implements AdapterI {
	
	private List<ServicioClima> servicios = new ArrayList<ServicioClima>();
	private ServicioClima servicio;
	
	public double recibirTemperatura(Ubicacion ubicacion) {
		return servicio.getTemperatura(ubicacion);
	}
	
	public void setServicio() {
		Optional<ServicioClima> respuesta = this.servicios.stream().findAny();
		if(respuesta.isPresent()) {
			this.servicio = respuesta.get();
		} else {
			this.servicio = null;
		}
	}
	
	public void agregarServicio(ServicioClima unServicio) {
		this.servicios.add(unServicio);
	}
	
	public boolean noHayServicio() {
		return this.servicio == null;
	}
	
	public String servicio() {
		return this.servicio.servicio();
	}
}