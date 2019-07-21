package clases;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class TestPrendasSuperpuestas {
	
	// Generador de Sugerencias
	SugerenciaInvierno si = new SugerenciaInvierno();

	// Categorias		
	Categoria parteSuperior = new Categoria("parteSuperior");
					
	//Guardarropas
	Guardarropa guardarropa1 = new Guardarropa("guardarropa1");
		
	// Tipo de Telas
	Tela algodon = new Tela("algodon");
	Tela lana = new Tela("lana");
	Tela polar = new Tela("polar");
					
	// Tipo de Prendas
					
		//Parte Superior
		TipoDePrenda chomba = new TipoDePrenda("chomba",Arrays.asList(algodon),parteSuperior,5);
		TipoDePrenda remera = new TipoDePrenda("remera",Arrays.asList(algodon),parteSuperior,5);
		TipoDePrenda camisaMangaLarga = new TipoDePrenda("camisaMangaLarga",Arrays.asList(algodon),parteSuperior,10);
		TipoDePrenda termica = new TipoDePrenda("termica",Arrays.asList(algodon),parteSuperior,10);
		TipoDePrenda buzo = new TipoDePrenda("buzo",Arrays.asList(algodon),parteSuperior,15);
		TipoDePrenda sueter = new TipoDePrenda("sueter",Arrays.asList(lana),parteSuperior,15);
		TipoDePrenda campera = new TipoDePrenda("campera",Arrays.asList(polar),parteSuperior,20);				
					
					
	// Usuarios
	Usuario usuario = new Usuario("usuario","Premium");

	@Test
	public void generarPrendasParteSuperiorAnidadas() {
		
		String[] arrayEsperado = {"chomba", "camisaMangaLarga", "sueter", "campera"};
		
		usuario.agregarNuevoGuardarropa(guardarropa1);
		guardarropa1.agregarIndumentaria(new Indumentaria(chomba,algodon,"rojo"));
		guardarropa1.agregarIndumentaria(new Indumentaria(camisaMangaLarga,algodon,"verde"));
		guardarropa1.agregarIndumentaria(new Indumentaria(sueter,lana,"negro"));
		guardarropa1.agregarIndumentaria(new Indumentaria(campera,polar,"negro"));
		
		si.generarPrendasAnidadas(guardarropa1);
		
		Object[] arrayResultado1 =  si.getDescripcionListaPrendasSuperiorAnidadas().get(0).toArray();
		
		assertArrayEquals(arrayEsperado, arrayResultado1);
	}
	
	@Test
	public void generarPrendasParteSuperiorAnidadas2() {
		
		String[] arrayEsperado1 = {"chomba", "camisaMangaLarga", "sueter", "campera"};
		String[] arrayEsperado2 = {"remera", "camisaMangaLarga", "sueter", "campera"};
		
		usuario.agregarNuevoGuardarropa(guardarropa1);
		guardarropa1.agregarIndumentaria(new Indumentaria(chomba,algodon,"rojo"));
		guardarropa1.agregarIndumentaria(new Indumentaria(remera,algodon,"blanco"));
		guardarropa1.agregarIndumentaria(new Indumentaria(camisaMangaLarga,algodon,"verde"));
		guardarropa1.agregarIndumentaria(new Indumentaria(sueter,lana,"negro"));
		guardarropa1.agregarIndumentaria(new Indumentaria(campera,polar,"negro"));
		
		si.generarPrendasAnidadas(guardarropa1);
		
		Object[] arrayResultado1 =  si.getDescripcionListaPrendasSuperiorAnidadas().get(0).toArray();
		Object[] arrayResultado2 =  si.getDescripcionListaPrendasSuperiorAnidadas().get(1).toArray();
		
		assertArrayEquals(arrayEsperado1, arrayResultado1);
		assertArrayEquals(arrayEsperado2, arrayResultado2);
	}
	
	@Test
	public void generarPrendasParteSuperiorAnidadas3() {
		
		String[] arrayEsperado1 = {"chomba", "camisaMangaLarga", "sueter", "campera"};
		String[] arrayEsperado2 = {"chomba", "camisaMangaLarga", "buzo", "campera"};
		String[] arrayEsperado3 = {"remera", "camisaMangaLarga", "sueter", "campera"};
		String[] arrayEsperado4 = {"remera", "camisaMangaLarga", "buzo", "campera"};
		
		usuario.agregarNuevoGuardarropa(guardarropa1);
		guardarropa1.agregarIndumentaria(new Indumentaria(chomba,algodon,"rojo"));
		guardarropa1.agregarIndumentaria(new Indumentaria(remera,algodon,"blanco"));
		guardarropa1.agregarIndumentaria(new Indumentaria(camisaMangaLarga,algodon,"verde"));
		guardarropa1.agregarIndumentaria(new Indumentaria(sueter,lana,"negro"));
		guardarropa1.agregarIndumentaria(new Indumentaria(buzo,algodon,"azul"));
		guardarropa1.agregarIndumentaria(new Indumentaria(campera,polar,"negro"));
		
		si.generarPrendasAnidadas(guardarropa1);
		
		Object[] arrayResultado1 =  si.getDescripcionListaPrendasSuperiorAnidadas().get(0).toArray();
		Object[] arrayResultado2 =  si.getDescripcionListaPrendasSuperiorAnidadas().get(1).toArray();
		Object[] arrayResultado3 =  si.getDescripcionListaPrendasSuperiorAnidadas().get(2).toArray();
		Object[] arrayResultado4 =  si.getDescripcionListaPrendasSuperiorAnidadas().get(3).toArray();
		
		assertArrayEquals(arrayEsperado1, arrayResultado1);
		assertArrayEquals(arrayEsperado2, arrayResultado2);
		assertArrayEquals(arrayEsperado3, arrayResultado3);
		assertArrayEquals(arrayEsperado4, arrayResultado4);
	}
}
