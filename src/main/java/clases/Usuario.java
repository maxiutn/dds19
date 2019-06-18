package clases;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private List<Guardarropa> guardarropas;
	
	public Usuario() {
		this.guardarropas = new ArrayList<Guardarropa>();
	}

	public void setGuardarropa(Guardarropa guardarropa) {
		this.guardarropas.add(guardarropa);
	}
	
	public int cantidadDeGuardarropas() {
		return this.guardarropas.size();
	}
	
	public List<Guardarropa> guardarropas() {
		return this.guardarropas;
	}
	
	public void agregarNuevoGuardarropa(String unaDescripcion) {
		guardarropas.add(new Guardarropa(unaDescripcion));
	}
}