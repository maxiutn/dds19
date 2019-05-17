package clases;

public class Prenda {

	private Categoria categoria;
	private TipoDePrenda tipoDePrenda;
	private TipoDeTela tipoDeTela; 
	
	public Prenda(Categoria unaCategoria, TipoDePrenda unTipo, TipoDeTela unaTela) {
		categoria = unaCategoria;
		tipoDePrenda = unTipo;
		tipoDeTela = unaTela;
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

}
