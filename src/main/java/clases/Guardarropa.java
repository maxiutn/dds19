package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guardarropa {

	private List<Sugerencia> sugerencias;

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

}