package clases;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
	
	private List<Guardarropa> guardarropas;
	private String nombre;
	protected String tipoDeUsuario;
	protected int max_guardarropa;
	
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
	
	public void agregarNuevoGuardarropa(Guardarropa guardarropa) {
		if(this.cantidadDeGuardarropas() < this.max_guardarropa || this.tipoDeUsuario == "Premium") {
			this.guardarropas.add(guardarropa);
		}else {
			System.out.println("Solo puede tener "+ this.max_guardarropa +" guardarropas.");
		}
	}
}
