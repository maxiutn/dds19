package clases;

import java.util.ArrayList;
import java.util.List;

public class TipoDeTela {
	
	private List<String> prendasAdmitidas = new ArrayList<String>(); // Listado de prendas que pueden ir con el tipo de tela
	
	public TipoDeTela(List<String> prendasCorrectas) {
		prendasAdmitidas = prendasCorrectas;
	}
	
	public List<String> prendasAdmitidas() {
		return prendasAdmitidas;
	}
	
	public boolean coincideCon(TipoDePrenda unaPrenda) {
		return prendasAdmitidas.contains(unaPrenda.tipo());
	}
}
