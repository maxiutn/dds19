package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guardarropa {

	private List<Sugerencia> sugerencias;
	
	ArrayList<Prenda> parteSuperior = new ArrayList<Prenda>();
	ArrayList<Prenda> parteInferior = new ArrayList<Prenda>();
	ArrayList<Prenda> calzado = new ArrayList<Prenda>();
	ArrayList<Prenda> accesorio = new ArrayList<Prenda>();
	
	
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
	
	public void guardar(Prenda d) {
		switch(d.categoria()) {
			case "parteSuperior":
				parteSuperior.add(d);
			case "parteInferior":
				parteInferior.add(d);
			case "calzado":
				calzado.add(d);
			case "accesorio":
				accesorio.add(d);
		}
	}
	
	public boolean hayIndumentariaDelMismoColor(String c,String tp,String cp) {
		switch(c) {
			case "parteSuperior":
				return parteSuperior.stream().filter(i -> i.tipoDePrenda() == tp).anyMatch( p -> p.color() == cp);
			case "parteInferior":
				return parteInferior.stream().filter(i -> i.tipoDePrenda() == tp).anyMatch( p -> p.color() == cp);
			case "calzado":
				return calzado.stream().filter(i -> i.tipoDePrenda() == tp).anyMatch( p -> p.color() == cp);
			case "accesorio":
				return accesorio.stream().filter(i -> i.tipoDePrenda() == tp).anyMatch( p -> p.color() == cp);
			default:
				return false;
		}
	}
}