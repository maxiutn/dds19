package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Usuario {

	private String nombre;
	
	List<Guardarropa> guardarropas = new ArrayList<Guardarropa>();
	
	public Usuario(String unNombre) {
		nombre = unNombre;
		this.crearGuardarropa(1); 								// Automaticamente, cuando se crea un usuario, tiene un guardarropa disponible
	}

	public void vestirme(String temporada) 
	{
	}
	
	public void crearIndumentariaEn(Categoria unaCategoria, TipoDePrenda unTipoDePrenda, TipoDeTela unaTela , String colorP, String colorS,  int unIDGuardarropa) {
		if( unaTela.coincideConElTipoDePrenda(unTipoDePrenda) && unaCategoria.coincideConElTipoDePrenda(unTipoDePrenda) && colorP != colorS ) {
				Iterator<Guardarropa> it = guardarropas.iterator();
				while(it.hasNext()) {
					Guardarropa guardarropa = it.next();
					if(guardarropa.getIdGuardarropa() == unIDGuardarropa)
						if(!guardarropa.hayPrendaDelMismoColor(unTipoDePrenda, colorP)) // Si no hay una prenda del color principal, entonces crea la prenda de ese color
							guardarropa.agregarIndumentaria(new Prenda(unaCategoria,unTipoDePrenda,unaTela,colorP));
						else if (!guardarropa.hayPrendaDelMismoColor(unTipoDePrenda, colorS)) // Si hay una prenda con el color principal, entonces  analizamos si hay del color secundario. Si no hay, lo creamos
							guardarropa.agregarIndumentaria(new Prenda(unaCategoria,unTipoDePrenda,unaTela,colorS));
						else { } // Si ya hay prendas con el color secundario y principal, entonces no agrega nada
					break;
				}
		}
	}
	
	public void crearGuardarropa(int unID) {
		guardarropas.add(new Guardarropa(unID));
	}
	
	public int cantidadDeGuardarropas() {
		return guardarropas.size(); 
	}
	
	public List<Guardarropa> getGuardarropas() {
		return guardarropas;
	}
	
	public Guardarropa accederAlGuardarropaNro(int index) {
		return guardarropas.get(index);
	}
}