package clases;

public class TipoDePrenda {
	
	private String tipo;
	private String categoriaAdecuada;
	
	public TipoDePrenda(String unTipo,String ca) {
		tipo = unTipo;
		categoriaAdecuada = ca;
	}
	
	public String tipo() {
		return tipo;
	}
	
	public String categoriaAdecuada() {
		return categoriaAdecuada;
	}

}
