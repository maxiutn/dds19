package clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SugerenciaInvierno implements I_SugerenciaStrategy {
	
	List<List<Indumentaria>> listaPrendasSuperiorAnidadas;

	public List<Atuendo> generarSugerencias(Usuario usuario){
		
			this.listaPrendasSuperiorAnidadas = new ArrayList<List<Indumentaria>>();
			List<Atuendo> listaAtuendos = new ArrayList<Atuendo>();
			List<Guardarropa> listGuardarropas = usuario.guardarropas();
		
			for(Guardarropa g: listGuardarropas){
				this.generarPrendasAnidadas(g);
				for(List<Indumentaria> prendasSuperpuestas : this.getListaPrendasSuperiorAnidadas()) {
					for(Indumentaria ii: g.getIndumentariasInferior()) {
						for(Indumentaria c: g.getIndumentariasCalzado()) {
							listaAtuendos.add(new Atuendo(g,prendasSuperpuestas,ii,c));
							for(Indumentaria a: g.getIndumentariasAccesorio()) {
								g.agregarAtuendo(new Atuendo(g,prendasSuperpuestas,ii,c,a));
							}
						}
					}
				}
			}
			/*
			for(Atuendo a: listaAtuendos) {
				System.out.println(a.toString());
			}
			*/
			return listaAtuendos;
	}

	public void generarPrendasAnidadas(Guardarropa g) {
	
		List<Indumentaria> parteSuperior1 = g.getIndumentariaSuperiorPorNivelDeCalor(5);
		List<Indumentaria> parteSuperior2 = g.getIndumentariaSuperiorPorNivelDeCalor(10);
		List<Indumentaria> parteSuperior3 = g.getIndumentariaSuperiorPorNivelDeCalor(15);
		List<Indumentaria> parteSuperior4 = g.getIndumentariaSuperiorPorNivelDeCalor(20);
	
		for(Indumentaria i_ps1: parteSuperior1 ) {
			for(Indumentaria i_ps2: parteSuperior2 ) {
				for(Indumentaria i_ps3: parteSuperior3 ) {
					for(Indumentaria i_ps4: parteSuperior4 ) {
						listaPrendasSuperiorAnidadas.add(Arrays.asList(i_ps1,i_ps2,i_ps3,i_ps4));
					}
				}
			}
		}
	}
	
	public List<List<String>> getDescripcionListaPrendasSuperiorAnidadas() {
		return this.listaPrendasSuperiorAnidadas.stream().map( lpa -> lpa.stream().map( pa -> pa.getTipoDePrenda().getDescripcion() ).collect(Collectors.toList())).collect(Collectors.toList());
	}
	
	public List<List <Indumentaria>> getListaPrendasSuperiorAnidadas() {
		return this.listaPrendasSuperiorAnidadas;
	}
	
}
