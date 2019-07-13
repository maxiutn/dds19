package clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SugerenciaVerano extends SugerenciaStrategy{

	
	public SugerenciaVerano() {
		this.temperaturaAdecuada = 50;		
	}
	
	public void generarSugerencias(Usuario usuario){
		
		List<Atuendo> listaAtuendos = new ArrayList<Atuendo>();
		List<Guardarropa> listGuardarropas = usuario.guardarropas();
		
		for(Guardarropa g: listGuardarropas){			
			for(Indumentaria is: g.getIndumentariasSuperior()) {
				for(Indumentaria ii: g.getIndumentariasInferior()) {
					for(Indumentaria c: g.getIndumentariasCalzado()) {
						listaAtuendos.add(new Atuendo(g,Arrays.asList(is),ii,c));
						for(Indumentaria a: g.getIndumentariasAccesorio()) {
							listaAtuendos.add(new Atuendo(g,Arrays.asList(is),ii,c,a));
						}
					}
				}
			}
		}
		
		for(Atuendo a: listaAtuendos) {
			System.out.println(a.toString());
		}
	}
}
