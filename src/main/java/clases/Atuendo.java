package clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Atuendo {
	
	private Guardarropa guardarropa;
	private List<Indumentaria> parteSuperior;
	private Indumentaria parteInferior;
	private Indumentaria calzado;
	private Indumentaria accesorio;
	
	//List<String> infoAtuendo = new ArrayList<String>();
	/*
	public Atuendo(Guardarropa g,Indumentaria ps, Indumentaria pi, Indumentaria c, Indumentaria accs) {
		this.guardarropa = g;
		this.parteSuperior = ps;
		this.parteInferior = pi;
		this.calzado = c;
		this.accesorio = accs;
		//infoAtuendo = Arrays.asList(parteSuperior.tipoDePrenda(),parteInferior.tipoDePrenda(),calzado.tipoDePrenda(),accesorio.tipoDePrenda());
	}*/
	
	/*
	public Atuendo(Guardarropa g, Indumentaria ps, Indumentaria pi, Indumentaria c) {
		this.guardarropa = g;
		this.parteSuperior = ps;
		this.parteInferior = pi;
		this.calzado = c;
	}*/
	
	public Atuendo(Guardarropa g,List<Indumentaria> ps, Indumentaria pi, Indumentaria c, Indumentaria accs) {
		this.guardarropa = g;
		this.parteSuperior = ps;
		this.parteInferior = pi;
		this.calzado = c;
		this.accesorio = accs;
	}
	
	public Atuendo(Guardarropa g, List<Indumentaria> ps, Indumentaria pi, Indumentaria c) {
		this.guardarropa = g;
		this.parteSuperior = ps;
		this.parteInferior = pi;
		this.calzado = c;
	}
	
	
	@Override
	public String toString() {
		
		String listado = "";
		for(Indumentaria i: parteSuperior) {
			listado = listado + i.toString();
		}
		
		String valor  =  "Atuendo [guardarropa=" + guardarropa.toString() + ", parteSuperior=" + listado + ", parteInferior=" + parteInferior.toString() + ", calzado=" + calzado.toString();
				
		if(accesorio != null) {
			valor = valor + ",accesorio=" + accesorio.toString() +"]";
		}else {
			valor = valor + ",accesorio= null]";
		}
		
		return valor;
	}

}

//+ ", accesorio=" + accesorio.toString() + 