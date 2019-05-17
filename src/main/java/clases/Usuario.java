package clases;

import java.util.List;

public class Usuario {

	private String nombre;
	List<Guardarropa> guardarropas;
	
	public Usuario(String unNombre) {
		nombre = unNombre;
	}

	public void vestirme(String temporada) 
	{
		
	}
	
	public boolean crearIndumentariaEn(Categoria unaCategoria, TipoDePrenda unTipo, TipoDeTela unaTela , Guardarropa unGuardarropa) {
		if( unaTela.prendasAdmitidas().contains(unTipo.tipo()) && (unTipo.categoriaAdmitida() == unaCategoria.categoria()) ) {
				Prenda ropa = new Prenda(unaCategoria,unTipo,unaTela);
				unGuardarropa.agregarIndumentaria(ropa);
				return true;
		} else { return false; }
	}
	
	public String nombreUsuario() {
		return nombre;
	}
	
}