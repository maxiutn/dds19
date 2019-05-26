package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guardarropa {
	
	private int idGuardarropa;

	private List<Sugerencia> sugerencias;
	
	private ArrayList<Prenda> listaDeIndumentarias = new ArrayList<Prenda>();
	
	
	public Guardarropa(int unID) {
		super();
		sugerencias = new ArrayList<Sugerencia>();
		idGuardarropa = unID;

	}

	public List<Sugerencia> getSugerencias() {
		return sugerencias;
	}

	public void setSugerencias(List<Sugerencia> sugerencias) {
		this.sugerencias = sugerencias;
	}

	public List<Sugerencia> sugerime(String temporada) {
		List<Sugerencia> lista = sugerencias.stream().filter(s -> s.temporada.equals(temporada))
				.collect(Collectors.toList());
		return lista;
	}

	public void agregarSugerencia(Sugerencia sugerencia) {
		this.getSugerencias().add(sugerencia);
	}
	
	public ArrayList<Prenda> getIndumentarias() {
		return listaDeIndumentarias;
	}
	
	public void agregarIndumentaria(Prenda unaIndumentaria) {
		listaDeIndumentarias.add(unaIndumentaria);
	}
	
	public boolean hayPrendaDelMismoColor(TipoDePrenda unTipo,String color) { //Verifica si hay una prenda con ese color
		return listaDeIndumentarias.stream().filter(prenda -> this.sonDelMismoTipo(prenda, unTipo) ).map(p -> p.colorPrincipal()).collect(Collectors.toList()).contains(color);
	}
	
	public boolean sonDelMismoTipo(Prenda unaPrenda, TipoDePrenda unTipo) {
		return unaPrenda.tipoDePrenda().tipo() == unTipo.tipo();
	}
	
	public int getIdGuardarropa() {
		return idGuardarropa;
	}
}