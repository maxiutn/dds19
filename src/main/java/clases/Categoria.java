package clases;

public class Categoria {
	
private String categoria;
	
	public Categoria(String unaCategoria) {
		categoria = unaCategoria;
	}
	
	public String categoria() {
		return categoria;
	}
	
	public boolean coincideCon(TipoDePrenda unTipo) {
		return categoria == unTipo.categoriaAdecuada();
	}

}
