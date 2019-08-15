package clases;

import java.util.ArrayList;
import java.util.List;

public class TipoDePrenda {
	
	private Categoria categoria;
	private List<Tela> listadoTelasAceptables;
	private String descripcion;
	private List<TipoDePrenda> prendasSuperpuestas;
	private int calor;
	
	public TipoDePrenda(String descripcion, List<Tela> telas, Categoria unaCategoria, int calor) {
		this.descripcion = descripcion;
		this.listadoTelasAceptables = telas;
		this.categoria = unaCategoria;
		this.calor = calor;
		this.prendasSuperpuestas = new ArrayList<TipoDePrenda>();
	}
	
	public Categoria getCategoria() {
		return this.categoria;
	}
	
	public List<Tela> getTelasAceptables() {
		return this.listadoTelasAceptables;
	}

	public String getDescripcion() {
		return this.descripcion;
	}
	
	public void setPrendasSuperpuestas(List<TipoDePrenda> prendasSuperpuestas) {
		this.prendasSuperpuestas = prendasSuperpuestas;
	}
	
	public List<TipoDePrenda> getPrendasSuperpuestas(){
		return this.prendasSuperpuestas;
	}
	
	public int getCalor() {
		return this.calor;
	}
}
