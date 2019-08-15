package clases;

import java.util.List;

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

	public void realizarSugerencias(Usuario usuario) {
		
		List<Evento> listaDeEventos = usuario.getListaEventos();
		
		for(Evento e: listaDeEventos) {
			//System.out.print("Evento:");
			//System.out.println(e.getDescripcion());
			//sugerencia.generarSugerencias(usuario,e);
			double t = e.getTemperatura();
			if(t > -5 && t < 10 ) {
				this.sugerencia = this.sugerenciaInvierno;
				this.sugerencia.generarSugerencias(usuario);
			} else if (t >= 10 && t < 15) {
				this.sugerencia = this.sugerenciaOtonio;
				this.sugerenciaOtonio.generarSugerencias(usuario);
			} else if (t >= 15 && t < 23) {
				this.sugerencia = this.sugerenciaPrimavera;
				this.sugerenciaPrimavera.generarSugerencias(usuario);
			} else {
				this.sugerencia =  this.sugerenciaVerano;
				this.sugerenciaVerano.generarSugerencias(usuario);
			}
		}
	}
}
