package clases;

import java.util.List;

public class TipoDePrenda {
	
	private Categoria categoria;
	private List<Tela> listadoTelasAceptables;
	private String descripcion;
	
	public TipoDePrenda(String descripcion, List<Tela> telas) {
		this.descripcion = descripcion;
		this.listadoTelasAceptables = telas;
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
}
