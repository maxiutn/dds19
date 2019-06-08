package clases;

public class Prenda {

	public TipoDePrenda tipoDePrenda;
	public TipoDeTela tipoDeTela;
	public Categoria categoria;
	public String color;
	
	public Prenda(TipoDePrenda unTipo, TipoDeTela otroTipo, Categoria unaCategoria, String unColor ) {
		tipoDePrenda = unTipo;
		tipoDeTela = otroTipo;
		categoria = unaCategoria;
		color = unColor;
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
