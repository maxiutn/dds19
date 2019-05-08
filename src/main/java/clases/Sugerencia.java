package clases;

import java.util.List;

public class Sugerencia {
	String temporada;
	List<Prenda> prendas;

	public Sugerencia() {
		super();
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public List<Prenda> getPrendas() {
		return prendas;
	}

	public void setPrendas(List<Prenda> prendas) {
		this.prendas = prendas;
	}

	Sugerencia mostrar() {
		return this;
	}

}