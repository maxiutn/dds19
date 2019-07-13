package clases;

import java.util.Arrays;

import org.junit.Test;

public class TestGenerarAtuendosConPrendasAnidadas {

	// Generador de Sugerencias
	SugerenciaInvierno si = new SugerenciaInvierno();

	// Categorias		
	Categoria parteSuperior = new Categoria("parteSuperior");
	Categoria parteInferior = new Categoria("parteInferior");
	Categoria calzado = new Categoria("calzado");
	Categoria accesorio = new Categoria("accesorio");
							
	//Guardarropas	
	Guardarropa guardarropa1 = new Guardarropa("guardarropa1");
				
	// Tipo de Telas				
	Tela algodon = new Tela("algodon");
	Tela lana = new Tela("lana");
	Tela polar = new Tela("polar");
	Tela cuero = new Tela("cuero");
	Tela lona = new Tela("lona");
	Tela nylon = new Tela("nylon");
							
	// Tipo de Prendas
							
		//Parte Superior
		TipoDePrenda chomba = new TipoDePrenda("chomba",Arrays.asList(algodon),parteSuperior,5);
		TipoDePrenda remera = new TipoDePrenda("remera",Arrays.asList(algodon),parteSuperior,5);
		TipoDePrenda camisaMangaLarga = new TipoDePrenda("camisaMangaLarga",Arrays.asList(algodon),parteSuperior,10);
		TipoDePrenda termica = new TipoDePrenda("termica",Arrays.asList(algodon),parteSuperior,10);
		TipoDePrenda buzo = new TipoDePrenda("buzo",Arrays.asList(algodon),parteSuperior,15);
		TipoDePrenda sueter = new TipoDePrenda("sueter",Arrays.asList(lana),parteSuperior,15);
		TipoDePrenda campera = new TipoDePrenda("campera",Arrays.asList(polar),parteSuperior,20);
							
							
		// Parte Inferior
		TipoDePrenda pantalon = new TipoDePrenda("pantalon",Arrays.asList(algodon),parteInferior,5);
		TipoDePrenda falda = new TipoDePrenda("falda",Arrays.asList(algodon),parteInferior,5);
							
		// Calzado
		TipoDePrenda zapatillas = new TipoDePrenda("zapatilla",Arrays.asList(lona,cuero,nylon),calzado,5);
		TipoDePrenda botas = new TipoDePrenda("botas",Arrays.asList(cuero),calzado,5);
		TipoDePrenda zapatos = new TipoDePrenda("zapatos",Arrays.asList(cuero),calzado,5);
							
		// Accesorios
		TipoDePrenda bufanda = new TipoDePrenda("bufanda",Arrays.asList(lana),accesorio,0);
							
							
		// Usuarios
		Gratuito usuario2Gratuito = new Gratuito("usuario2");

		@Test
		public void generarAtuendosConPrendasAnidadas() {
						
			usuario2Gratuito.agregarNuevoGuardarropa(guardarropa1);
			guardarropa1.agregarIndumentaria(new Indumentaria(remera,algodon,"rojo"));
			guardarropa1.agregarIndumentaria(new Indumentaria(camisaMangaLarga,algodon,"verde"));
			guardarropa1.agregarIndumentaria(new Indumentaria(sueter,lana,"negro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(campera,polar,"negro"));
			
			guardarropa1.agregarIndumentaria(new Indumentaria(pantalon,algodon,"azulOscuro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(zapatos,cuero,"negro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(bufanda,lana,"rojo"));
						
			System.out.println("Test Generar Atuendos con prendas anidadas:");
			si.generarSugerencias(usuario2Gratuito);
			System.out.println("");
		}
					
		@Test
		public void generarAtuendosConPrendasAnidadas2() {
						
			usuario2Gratuito.agregarNuevoGuardarropa(guardarropa1);

			guardarropa1.agregarIndumentaria(new Indumentaria(remera,algodon,"blanco"));
			guardarropa1.agregarIndumentaria(new Indumentaria(camisaMangaLarga,algodon,"verde"));
			guardarropa1.agregarIndumentaria(new Indumentaria(sueter,lana,"negro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(buzo,algodon,"azul"));
			guardarropa1.agregarIndumentaria(new Indumentaria(campera,polar,"negro"));
			
			guardarropa1.agregarIndumentaria(new Indumentaria(pantalon,algodon,"azulOscuro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(zapatos,cuero,"negro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(bufanda,lana,"rojo"));
						
			System.out.println("Test Generar Atuendos con prendas anidadas(2):");
			si.generarSugerencias(usuario2Gratuito);
			System.out.println("");
		}
					
		@Test
		public void generarAtuendosConPrendasAnidadas3() {
						
			usuario2Gratuito.agregarNuevoGuardarropa(guardarropa1);
			
			guardarropa1.agregarIndumentaria(new Indumentaria(remera,algodon,"blanco"));
			guardarropa1.agregarIndumentaria(new Indumentaria(camisaMangaLarga,algodon,"verde"));
			guardarropa1.agregarIndumentaria(new Indumentaria(termica,algodon,"gris"));
			guardarropa1.agregarIndumentaria(new Indumentaria(sueter,lana,"negro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(buzo,algodon,"azul"));
			guardarropa1.agregarIndumentaria(new Indumentaria(campera,polar,"negro"));
			
			guardarropa1.agregarIndumentaria(new Indumentaria(pantalon,algodon,"azulOscuro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(zapatos,cuero,"negro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(bufanda,lana,"rojo"));
						
			System.out.println("Test Generar Atuendos con prendas anidadas(3):");
			si.generarSugerencias(usuario2Gratuito);
			System.out.println("");
		}

}
