package clases;

public class Categoria {
	
	private String categoria;
	
	public Categoria(String unaCategoria) {
		categoria = unaCategoria;
	}
	
	public boolean coincideConElTipoDePrenda(TipoDePrenda unTipo) {
		return categoria == unTipo.categoriaAdmitida();
	}
	
	public String categoria () {
		return categoria;
	}

}
