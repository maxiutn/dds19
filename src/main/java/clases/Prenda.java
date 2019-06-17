package clases;

public class Prenda {

	public TipoDePrenda tipoDePrenda;
	public Categoria categoria;
	public TipoDeTela tipoDeTela;
	public String color;
	public String descripcion;
	
	public Prenda(TipoDePrenda unTipo, TipoDeTela otroTipo, Categoria unaCategoria, String unColor ) {
		tipoDePrenda = unTipo;
		tipoDeTela = otroTipo;
		categoria = unaCategoria;
		color = unColor;
	}
	
	public Prenda(String descripcion, TipoDePrenda unTipo, TipoDeTela otroTipo, Categoria unaCategoria, String unColor ) {
		this.descripcion = descripcion;
		tipoDePrenda = unTipo;
		tipoDeTela = otroTipo;
		categoria = unaCategoria;
		color = unColor;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public void cambiarDeColor(String otroColor) {
		color = otroColor;
	}
	
	public String categoria() {
		return categoria.categoria();
	}
	
	public String tipoDePrenda() {
		return tipoDePrenda.tipo();
	}
	
	public String color() {
		return color;
	}

}
