package clases;

import java.time.LocalDate;

public class Evento {

	private String descripcion;
	private LocalDate fechaEncuentro;
	private Ubicacion ubicacion;
	private double temperatura;
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
}
