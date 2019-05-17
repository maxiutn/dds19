package clases;

public class TipoDePrenda {
	
	private String tipo;
	private String categoriaAdmitida;
	
	
	public TipoDePrenda(String unTipo, String unaCategoria) {
		tipo = unTipo;
		categoriaAdmitida = unaCategoria;
	}
	
	public String categoriaAdmitida() {
		return categoriaAdmitida;
	}
	
	public String tipo() {
		return tipo;
	}

}
