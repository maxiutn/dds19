package clases;

import java.time.LocalDate;

public class Evento {

	private String evento;
	private LocalDate fechaEncuentro;
	private Ubicacion ubicacion;
	
	public Evento(String evento, LocalDate fecha, Ubicacion ubicacion) {
		this.evento = evento;
		this.fechaEncuentro = fecha;
		this.ubicacion = ubicacion;
	}
	
	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}
}
