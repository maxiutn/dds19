package clases;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.stream.Collectors;

import org.junit.Assert.*;

import junit.framework.TestCase;

public class CrearIndumentariaTest {
	
	//Usuarios
	Usuario usuario1 = new Usuario("Usuario1");
			
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
	public void crearGuardarropa() {
		usuario1.crearGuardarropa(2);
		assertEquals(usuario1.cantidadDeGuardarropas() , 2);
	}
	
	@Test
	public void crearPrendaCorrecta() {
		algodon.agregarPrendaAdmitida("remera");
		algodon.agregarPrendaAdmitida("pantalon");
		usuario1.crearIndumentariaEn(torso, remera, algodon,"azul","rojo", 1);
		Guardarropa guardarropa = usuario1.accederAlGuardarropaNro(0);
		assertEquals(guardarropa.getIndumentarias().size() , 1);
	}

	@Test
	public void crearPrendaIncorrecta() {
		cuero.agregarPrendaAdmitida("campera");
		algodon.agregarPrendaAdmitida("remera");
		usuario1.crearIndumentariaEn(torso, remera, cuero,"azul","rojo", 1);
		Guardarropa guardarropa = usuario1.accederAlGuardarropaNro(0);
		assertEquals(guardarropa.getIndumentarias().size() , 0);
	}
	
	@Test
	public void crearPrendaDeUnColorPrincipal() {
		algodon.agregarPrendaAdmitida("remera");
		usuario1.crearIndumentariaEn(torso, remera, algodon, "rojo", "azul", 1);
		Guardarropa guardarropa = usuario1.accederAlGuardarropaNro(0);
		assertEquals(guardarropa.getIndumentarias().stream().map(p -> p.colorPrincipal()).collect(Collectors.toList()).size() , 1);
	}
	
	@Test
	public void crearPrendaDeUnColorSecundario() {
		algodon.agregarPrendaAdmitida("remera");
		usuario1.crearIndumentariaEn(torso, remera, algodon, "rojo", "azul", 1);
		usuario1.crearIndumentariaEn(torso, remera, algodon, "rojo", "azul", 1);
		Guardarropa guardarropa = usuario1.accederAlGuardarropaNro(0);
		assertEquals(guardarropa.getIndumentarias().stream().map(p -> p.colorPrincipal()).filter(p -> p == "azul").collect(Collectors.toList()).size() , 1);
	}
	
	@Test
	public void crearPrendaDeUnColorYaRepetidoConElPrimarioYSecundario() {
		algodon.agregarPrendaAdmitida("remera");
		usuario1.crearIndumentariaEn(torso, remera, algodon, "rojo", "azul", 1);
		usuario1.crearIndumentariaEn(torso, remera, algodon, "rojo", "azul", 1);
		usuario1.crearIndumentariaEn(torso, remera, algodon, "rojo", "azul", 1);
		Guardarropa guardarropa = usuario1.accederAlGuardarropaNro(0);
		assertEquals(guardarropa.getIndumentarias().stream().map(p -> p.colorPrincipal()).filter(p -> p == "rojo").collect(Collectors.toList()).size() , 1);
		assertEquals(guardarropa.getIndumentarias().stream().map(p -> p.colorPrincipal()).filter(p -> p == "azul").collect(Collectors.toList()).size() , 1);
	}
	
	@Test
	public void crearPrendaDeColoresIguales() {
		algodon.agregarPrendaAdmitida("remera");
		usuario1.crearIndumentariaEn(torso, remera, algodon, "rojo", "rojo", 1);
		Guardarropa guardarropa = usuario1.accederAlGuardarropaNro(0);
		assertEquals(guardarropa.getIndumentarias().size() , 0);
	}
}
