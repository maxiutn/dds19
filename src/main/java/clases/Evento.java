package clases;

import java.util.List;
import java.time.LocalDate;

public class Evento {

	private String descripcion;
	private LocalDate fechaEncuentro;
	private Ubicacion ubicacion;
	private double temperatura;
	private List<Indumentaria> condicionDelUsuario;
	private List<Atuendo> sugerenciasAceptadas;
	//private AdapterI adapterClima;
	
	public Evento(String evento, LocalDate fecha, Ubicacion ubicacion) {
		this.descripcion = evento;
		this.fechaEncuentro = fecha;
		this.ubicacion = ubicacion;
		//this.adapterClima = unAdapter;
	}
	
	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public LocalDate getFechaDeEncuentro() {
		return this.fechaEncuentro;
	}
	
	public double getTemperatura() {
		return this.temperatura;
	}
	
	public void setCondicionDelUsuario(List<Indumentaria> condicion) {
		this.condicionDelUsuario = condicion;
	}
	
	public List<Indumentaria> getCondicionDelUsuario() {
		return this.condicionDelUsuario;
	}
	
	public void setTemperatura(double unaTemperatura) {
		this.temperatura = unaTemperatura;  //this.adapterClima.recibirTemperatura(unaUbicacion);
	}
	
	public List<Atuendo> getSugerenciasAceptadas() {
		return this.sugerenciasAceptadas;
	}
	
	public void setSugerenciasAceptadas(List<Atuendo> atuendos) {
		this.sugerenciasAceptadas = atuendos;
	}
	/*
	public void rechazarSugerencia(Atuendo atuendo) {
		this.sugerencias.remove(atuendo);
	}
	
	public void aceptarSugerencia(Guardarropa ropero, Atuendo atuendo) {
		ropero.agregarAtuendo(atuendo);
	}
	
	public void deshacerSugerencias(){
		this.sugerencias.removeAll(this.sugerencias);
	}
	*/
}
