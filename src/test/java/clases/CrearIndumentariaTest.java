package clases;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert.*;

import junit.framework.TestCase;

public class CrearIndumentariaTest {
	
	//Usuarios
	Usuario paco = new Usuario("paco");
			
	// Guardarropas
	Guardarropa guardarropa = new Guardarropa(); 
			
	//Categorias
	Categoria torso = new Categoria("torso");
	Categoria piernas = new Categoria("piernas");
	Categoria calzado = new Categoria("calzado");
	Categoria accesorio = new Categoria("accesorio");
			
	//Telas
	TipoDeTela algodon = new TipoDeTela("algodon");
	TipoDeTela laycra = new TipoDeTela("laycra");
	TipoDeTela modal = new TipoDeTela("modal");
	TipoDeTela cuero = new TipoDeTela("cuero");
			
	//Tipo de Prendas
	TipoDePrenda remera = new TipoDePrenda("remera","torso");
	TipoDePrenda pantalon = new TipoDePrenda("pantalon","piernas");
	TipoDePrenda sandalias = new TipoDePrenda("sandalias","calzado");
	TipoDePrenda anteojosDeSol = new TipoDePrenda("anteojosDeSol","accesorio");
			
			
	@Test
	public void crearPrenda() {
		algodon.agregarPrendaAdmitida("remera");
		algodon.agregarPrendaAdmitida("pantalon");
		assertTrue(paco.crearIndumentariaEn(torso, remera, algodon, guardarropa));
	}
			
	@Test
	public void seGuardoEnElGuardarropas() {
		algodon.agregarPrendaAdmitida("remera");
		algodon.agregarPrendaAdmitida("pantalon");
		paco.crearIndumentariaEn(torso, remera, algodon, guardarropa);
		assertEquals(guardarropa.prendasTorso().size() , 1);
	}
			
	@Test
	public void crearPrendaErronea() {
		cuero.agregarPrendaAdmitida("campera");
		assertFalse(paco.crearIndumentariaEn(torso, remera, cuero, guardarropa));
	}

}
