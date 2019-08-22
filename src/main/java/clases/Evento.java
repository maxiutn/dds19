package clases;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Evento {

	private String descripcion;
	private LocalDate fechaEncuentro;
	private Ubicacion ubicacion;
	private double temperatura;
	private List<Atuendo> sugerencias;
	private AdapterI adapterClima;
	
	public Evento(String evento, LocalDate fecha, Ubicacion ubicacion,AdapterI unAdapter) {
		this.descripcion = evento;
		this.fechaEncuentro = fecha;
		this.ubicacion = ubicacion;
		this.adapterClima = unAdapter;
		//this.temperatura = this.adapterClima.recibirTemperatura(this.ubicacion);
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
	
	public void setTemperatura(Ubicacion unaUbicacion) {
		this.temperatura = this.adapterClima.recibirTemperatura(unaUbicacion);
	}
	
	public List<Atuendo> getSugerencias() {
		return this.sugerencias;
	}
	
	public void setSugerencias(List<Atuendo> atuendos) {
		this.sugerencias = atuendos;
	}
	
	public void rechazarSugerencia(Atuendo atuendo) {
		this.sugerencias.remove(atuendo);
	}
	
	public void aceptarSugerencia(Guardarropa ropero, Atuendo atuendo) {
		ropero.agregarAtuendo(atuendo);
	}
	
	public void deshacerSugerencias(){
		this.sugerencias.removeAll(this.sugerencias);
	}
}
