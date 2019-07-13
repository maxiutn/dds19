package clases;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Test;

public class testGenerarAtuendos {
	
	// Generador de Sugerencias
	
	SugerenciaVerano sugerenciaSistemaVerano = new SugerenciaVerano();

	// Categorias
	
	Categoria parteSuperior = new Categoria("parteSuperior");
	Categoria parteInferior = new Categoria("parteInferior");
	Categoria calzado = new Categoria("calzado");
	Categoria accesorio = new Categoria("accesorio");
			
	//Guardarropas
	Guardarropa guardarropa1 = new Guardarropa("guardarropa1");
	Guardarropa guardarropa2 = new Guardarropa("guardarropa2");
	// Tipo de Telas
			
	Tela algodon = new Tela("algodon");
	Tela laycra = new Tela("laycra");
	Tela modal = new Tela("modal");
	Tela cuero = new Tela("cuero");
	Tela lona = new Tela("lona");
	Tela nylon = new Tela("nylon");
	Tela crepe = new Tela("crepe");
	Tela batista = new Tela("batista");
			
	// Tipo de Prendas
			
			// Parte Superior
				TipoDePrenda camisaMangaCorta = new TipoDePrenda("camisaMangaCorta",Arrays.asList(algodon),parteSuperior,5);
				TipoDePrenda chomba = new TipoDePrenda("chomba",Arrays.asList(algodon),parteSuperior,5);
				TipoDePrenda remera = new TipoDePrenda("remera",Arrays.asList(algodon),parteSuperior,5);
			
			// Parte Inferior
				TipoDePrenda pantalon = new TipoDePrenda("pantalon",Arrays.asList(algodon),parteInferior,1);
				TipoDePrenda shorts = new TipoDePrenda("shorts",Arrays.asList(algodon),parteInferior,1);
				TipoDePrenda falda = new TipoDePrenda("falda",Arrays.asList(algodon),parteInferior,1);
			
			// Calzado
				TipoDePrenda zapatillas = new TipoDePrenda("zapatilla",Arrays.asList(lona,cuero,nylon),calzado,1);
				TipoDePrenda botas = new TipoDePrenda("botas",Arrays.asList(cuero),calzado,1);
				TipoDePrenda sandalias = new TipoDePrenda("sandalias", Arrays.asList(lona),calzado,1);
			
			// Accesorios
				TipoDePrenda panuelo = new TipoDePrenda("pañuelo",Arrays.asList(algodon),accesorio,0);
			
		// Usuarios
			
		Gratuito usuario1 = new Gratuito("Usuario1");
		Gratuito usuario2 = new Gratuito("Usuario2");
		
		@Test
		public void generarUnAtuendo() {
			
			usuario1.agregarNuevoGuardarropa(guardarropa1);
			Guardarropa g = usuario1.guardarropas().get(0);
			
			g.agregarIndumentaria(new Indumentaria(camisaMangaCorta,algodon,"rojo"));
			g.agregarIndumentaria(new Indumentaria(pantalon,algodon,"negro"));
			g.agregarIndumentaria(new Indumentaria(zapatillas,nylon,"verde"));
			g.agregarIndumentaria(new Indumentaria(panuelo,algodon,"violeta"));
			
			System.out.println("Test Generar Atuendo:");
			sugerenciaSistemaVerano.generarSugerencias(usuario1);
			System.out.println("");
		}
		
		@Test
		public void generarVariosAtuendos() {
			
			usuario1.agregarNuevoGuardarropa(guardarropa1);
			Guardarropa g = usuario1.guardarropas().get(0);
			
			g.agregarIndumentaria(new Indumentaria(camisaMangaCorta,algodon,"rojo"));
			g.agregarIndumentaria(new Indumentaria(pantalon,algodon,"negro"));
			g.agregarIndumentaria(new Indumentaria(shorts,algodon,"violeta"));
			g.agregarIndumentaria(new Indumentaria(zapatillas,nylon,"verde"));
			
			System.out.println("Test Generar Varios Atuendo:");
			sugerenciaSistemaVerano.generarSugerencias(usuario1);
			System.out.println("");
		}
		
		@Test
		public void generarAtuendosDeVariosGuardarropas() {
			usuario1.agregarNuevoGuardarropa(guardarropa1);
			usuario1.agregarNuevoGuardarropa(guardarropa2);
			
			Guardarropa g1 = usuario1.guardarropas().get(0);
			Guardarropa g2 = usuario1.guardarropas().get(1);
			
			g1.agregarIndumentaria(new Indumentaria(camisaMangaCorta,algodon,"rojo"));
			g1.agregarIndumentaria(new Indumentaria(pantalon,algodon,"negro"));
			g1.agregarIndumentaria(new Indumentaria(zapatillas,nylon,"verde"));
			
			g2.agregarIndumentaria(new Indumentaria(remera,algodon,"azul"));
			g2.agregarIndumentaria(new Indumentaria(shorts,algodon,"violeta"));
			g2.agregarIndumentaria(new Indumentaria(zapatillas,nylon,"rojo"));
			
			
			System.out.println("Test Generar Atuendos de Varios Guardarropas:");
			sugerenciaSistemaVerano.generarSugerencias(usuario1);
			System.out.println("");
		}
		
		@Test
		public void generarAtuendosDeVariosGuardarropasDeVariosUsuarios() {
			usuario1.agregarNuevoGuardarropa(guardarropa1);
			usuario2.agregarNuevoGuardarropa(guardarropa2);
			
			Guardarropa g1 = usuario1.guardarropas().get(0);
			Guardarropa g2 = usuario2.guardarropas().get(0);
			
			g1.agregarIndumentaria(new Indumentaria(camisaMangaCorta,algodon,"rojo"));
			g1.agregarIndumentaria(new Indumentaria(pantalon,algodon,"negro"));
			g1.agregarIndumentaria(new Indumentaria(zapatillas,nylon,"verde"));
			
			g2.agregarIndumentaria(new Indumentaria(remera,algodon,"azul"));
			g2.agregarIndumentaria(new Indumentaria(shorts,algodon,"violeta"));
			g2.agregarIndumentaria(new Indumentaria(zapatillas,nylon,"rojo"));
			
			System.out.println("Test Generar Varios Atuendos de Varios Usuarios:");

			System.out.println("Atuendos usuario1:");
			sugerenciaSistemaVerano.generarSugerencias(usuario1);
			System.out.println("");
			System.out.println("Atuendos usuario2:");
			sugerenciaSistemaVerano.generarSugerencias(usuario2);
			
			System.out.println("");
		}
}
