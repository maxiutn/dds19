package clases;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	List<Guardarropa> guardarropas = new ArrayList<Guardarropa>();
	List<List<Atuendo>> listaDeSugerencias = new ArrayList<List<Atuendo>>();
	
	public Usuario() {
		this.crearNuevoGuardarropa();								// Automaticamente, cuando se crea un usuario, tiene un guardarropa disponible
	}

	public void vestirme(String temporada) 
	{
	}
	
	public void crear_GuardarIndumentariaEn(TipoDePrenda tp, TipoDeTela tl, Categoria c, String cp, String cs, int guardarropa) {
		if(c.coincideCon(tp) && tl.coincideCon(tp) && cp != cs) {
			Prenda i = new Prenda(tp,tl,c,cp);
			Guardarropa g = guardarropas.get(guardarropa);
			if(!g.hayIndumentariaDelMismoColor(c.categoria(),tp.tipo(),cp)) {
				i.cambiarDeColor(cp);
				g.guardar(i);
			}
			else {
				i.cambiarDeColor(cs);
				g.guardar(i);
			}
		}
	}
	
	public List<List<Atuendo>> solicitarSugerenciasGuardarropas() {
		for(int i = 0 ; i < guardarropas.size() ; i++) {
			Guardarropa g = guardarropas.get(i);
			listaDeSugerencias.add(g.generarSugerencias());
		}
		return listaDeSugerencias;
	}
	
	public void crearNuevoGuardarropa() {
		guardarropas.add(new Guardarropa());
	}
	
	public int cantidadDeGuardarropas() {
		return guardarropas.size();
	}
	
	public List<Guardarropa> guardarropas() {
		return guardarropas;
	}
}