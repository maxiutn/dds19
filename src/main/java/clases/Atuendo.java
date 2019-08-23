package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Atuendo {
	
	private String perteneceA;
	private String atuendoPara;
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
	
	public Atuendo(List<Indumentaria> ps, Indumentaria pi, Indumentaria c, Indumentaria accs) {
		this.parteSuperior = ps;
		this.parteInferior = pi;
		this.calzado = c;
		this.accesorio = accs;
	}
	
	public Atuendo(List<Indumentaria> ps, Indumentaria pi, Indumentaria c) {
		this.parteSuperior = ps;
		this.parteInferior = pi;
		this.calzado = c;
	}
	
	public String getPerteneceA() {
		return this.perteneceA;
	}
	
	public void setPerteneceA(Guardarropa unGuardarropa) {
		this.perteneceA = unGuardarropa.getDescripcion();
	}
	
	public String getAtuendoPara() {
		return this.atuendoPara;
	}
	
	public void setAtuendoPara(Evento unEvento) {
		this.atuendoPara = unEvento.getDescripcion();
	}
	
	public List<Indumentaria> getAtuendo() { //para que me devuelva una lista con las indumentarias que forman el atuendo
		List<Indumentaria> atuendo = new ArrayList<Indumentaria>();
		
		atuendo.addAll(parteSuperior);
		atuendo.add(parteInferior);
		atuendo.add(calzado);
		if(this.accesorio != null) {
			atuendo.add(accesorio);
		}
		return atuendo;
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
		
		String valor  =  "Atuendo [guardarropa=" + this.getPerteneceA() + ", atuendoPara=" + this.getAtuendoPara() + ", parteSuperior=" + this.parteSuperior + ", parteInferior=" + this.parteInferior.toString() + ", calzado=" + calzado.toString();
				
		if(accesorio != null) {
			valor = valor + ",accesorio=" + accesorio.toString() +"]";
		}else {
			valor = valor + ",accesorio= null]";
		}
		return valor;
	}
}