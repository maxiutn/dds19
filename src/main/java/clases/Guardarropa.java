package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guardarropa {

	private List<Indumentaria> listaIndumentarias;
	private String descripcion;
	private int max_prendas;
	private List<Atuendo> sugerencias;
		
	public Guardarropa(String descripcion) {
		this.descripcion = descripcion;
		this.listaIndumentarias = new ArrayList<Indumentaria>();
		this.sugerencias = new ArrayList<Atuendo>();
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public void agregarIndumentaria(Indumentaria indumentaria) {
		if(this.cantidadIndumentarias() < this.max_prendas || this.max_prendas < 0) {
			this.listaIndumentarias.add(indumentaria);
		}else {
			System.out.println("Solo puede tener "+ this.max_prendas +" prendas.");
		}
	}
	
	public List<Indumentaria> getIndumentarias() {
		return this.listaIndumentarias;
	}	

	public int cantidadIndumentarias() {
		return listaIndumentarias.size();
	}

	public List<Indumentaria> getIndumentariasSuperior(){
		List<Indumentaria> indumentariaSuperior = this.listaIndumentarias.stream().filter(i -> i.getTipoDePrenda().getCategoria().getDescripcion().equalsIgnoreCase("parteSuperior")).collect(Collectors.toList());
		return indumentariaSuperior;
	}
	
	public List<Indumentaria> getIndumentariaSuperiorPorNivelDeCalor(int nc) {
		return this.getIndumentariasSuperior().stream().filter(i -> i.getNivelDeCalor() == nc).collect(Collectors.toList());
	}
	
	public List<Indumentaria> getIndumentariasInferior(){
		List<Indumentaria> indumentariaInferior = this.listaIndumentarias.stream().filter(i -> i.getTipoDePrenda().getCategoria().getDescripcion().equalsIgnoreCase("parteInferior")).collect(Collectors.toList());
		return indumentariaInferior;
	}
	
	public List<Indumentaria> getIndumentariasCalzado(){
		List<Indumentaria> indumentariaCalzado = this.listaIndumentarias.stream().filter(i -> i.getTipoDePrenda().getCategoria().getDescripcion().equalsIgnoreCase("calzado")).collect(Collectors.toList());
		return indumentariaCalzado;
	}
	
	public List<Indumentaria> getIndumentariasAccesorio(){
		List<Indumentaria> indumentariaAccesorio = this.listaIndumentarias.stream().filter(i -> i.getTipoDePrenda().getCategoria().getDescripcion().equalsIgnoreCase("accesorio")).collect(Collectors.toList());
		return indumentariaAccesorio;
	}	
	
	public void setMaximoPrendas(int maximo) {
		this.max_prendas = maximo;
	}
	
	public void agregarAtuendo(Atuendo unAtuendo) {
		this.sugerencias.add(unAtuendo);
	}
	
	public List<Atuendo> getAtuendos() {
		return this.sugerencias;
	}
	
	
	
	@Override
	public String toString() {
		return "Guardarropa [descripcion=" + descripcion + "]";
	}
}