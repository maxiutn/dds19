package clases;

import java.util.List;
import java.util.stream.Collectors;

public class Atuendo {
	
	private Guardarropa guardarropa;
	private List<Indumentaria> parteSuperior;
	private Indumentaria parteInferior;
	private Indumentaria calzado;
	private Indumentaria accesorio;
	
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
	
	public List<String> getParteSuperior() {
		return this.parteSuperior.stream().map(ps -> ps.getObservacion()).collect(Collectors.toList());
	}
	
	public String getParteInferior() {
		return this.parteInferior.getObservacion();
	}
	
	public String getCalzado() {
		return this.calzado.getObservacion();
	}
	
	public String getAccesorio() {
		return this.accesorio.getObservacion();
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