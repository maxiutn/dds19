package clases;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private List<Guardarropa> guardarropas;
	private String nombre;
	protected String tipoDeUsuario;
	//private Sugerencia sugerencia = new Sugerencia();
	private List<Evento> eventos;
	
	public Usuario(String nombre, String categoria) {
		this.nombre = nombre;
		this.tipoDeUsuario = categoria;
		this.guardarropas = new ArrayList<Guardarropa>();
		this.eventos = new ArrayList<Evento>();
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
		if(this.tipoDeUsuario == "Premium") {
			guardarropa.setMaximoPrendas(-1);
		}else {
			guardarropa.setMaximoPrendas(10);
		}
	}
	
	/*
	public void setSugerencia(SugerenciaStrategy sugerencia) {
		this.sugerencia = sugerencia;
		sugerencia.realizarSugerencias(self);
	}
	*/
	
	public void agregarEvento(Evento e) {
		this.eventos.add(e);
	}
	
	public List<Evento> getListaEventos() {
		return this.eventos;
	}
	
}
