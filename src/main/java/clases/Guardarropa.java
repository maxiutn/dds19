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
	
	List<Atuendo> listaDeAtuendos = new ArrayList<Atuendo>();
	
	
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
				break;
			case "parteInferior":
				parteInferior.add(d);
				break;
			case "calzado":
				calzado.add(d);
				break;
			case "accesorio":
				accesorio.add(d);
				break;
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
	
	public List<Atuendo> generarSugerencias() {
		if(parteSuperior.isEmpty() || parteInferior.isEmpty() || calzado.isEmpty() || accesorio.isEmpty()) {
			return listaDeAtuendos;
		}
		
		for(Prenda iPS : parteSuperior) {
			for(Prenda iPI : parteInferior) {
				for(Prenda iC : calzado) {
					for(Prenda iA : accesorio) {
						listaDeAtuendos.add(new Atuendo(iPS,iPI,iC,iA));
					}
				}
			}
		}
		return listaDeAtuendos;
	}
	
	public int cantidadDeAtuendos() {
		return listaDeAtuendos.size();
	}
	
	public int tamanioParteSuperior() {
		return parteSuperior.size();
	}
	
	public int tamanioParteInferior() {
		return parteInferior.size();
	}
	
	public int tamanioCalzado() {
		return calzado.size();
	}
	
	public int tamanioAccesorio() {
		return accesorio.size();
	}
	
	public ArrayList<Prenda> parteSuperior() {
		return parteSuperior;
	}
	
	public ArrayList<Prenda> parteInferior() {
		return parteInferior;
	}
}