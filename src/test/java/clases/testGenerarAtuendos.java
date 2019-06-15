package clases;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Test;

public class testGenerarAtuendos {

	// Categorias
	
			Categoria parteSuperior = new Categoria("parteSuperior");
			Categoria parteInferior = new Categoria("parteInferior");
			Categoria calzado = new Categoria("calzado");
			Categoria accesorio = new Categoria("accesorio");
			
			// Tipo de Telas
			
			TipoDeTela algodon = new TipoDeTela(Arrays.asList("remera","pantalon","chomba","camisaMangaCorta","falda"));
			TipoDeTela laycra = new TipoDeTela(Arrays.asList(""));
			TipoDeTela modal = new TipoDeTela(Arrays.asList(""));
			TipoDeTela cuero = new TipoDeTela(Arrays.asList("campera","botas","sandalias"));
			TipoDeTela plastico = new TipoDeTela(Arrays.asList("anteojosDeSol"));
			TipoDeTela batista = new TipoDeTela(Arrays.asList("pañuelo"));
			
			// Tipo de Prendas
			
				// Parte Superior
				TipoDePrenda camisaMangaCorta = new TipoDePrenda("camisaMangaCorta","parteSuperior");
				TipoDePrenda chomba = new TipoDePrenda("chomba","parteSuperior");
				TipoDePrenda remera = new TipoDePrenda("remera","parteSuperior");
			
				// Parte Inferior
				TipoDePrenda pantalon = new TipoDePrenda("pantalon","parteInferior");
				TipoDePrenda shorts = new TipoDePrenda("shorts","parteInferior");
				TipoDePrenda falda = new TipoDePrenda("falda","parteInferior");
			
				// Calzado
				TipoDePrenda zapatilla = new TipoDePrenda("zapatilla","calzado");
				TipoDePrenda botas = new TipoDePrenda("botas","calzado");
				TipoDePrenda sandalias = new TipoDePrenda("sandalias","calzado");
			
				// Accesorios
				TipoDePrenda anteojosDeSol = new TipoDePrenda("anteojosDeSol","accesorio");
				TipoDePrenda panuelo = new TipoDePrenda("pañuelo","accesorio");
			
			// Usuarios
			
			Usuario usuario1 = new Usuario();

		@Test
		public void generarListaVaciaDeAtuendos1() {
			Guardarropa g = usuario1.guardarropas().get(0);
			g.generarSugerencias();
			assertEquals(0 , g.cantidadDeAtuendos());
		}
		
		@Test
		public void generarListaVaciaDeAtuendos2() {
			usuario1.crear_GuardarIndumentariaEn(remera, algodon, parteSuperior, "rojo", "azul", 0);
			Guardarropa g = usuario1.guardarropas().get(0);
			g.generarSugerencias();
			assertEquals(0 , g.cantidadDeAtuendos());
		}
		
		@Test
		public void generarListaVaciaDeAtuendos3() {
			usuario1.crear_GuardarIndumentariaEn(remera, algodon, parteSuperior, "rojo", "azul", 0);
			usuario1.crear_GuardarIndumentariaEn(pantalon, algodon, parteInferior, "negro", "rojo", 0);
			Guardarropa g = usuario1.guardarropas().get(0);
			g.generarSugerencias();
			assertEquals(0 , g.cantidadDeAtuendos());
		}
		
		@Test
		public void generarListaVaciaDeAtuendos4() {
			usuario1.crear_GuardarIndumentariaEn(remera, algodon, parteSuperior, "rojo", "azul", 0);
			usuario1.crear_GuardarIndumentariaEn(pantalon, algodon, parteInferior, "negro", "rojo", 0);
			usuario1.crear_GuardarIndumentariaEn(sandalias, cuero, calzado, "marron", "blanco", 0);
			Guardarropa g = usuario1.guardarropas().get(0);
			g.generarSugerencias();
			assertEquals(0 , g.cantidadDeAtuendos());
		}
		
		@Test
		public void generarUnAtuendo() {
			usuario1.crear_GuardarIndumentariaEn(remera, algodon, parteSuperior, "rojo", "azul", 0);
			usuario1.crear_GuardarIndumentariaEn(pantalon, algodon, parteInferior, "negro", "rojo", 0);
			usuario1.crear_GuardarIndumentariaEn(sandalias, cuero, calzado, "marron", "blanco", 0);
			usuario1.crear_GuardarIndumentariaEn(anteojosDeSol, plastico, accesorio, "negro", "rojo", 0);
			Guardarropa g = usuario1.guardarropas().get(0);
			System.out.println("Test GenerarUnAtuendo:");
			System.out.println(g.generarSugerencias().stream().map( a -> a.infoAtuendo()).collect(Collectors.toList()));
			System.out.println("");
		}
		
		@Test
		public void generarUnAtuendo2() {
			usuario1.crear_GuardarIndumentariaEn(remera, algodon, parteSuperior, "rojo", "azul", 0);
			usuario1.crear_GuardarIndumentariaEn(chomba, algodon, parteSuperior, "rojo", "negro", 0);
			usuario1.crear_GuardarIndumentariaEn(pantalon, algodon, parteInferior, "negro", "rojo", 0);
			usuario1.crear_GuardarIndumentariaEn(sandalias, cuero, calzado, "marron", "blanco", 0);
			usuario1.crear_GuardarIndumentariaEn(anteojosDeSol, plastico, accesorio, "negro", "rojo", 0);
			Guardarropa g = usuario1.guardarropas().get(0);
			System.out.println("Test GenerarUnAtuendo2:");
			System.out.println(g.generarSugerencias().stream().map( a -> a.infoAtuendo()).collect(Collectors.toList()));
			System.out.println("");
		}
		
		@Test
		public void generarAtuendosDeVariosGuardarropas() {
			usuario1.crearNuevoGuardarropa();
			
			
			usuario1.crear_GuardarIndumentariaEn(remera, algodon, parteSuperior, "rojo", "azul", 0);
			usuario1.crear_GuardarIndumentariaEn(chomba, algodon, parteSuperior, "rojo", "negro", 0);
			usuario1.crear_GuardarIndumentariaEn(pantalon, algodon, parteInferior, "negro", "rojo", 0);
			usuario1.crear_GuardarIndumentariaEn(sandalias, cuero, calzado, "marron", "blanco", 0);
			usuario1.crear_GuardarIndumentariaEn(anteojosDeSol, plastico, accesorio, "negro", "rojo", 0);
			
			usuario1.crear_GuardarIndumentariaEn(camisaMangaCorta, algodon, parteSuperior, "rojo", "azul", 1);
			usuario1.crear_GuardarIndumentariaEn(chomba, algodon, parteSuperior, "rojo", "negro", 1);
			usuario1.crear_GuardarIndumentariaEn(falda, algodon, parteInferior, "negro", "rojo", 1);
			usuario1.crear_GuardarIndumentariaEn(botas, cuero, calzado, "marron", "blanco", 1);
			usuario1.crear_GuardarIndumentariaEn(panuelo, batista, accesorio, "negro", "rojo", 1);
			
			
			System.out.println("Test generarAtuendosDeVariosGuardarropas:");
			System.out.println(usuario1.solicitarSugerenciasGuardarropas()
					.stream()
					.map( ls -> ls.stream().map(a -> a.infoAtuendo()).collect(Collectors.toList()))
					.collect(Collectors.toList()));
			System.out.println("");
		}
}
