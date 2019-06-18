package clases;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Test;

public class testGenerarAtuendos {
	
	// Generador de Sugerencias
	
	Sugerencia sugerenciaSistema = new Sugerencia();

	// Categorias
	
	Categoria parteSuperior = new Categoria("parteSuperior");
	Categoria parteInferior = new Categoria("parteInferior");
	Categoria calzado = new Categoria("calzado");
	Categoria accesorio = new Categoria("accesorio");
			
	// Tipo de Telas
			
	Tela algodon = new Tela("algodon");
	Tela laycra = new Tela("laycra");
	Tela modal = new Tela("modal");
	Tela cuero = new Tela("cuero");
	Tela lona = new Tela("lona");
	Tela nylon = new Tela("nylon");
	Tela crepe = new Tela("crepe");
	Tela batista = new Tela("batista");
	//Tela plastico = new Tela("plastico");
			
	// Tipo de Prendas
			
			// Parte Superior
				TipoDePrenda camisaMangaCorta = new TipoDePrenda("camisaMangaCorta",Arrays.asList(algodon),parteSuperior);
				TipoDePrenda chomba = new TipoDePrenda("chomba",Arrays.asList(algodon),parteSuperior);
				TipoDePrenda remera = new TipoDePrenda("remera",Arrays.asList(algodon),parteSuperior);
			
			// Parte Inferior
				TipoDePrenda pantalon = new TipoDePrenda("pantalon",Arrays.asList(algodon),parteInferior);
				TipoDePrenda shorts = new TipoDePrenda("shorts",Arrays.asList(algodon),parteInferior);
				TipoDePrenda falda = new TipoDePrenda("falda",Arrays.asList(algodon),parteInferior);
			
			// Calzado
				TipoDePrenda zapatillas = new TipoDePrenda("zapatilla",Arrays.asList(lona,cuero,nylon),calzado);
				TipoDePrenda botas = new TipoDePrenda("botas",Arrays.asList(cuero),calzado);
				TipoDePrenda sandalias = new TipoDePrenda("sandalias", Arrays.asList(lona),calzado);
			
			// Accesorios
				//TipoDePrenda anteojosDeSol = new TipoDePrenda("anteojosDeSol","accesorio");
				TipoDePrenda panuelo = new TipoDePrenda("pañuelo",Arrays.asList(algodon),accesorio);
			
		// Usuarios
			
		Usuario usuario1 = new Usuario();
		Usuario usuario2 = new Usuario();
		
		@Test
		public void generarUnAtuendo() {
			usuario1.agregarNuevoGuardarropa("guardarropa1");
			Guardarropa g = usuario1.guardarropas().get(0);
			g.agregarIndumentaria(new Indumentaria(camisaMangaCorta,algodon,"rojo"));
			g.agregarIndumentaria(new Indumentaria(pantalon,algodon,"negro"));
			g.agregarIndumentaria(new Indumentaria(zapatillas,nylon,"verde"));
			//g.agregarIndumentaria(new Indumentaria(panuelo,algodon,"violeta"));
			sugerenciaSistema.generarSugerencias(usuario1);
		}
		
		@Test
		public void generarVariosAtuendos() {
			usuario1.agregarNuevoGuardarropa("guardarropa1");
			Guardarropa g = usuario1.guardarropas().get(0);
			
			g.agregarIndumentaria(new Indumentaria(camisaMangaCorta,algodon,"rojo"));
			g.agregarIndumentaria(new Indumentaria(pantalon,algodon,"negro"));
			g.agregarIndumentaria(new Indumentaria(zapatillas,nylon,"verde"));
			
			g.agregarIndumentaria(new Indumentaria(remera,algodon,"azul"));
			g.agregarIndumentaria(new Indumentaria(shorts,algodon,"violeta"));
			g.agregarIndumentaria(new Indumentaria(zapatillas,nylon,"rojo"));
			
			//sugerenciaSistema.generarSugerencias(usuario1);
		}
		
		@Test
		public void generarAtuendosDeVariosGuardarropas() {
			usuario1.agregarNuevoGuardarropa("guardarropa1");
			usuario1.agregarNuevoGuardarropa("guardarropa2");
			
			Guardarropa g1 = usuario1.guardarropas().get(0);
			Guardarropa g2 = usuario1.guardarropas().get(1);
			
			g1.agregarIndumentaria(new Indumentaria(camisaMangaCorta,algodon,"rojo"));
			g1.agregarIndumentaria(new Indumentaria(pantalon,algodon,"negro"));
			g1.agregarIndumentaria(new Indumentaria(zapatillas,nylon,"verde"));
			
			g2.agregarIndumentaria(new Indumentaria(remera,algodon,"azul"));
			g2.agregarIndumentaria(new Indumentaria(shorts,algodon,"violeta"));
			g2.agregarIndumentaria(new Indumentaria(zapatillas,nylon,"rojo"));
			
			//sugerenciaSistema.generarSugerencias(usuario1);
		}
		
		@Test
		public void generarAtuendosDeVariosGuardarropasDeVariosUsuarios() {
			usuario1.agregarNuevoGuardarropa("guardarropa1");
			usuario2.agregarNuevoGuardarropa("guardarropa1");
			
			Guardarropa g1 = usuario1.guardarropas().get(0);
			Guardarropa g2 = usuario2.guardarropas().get(0);
			
			g1.agregarIndumentaria(new Indumentaria(camisaMangaCorta,algodon,"rojo"));
			g1.agregarIndumentaria(new Indumentaria(pantalon,algodon,"negro"));
			g1.agregarIndumentaria(new Indumentaria(zapatillas,nylon,"verde"));
			
			g2.agregarIndumentaria(new Indumentaria(remera,algodon,"azul"));
			g2.agregarIndumentaria(new Indumentaria(shorts,algodon,"violeta"));
			g2.agregarIndumentaria(new Indumentaria(zapatillas,nylon,"rojo"));
			
			/*
			System.out.println("Atuendos usuario1:");
			sugerenciaSistema.generarSugerencias(usuario1);
			System.out.println("");
			System.out.println("Atuendos usuario2:");
			sugerenciaSistema.generarSugerencias(usuario2);
			*/
		}
}
