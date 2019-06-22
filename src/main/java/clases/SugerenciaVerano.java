package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SugerenciaVerano extends SugerenciaStrategy{

	
	public SugerenciaVerano() {
		this.temperaturaAdecuada = 50;		
	}
	
	public void generarSugerencias(Usuario usuario){
		List<Atuendo> listaAtuendos = new ArrayList<Atuendo>();
		List<Guardarropa> listGuardarropas = usuario.guardarropas();
		for(Guardarropa g: listGuardarropas){			
			for(Indumentaria is: g.getIndumentariasSuperior()) {
				List<Indumentaria> prendasSuperpuestas = new ArrayList<Indumentaria>();
				if(is.getTipoDePrenda().puedeSuperponerse()) {					
					prendasSuperpuestas = g.getIndumentarias().stream().filter(i -> is.getTipoDePrenda().getPrendasSuperpuestas().contains(i.getTipoDePrenda())).collect(Collectors.toList());
				}
				
				for(Indumentaria ii: g.getIndumentariasInferior()) {
					for(Indumentaria c: g.getIndumentariasCalzado()) {
						
						List<Indumentaria> ps = new ArrayList<Indumentaria>();
						ps.add(is);
						listaAtuendos.add(new Atuendo(g,ps,ii,c));
						
						for(Indumentaria i: prendasSuperpuestas) {
							List<Indumentaria> psup = new ArrayList<Indumentaria>();
							psup.add(is);
							int calorTotal = psup.stream().mapToInt(ind -> ind.getTipoDePrenda().getCalor()).sum();
							if(calorTotal + i.getTipoDePrenda().getCalor() < this.temperaturaAdecuada) {
								psup.add(i);
								listaAtuendos.add(new Atuendo(g,psup,ii,c));
							}
						}
						
						for(Indumentaria a: g.getIndumentariasAccesorio()) {
							
							List<Indumentaria> p = new ArrayList<Indumentaria>();
							p.add(is);
							listaAtuendos.add(new Atuendo(g,p,ii,c,a));
							
							for(Indumentaria i: prendasSuperpuestas) {
								List<Indumentaria> psup = new ArrayList<Indumentaria>();
								psup.add(is);
								int calorTotal = psup.stream().mapToInt(ind -> ind.getTipoDePrenda().getCalor()).sum();
								if(calorTotal + i.getTipoDePrenda().getCalor() < this.temperaturaAdecuada) {
									psup.add(i);
									listaAtuendos.add(new Atuendo(g,psup,ii,c,a));
								}
							}
							
							
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
