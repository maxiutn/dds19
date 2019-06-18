package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guardarropa {

	private List<Indumentaria> listaIndumentarias;
	private String descripcion;
		
	public Guardarropa(String descripcion) {
		this.descripcion = descripcion;
		this.listaIndumentarias = new ArrayList<Indumentaria>();
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public void agregarIndumentaria(Indumentaria indumentaria) {
		this.listaIndumentarias.add(indumentaria);
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
	
	@Override
	public String toString() {
		return "Guardarropa [descripcion=" + descripcion + "]";
	}
}