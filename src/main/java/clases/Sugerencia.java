package clases;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Sugerencia {
	
	I_SugerenciaStrategy sugerencia;

	SugerenciaInvierno sugerenciaInvierno;
	SugerenciaOtonio sugerenciaOtonio;
	SugerenciaPrimavera sugerenciaPrimavera;
	SugerenciaVerano sugerenciaVerano;
	
	public Sugerencia() {
		this.sugerenciaInvierno = new SugerenciaInvierno();
		this.sugerenciaOtonio = new SugerenciaOtonio();
		this.sugerenciaPrimavera = new SugerenciaPrimavera();
		this.sugerenciaVerano = new SugerenciaVerano();
	}
	
	public void realizarSugerencias(Usuario usuario, Evento evento) {
		//System.out.print("Evento:");
		//System.out.println(e.getDescripcion());
		//sugerencia.generarSugerencias(usuario,e);
		generarSugerenciadeEstacion(usuario, evento);
	}

	public void realizarSugerencias(Usuario usuario) {
		List<Evento> listaDeEventos = usuario.getListaEventos();
		
		for(Evento e: listaDeEventos) {
			//System.out.print("Evento:");
			//System.out.println(e.getDescripcion());
			//sugerencia.generarSugerencias(usuario,e);
			generarSugerenciadeEstacion(usuario, e);
		}
	}

	private void generarSugerenciadeEstacion(Usuario usuario, Evento evento) {	
		double t = evento.getTemperatura();
		List<Atuendo> atuendosGenerados  = new ArrayList<Atuendo>();
		
		if(t > -5 && t < 10 ) { // para clima de invierno
			this.sugerencia = this.sugerenciaInvierno;
			atuendosGenerados = this.sugerencia.generarSugerencias(usuario,evento);
			this.asignarSugerenciasAceptadas(atuendosGenerados, evento);
		} else if (t >= 10 && t < 15) { // para clima de otoño
			this.sugerencia = this.sugerenciaOtonio;
			atuendosGenerados = this.sugerenciaOtonio.generarSugerencias(usuario,evento);
			this.asignarSugerenciasAceptadas(atuendosGenerados, evento);
		} else if (t >= 15 && t < 23) { // para clima de primavera
			this.sugerencia = this.sugerenciaPrimavera;
			atuendosGenerados = this.sugerenciaPrimavera.generarSugerencias(usuario,evento);
			this.asignarSugerenciasAceptadas(atuendosGenerados, evento);
		} else { // para clima de verano
			this.sugerencia =  this.sugerenciaVerano;
			atuendosGenerados = this.sugerenciaVerano.generarSugerencias(usuario,evento);
			this.asignarSugerenciasAceptadas(atuendosGenerados, evento);
		}
	}
	
	public void asignarSugerenciasAceptadas(List<Atuendo> unaLista,Evento unEvento) {
		List<Atuendo> atuendosAceptados = new ArrayList<Atuendo>();
		
		if(unEvento.getCondicionDelUsuario().isEmpty()) {
			atuendosAceptados = unaLista;
			unEvento.setSugerenciasAceptadas(atuendosAceptados);
			//System.out.println(unEvento.getSugerenciasAceptadas());
		} else {
			atuendosAceptados = this.escogerAtuendosGeneradosPara(unaLista, unEvento);
			unEvento.setSugerenciasAceptadas(atuendosAceptados);
			//System.out.println(unEvento.getSugerenciasAceptadas());
		}
	}
	
	public List<Atuendo> escogerAtuendosGeneradosPara(List<Atuendo> atuendosGenerados,Evento unEvento) {
		List<Indumentaria> listaCondicionUsuario = unEvento.getCondicionDelUsuario();
		
		return atuendosGenerados.stream().filter(atuendo -> this.cumpleCondicionDelUsuario(atuendo, listaCondicionUsuario)).collect(Collectors.toList());
		
	}
	
	public boolean cumpleCondicionDelUsuario(Atuendo unAtuendo, List<Indumentaria> listaCondIndumentaria) {
		List<Indumentaria> indsAtuendo = unAtuendo.getAtuendo();
		
		return listaCondIndumentaria.stream().allMatch(ic -> this.contieneA(indsAtuendo, ic)); //allMatch porque quiero que todas las condiciones matchee con el atuendo
	}
	
	//metodo para saber si en el atuendo se encuentra la indumentaria condicional
	public boolean contieneA(List<Indumentaria> indumentariasAtuendo,Indumentaria indCondicion) {
		
		return this.contieneTipoDePrenda(indumentariasAtuendo, indCondicion) && this.contieneTela(indumentariasAtuendo, indCondicion) && this.contieneMismoColor(indumentariasAtuendo, indCondicion);
	}
	
	//Tres metodos que devuelven un booleano. Para saber si un atuendo contiene la indumentaria que esta como condicion,
	//se compara toda la indumentaria de los atuendos con la indumentaria de condicion (tipo de prenda,tela y color)  
	
	public boolean contieneTipoDePrenda(List<Indumentaria> indsAtuendo, Indumentaria ic) {
		return indsAtuendo.stream().map(ia -> ia.getTipoDePrenda().getDescripcion()).collect(Collectors.toList()).contains(ic.getTipoDePrenda().getDescripcion());
	}
	
	public boolean contieneTela(List<Indumentaria> indsAtuendo, Indumentaria ic) {
		return indsAtuendo.stream().map(ia -> ia.getTela().getDescripcion()).collect(Collectors.toList()).contains(ic.getTela().getDescripcion());
	}
	
	public boolean contieneMismoColor(List<Indumentaria> indsAtuendo, Indumentaria ic) {
		return indsAtuendo.stream().map(ia -> ia.getColorPrimario()).collect(Collectors.toList()).contains(ic.getColorPrimario());
	}
}
