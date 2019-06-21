package clases;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private List<Guardarropa> guardarropas;
	private String nombre;
	
	public Usuario() {
		this.guardarropas = new ArrayList<Guardarropa>();
	}
	
	public Usuario(String nombre) {
		this.nombre = nombre;
		this.guardarropas = new ArrayList<Guardarropa>();
	}
	
	public String getNombre() {
		return this.nombre;
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
}
