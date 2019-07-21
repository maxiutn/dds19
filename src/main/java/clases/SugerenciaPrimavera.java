package clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SugerenciaPrimavera{

	List<List<Indumentaria>> listaPrendasSuperiorAnidadas = new ArrayList<List<Indumentaria>>();
	
	public void generarSugerencias(Usuario usuario) {
		List<Atuendo> listaAtuendos = new ArrayList<Atuendo>();
		List<Guardarropa> listGuardarropas = usuario.guardarropas();
		
		for(Guardarropa g: listGuardarropas){
			this.generarPrendasAnidadas(g);
			for(int i = 0 ; i < this.listaPrendasSuperiorAnidadas.size() ; i++) {
				List<Indumentaria> prendaAnidada = listaPrendasSuperiorAnidadas.get(i);
				for(Indumentaria ii: g.getIndumentariasInferior()) {
					for(Indumentaria c: g.getIndumentariasCalzado()) {
						listaAtuendos.add(new Atuendo(g,prendaAnidada,ii,c));
						for(Indumentaria a: g.getIndumentariasAccesorio()) {
							listaAtuendos.add(new Atuendo(g,prendaAnidada,ii,c,a));
						}
					}
				}
			}
		}
		
		for(Atuendo a: listaAtuendos) {
			System.out.println(a.toString());
		}
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
}
