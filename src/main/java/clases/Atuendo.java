package clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Atuendo {
	
	private Prenda parteSuperior;
	private Prenda parteInferior;
	private Prenda calzado;
	private Prenda accesorio;
	
	List<String> infoAtuendo = new ArrayList<String>();
	
	public Atuendo(Prenda ps, Prenda pi, Prenda c, Prenda accs) {
		parteSuperior = ps;
		parteInferior = pi;
		calzado = c;
		accesorio = accs;
		infoAtuendo = Arrays.asList(parteSuperior.tipoDePrenda(),parteInferior.tipoDePrenda(),calzado.tipoDePrenda(),accesorio.tipoDePrenda());
	}
	
	public List<String> infoAtuendo() {
		return infoAtuendo;
	}
	
	public String parteSuperior() {
		return parteSuperior.tipoDePrenda();
	}
	
	public String parteInferior() {
		return parteInferior.tipoDePrenda();
	}
	
	public String calzado() {
		return calzado.tipoDePrenda();
	}
	
	public String accesorio() {
		return accesorio.tipoDePrenda();
	}

}
