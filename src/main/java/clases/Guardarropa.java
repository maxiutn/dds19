package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guardarropa {

	private List<Sugerencia> sugerencias;
	
	private ArrayList<Prenda> prendasTorso = new ArrayList<Prenda>();
	private ArrayList<Prenda> prendasPiernas = new ArrayList<Prenda>();
	private ArrayList<Prenda> calzados = new ArrayList<Prenda>();
	private ArrayList<Prenda> accesorios = new ArrayList<Prenda>();

	public Guardarropa() {
		super();
		sugerencias = new ArrayList<Sugerencia>();

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
	
	
	public void agregarIndumentaria(Prenda unaIndumentaria) {
		switch(unaIndumentaria.categoria().categoria())
		{
		case "torso" :
			prendasTorso.add(unaIndumentaria);
		case "piernas" :
			prendasPiernas.add(unaIndumentaria);
		case "calzado" :
			calzados.add(unaIndumentaria);
		case "accesorio" :
			accesorios.add(unaIndumentaria);
		}
	}
	
	public ArrayList<Prenda> prendasTorso() {
		return prendasTorso;
	}
	
	public ArrayList<Prenda> prendasPiernas() {
		return prendasPiernas;
	}
	
	public ArrayList<Prenda> calzados() {
		return calzados;
	}
	
	public ArrayList<Prenda> accesorios() {
		return accesorios;
	}
}