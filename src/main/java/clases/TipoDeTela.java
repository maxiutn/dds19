package clases;

import java.util.ArrayList;

public class TipoDeTela {
	
	private String tela;
	private ArrayList<String> prendasAdmitidas = new ArrayList<String>(); // Listado de prendas que pueden ir con el tipo de tela
	
	public TipoDeTela(String unaTela) {
		tela = unaTela;
	}
	
	public void agregarPrendaAdmitida(String unaPrenda) {
		prendasAdmitidas.add(unaPrenda);
	}
	
	public String tipoDeTela() {
		return tela;
	}
	
	public ArrayList<String> prendasAdmitidas() {
		return prendasAdmitidas;
	}
	
	public boolean coincideConElTipoDePrenda(TipoDePrenda unaPrenda) {
		return prendasAdmitidas.contains(unaPrenda.tipo());
	}

}
