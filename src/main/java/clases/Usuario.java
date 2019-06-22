package clases;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
	
	private List<Guardarropa> guardarropas;
	private String nombre;
	protected String tipoDeUsuario;
	private SugerenciaStrategy sugerencia;
	private List<Evento> eventos;
	
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
		if(this.tipoDeUsuario == "Premium") {
			guardarropa.setMaximoPrendas(-1);
		}else {
			guardarropa.setMaximoPrendas(10);
		}
	}
	
	public int cantidadDeGuardarropas() {
		return this.guardarropas.size();
	}
	
	public List<Guardarropa> guardarropas() {
		return this.guardarropas;
	}
	
	public void agregarNuevoGuardarropa(Guardarropa guardarropa) {
		this.guardarropas.add(guardarropa);
	}

	public void setSugerencia(SugerenciaStrategy sugerencia) {
		this.sugerencia = sugerencia;
	}
	
	public void agregarEvento(Evento e) {
		this.eventos.add(e);
	}
	
}
