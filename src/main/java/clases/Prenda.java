package clases;

public class Prenda {

	private Categoria categoria;
	private TipoDePrenda tipoDePrenda;
	private TipoDeTela tipoDeTela;
	private String colorPrincipal;
	
	public Prenda(Categoria unaCategoria, TipoDePrenda unTipo, TipoDeTela unaTela, String unColor) {
		categoria = unaCategoria;
		tipoDePrenda = unTipo;
		tipoDeTela = unaTela;
		colorPrincipal = unColor;
	}
	
	public Categoria categoria() {
		return categoria;
	}
	
	public TipoDePrenda tipoDePrenda() {
		return tipoDePrenda;
	}
	
	public TipoDeTela tipoDeTela() {
		return tipoDeTela;
	}
	
	public String colorPrincipal() {
		return colorPrincipal;
	}

}
