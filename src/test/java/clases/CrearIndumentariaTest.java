package clases;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

public class CrearIndumentariaTest {
	
	// Categorias
	
		Categoria parteSuperior = new Categoria("parteSuperior");
		Categoria parteInferior = new Categoria("parteInferior");
		Categoria calzado = new Categoria("calzado");
		Categoria accesorio = new Categoria("accesorio");
		
		// Tipo de Telas
		
		TipoDeTela algodon = new TipoDeTela(Arrays.asList("remera","pantalon","chomba","shorts"));
		TipoDeTela laycra = new TipoDeTela(Arrays.asList(""));
		TipoDeTela modal = new TipoDeTela(Arrays.asList(""));
		TipoDeTela cuero = new TipoDeTela(Arrays.asList("campera","botas","pantalon"));
		TipoDeTela plastico = new TipoDeTela(Arrays.asList("anteojosDeSol"));
		
		// Tipo de Prendas
		
			// Parte Superior
			TipoDePrenda camisaMangaCorta = new TipoDePrenda("camisaMangaCorta","parteSuperior");
			TipoDePrenda chomba = new TipoDePrenda("chomba","parteSuperior");
			TipoDePrenda remera = new TipoDePrenda("remera","parteSuperior");
		
			// Parte Inferior
			TipoDePrenda pantalon = new TipoDePrenda("pantalon","parteInferior");
			TipoDePrenda shorts = new TipoDePrenda("shorts","parteInferior");
		
			// Calzado
			TipoDePrenda zapatilla = new TipoDePrenda("zapatilla","calzado");
			TipoDePrenda botas = new TipoDePrenda("botas","calzado");
			TipoDePrenda sandalias = new TipoDePrenda("sandalias","calzado");
		
			// Accesorios
			TipoDePrenda anteojosDeSol = new TipoDePrenda("anteojosDeSol","accesorio");
		
		// Usuarios
		
		Usuario usuario1 = new Usuario();
		
		
		@Test
		public void crearGuardarropa() {
			usuario1.crearNuevoGuardarropa();
			assertEquals(usuario1.cantidadDeGuardarropas() , 2);
		}
		
		@Test
		public void crearPrendaCorrecta1() {
			usuario1.crear_GuardarIndumentariaEn(remera, algodon, parteSuperior, "rojo", "azul", 0);
			Guardarropa g = usuario1.guardarropas().get(0);
			assertTrue(g.hayIndumentariaDelMismoColor("parteSuperior","remera","rojo"));
		}
		
		@Test
		public void crearPrendaCorrecta2() {
			usuario1.crear_GuardarIndumentariaEn(shorts, algodon, parteInferior, "verde", "negro", 0);
			Guardarropa g = usuario1.guardarropas().get(0);
			assertTrue(g.hayIndumentariaDelMismoColor("parteInferior","shorts","verde"));
		}
		
		@Test
		public void crearPrendaCorrecta3() {
			usuario1.crear_GuardarIndumentariaEn(botas, cuero, calzado, "azulOscuro", "negro", 0);
			Guardarropa g = usuario1.guardarropas().get(0);
			assertTrue(g.hayIndumentariaDelMismoColor("calzado","botas","azulOscuro"));
		}
		
		@Test
		public void crearPrendaCorrecta4() {
			usuario1.crear_GuardarIndumentariaEn(anteojosDeSol, plastico, accesorio, "negro", "rojo", 0);
			Guardarropa g = usuario1.guardarropas().get(0);
			assertTrue(g.hayIndumentariaDelMismoColor("accesorio","anteojosDeSol","negro"));
		}
		
		@Test
		public void crearPrendaIncorrecta() {
			usuario1.crear_GuardarIndumentariaEn(remera, cuero, parteSuperior, "rojo", "azul", 0);
			Guardarropa g = usuario1.guardarropas().get(0);
			assertFalse(g.hayIndumentariaDelMismoColor("parteSuperior","remera","rojo"));
		}
		
		@Test 
		public void crearPrendaDeColorSecundario() {
			Guardarropa g = usuario1.guardarropas().get(0);
			Prenda ind1 = new Prenda(remera, algodon, parteSuperior, "rojo");
			g.guardar(ind1);
			usuario1.crear_GuardarIndumentariaEn(remera, algodon, parteSuperior, "rojo", "azul", 0);
			assertTrue(g.hayIndumentariaDelMismoColor("parteSuperior", "remera", "azul"));
	}
}
