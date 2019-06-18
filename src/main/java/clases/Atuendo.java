package clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Atuendo {
	
	private Guardarropa guardarropa;
	private Indumentaria parteSuperior;
	private Indumentaria parteInferior;
	private Indumentaria calzado;
	private Indumentaria accesorio;
	
	//List<String> infoAtuendo = new ArrayList<String>();
	
	public Atuendo(Guardarropa g,Indumentaria ps, Indumentaria pi, Indumentaria c, Indumentaria accs) {
		this.guardarropa = g;
		this.parteSuperior = ps;
		this.parteInferior = pi;
		this.calzado = c;
		this.accesorio = accs;
		//infoAtuendo = Arrays.asList(parteSuperior.tipoDePrenda(),parteInferior.tipoDePrenda(),calzado.tipoDePrenda(),accesorio.tipoDePrenda());
	}
	
	
	public Atuendo(Guardarropa g, Indumentaria ps, Indumentaria pi, Indumentaria c) {
		this.guardarropa = g;
		this.parteSuperior = ps;
		this.parteInferior = pi;
		this.calzado = c;
	}
	
	@Override
	public String toString() {
		return "Atuendo [guardarropa=" + guardarropa.toString() + ", parteSuperior=" + parteSuperior.toString() + ", parteInferior=" + parteInferior.toString() + ", calzado=" + calzado.toString()
				+ "]";
	}

}

//+ ", accesorio=" + accesorio.toString() + 