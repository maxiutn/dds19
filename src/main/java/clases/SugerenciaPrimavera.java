package clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SugerenciaPrimavera implements I_SugerenciaStrategy{

	List<List<Indumentaria>> listaPrendasSuperiorAnidadas;
	
	public List<Atuendo> generarSugerencias(Usuario usuario,Evento unEvento) {
		
			this.listaPrendasSuperiorAnidadas = new ArrayList<List<Indumentaria>>();
			List<Atuendo> listaAtuendos = new ArrayList<Atuendo>();
			List<Guardarropa> listGuardarropas = usuario.guardarropas();
		
			for(Guardarropa g: listGuardarropas){
				this.generarPrendasAnidadas(g);
				for(List<Indumentaria> prendasSuperpuestas : this.getListaPrendasSuperiorAnidadas()) {
					for(Indumentaria ii: g.getIndumentariasInferior()) {
						for(Indumentaria c: g.getIndumentariasCalzado()) {
							Atuendo atuendoSinAccesorio = new Atuendo(prendasSuperpuestas,ii,c);
							atuendoSinAccesorio.setPerteneceA(g);
							atuendoSinAccesorio.setAtuendoPara(unEvento);
							listaAtuendos.add(atuendoSinAccesorio);
							for(Indumentaria a: g.getIndumentariasAccesorio()) {
								Atuendo atuendoConAccesorio = new Atuendo(prendasSuperpuestas,ii,c,a);
								atuendoConAccesorio.setPerteneceA(g);
								atuendoConAccesorio.setAtuendoPara(unEvento);
								listaAtuendos.add(atuendoConAccesorio);
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
		List<Indumentaria> parteSuperior3 = g.getIndumentariaSuperiorPorNivelDeCalor(15);
	
		for(Indumentaria i_ps1: parteSuperior1 ) {
				for(Indumentaria i_ps3: parteSuperior3 ) {
						listaPrendasSuperiorAnidadas.add(Arrays.asList(i_ps1,i_ps3));
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
