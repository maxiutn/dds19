package clases;

import java.util.Arrays;

import org.junit.Test;

public class TestPrendasSuperpuestas {
	
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
		TipoDePrenda pantalon = new TipoDePrenda("pantalon",Arrays.asList(algodon),parteInferior,1);
		TipoDePrenda shorts = new TipoDePrenda("shorts",Arrays.asList(algodon),parteInferior,1);
		TipoDePrenda falda = new TipoDePrenda("falda",Arrays.asList(algodon),parteInferior,1);
					
		// Calzado
		TipoDePrenda zapatillas = new TipoDePrenda("zapatilla",Arrays.asList(lona,cuero,nylon),calzado,1);
		TipoDePrenda botas = new TipoDePrenda("botas",Arrays.asList(cuero),calzado,1);
		TipoDePrenda zapatos = new TipoDePrenda("zapatos",Arrays.asList(cuero),calzado,1);
					
		// Accesorios
		TipoDePrenda bufanda = new TipoDePrenda("bufanda",Arrays.asList(algodon),accesorio,1);
					
					
	// Usuarios
	Gratuito usuario2Gratuito = new Gratuito("usuario2");

	@Test
	public void generarPrendasParteSuperiorAnidadas() {
		
		usuario2Gratuito.agregarNuevoGuardarropa(guardarropa1);
		guardarropa1.agregarIndumentaria(new Indumentaria(chomba,algodon,"rojo"));
		guardarropa1.agregarIndumentaria(new Indumentaria(camisaMangaLarga,algodon,"verde"));
		guardarropa1.agregarIndumentaria(new Indumentaria(sueter,lana,"negro"));
		guardarropa1.agregarIndumentaria(new Indumentaria(campera,polar,"negro"));
		
		System.out.println("Test Generar Prendas Anidadas ParteSuperior: ");
		si.generarPrendasAnidadas(guardarropa1);
		System.out.println(si.getDescripcionListaPrendasSuperiorAnidadas());
		System.out.println("");
	}
	
	@Test
	public void generarPrendasParteSuperiorAnidadas2() {
		
		usuario2Gratuito.agregarNuevoGuardarropa(guardarropa1);
		guardarropa1.agregarIndumentaria(new Indumentaria(chomba,algodon,"rojo"));
		guardarropa1.agregarIndumentaria(new Indumentaria(remera,algodon,"blanco"));
		guardarropa1.agregarIndumentaria(new Indumentaria(camisaMangaLarga,algodon,"verde"));
		guardarropa1.agregarIndumentaria(new Indumentaria(sueter,lana,"negro"));
		guardarropa1.agregarIndumentaria(new Indumentaria(campera,polar,"negro"));
		
		System.out.println("Test Generar Prendas Anidadas ParteSuperior(2): ");
		si.generarPrendasAnidadas(guardarropa1);
		System.out.println(si.getDescripcionListaPrendasSuperiorAnidadas());
		System.out.println("");
	}
	
	@Test
	public void generarPrendasParteSuperiorAnidadas3() {
		
		usuario2Gratuito.agregarNuevoGuardarropa(guardarropa1);
		guardarropa1.agregarIndumentaria(new Indumentaria(chomba,algodon,"rojo"));
		guardarropa1.agregarIndumentaria(new Indumentaria(remera,algodon,"blanco"));
		guardarropa1.agregarIndumentaria(new Indumentaria(camisaMangaLarga,algodon,"verde"));
		guardarropa1.agregarIndumentaria(new Indumentaria(sueter,lana,"negro"));
		guardarropa1.agregarIndumentaria(new Indumentaria(buzo,algodon,"azul"));
		guardarropa1.agregarIndumentaria(new Indumentaria(campera,polar,"negro"));
		
		System.out.println("Test Generar Prendas Anidadas ParteSuperior(3): ");
		si.generarPrendasAnidadas(guardarropa1);
		System.out.println(si.getDescripcionListaPrendasSuperiorAnidadas());
		System.out.println("");
	}

}
