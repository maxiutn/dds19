package clases;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class testTipoDeUsuario {

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
		Tela crepe = new Tela("crepe");
		Tela batista = new Tela("batista");
		Tela plastico = new Tela("plastico");
				
		// Tipo de Prendas
				
			//Parte Superior
				TipoDePrenda camisaMangaCorta = new TipoDePrenda("camisaMangaCorta",Arrays.asList(algodon),parteSuperior,5);
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
				TipoDePrenda sandalias = new TipoDePrenda("sandalias", Arrays.asList(lona),calzado,1);
				
			// Accesorios
				TipoDePrenda anteojosDeSol = new TipoDePrenda("anteojosDeSol",Arrays.asList(plastico),accesorio,0);
				TipoDePrenda bufanda = new TipoDePrenda("bufanda",Arrays.asList(algodon),accesorio,0);
				
				
		// Usuarios
			Premium usuario1Premium = new Premium("usuario1");
			Gratuito usuario2Gratuito = new Gratuito("usuario2");
	
	@Test
	public void almacenarCantidadMenor_IndumentariaMaxima() {
		usuario2Gratuito.setGuardarropa(guardarropa1);
		Guardarropa g = usuario2Gratuito.guardarropas().get(0);
		
		g.agregarIndumentaria(new Indumentaria(camisaMangaCorta,algodon,"rojo"));
		g.agregarIndumentaria(new Indumentaria(chomba,algodon,"azul"));
		g.agregarIndumentaria(new Indumentaria(campera,polar,"negra"));
		g.agregarIndumentaria(new Indumentaria(buzo,algodon,"rojo"));
		g.agregarIndumentaria(new Indumentaria(pantalon,algodon,"negro"));
		g.agregarIndumentaria(new Indumentaria(falda,algodon,"verde"));
		g.agregarIndumentaria(new Indumentaria(botas,cuero,"negro"));
		g.agregarIndumentaria(new Indumentaria(zapatos,cuero,"marronOscuro"));
		g.agregarIndumentaria(new Indumentaria(sandalias,lona,"marronClaro"));
		g.agregarIndumentaria(new Indumentaria(bufanda,algodon,"violeta"));
		
		assertEquals(10 , g.cantidadIndumentarias());
	}
	
	@Test
	public void almacenarCantidadExcesiva_IndumentariaMaxima() {
		usuario2Gratuito.setGuardarropa(guardarropa1);
		Guardarropa g = usuario2Gratuito.guardarropas().get(0);
		
		System.out.println("Test2: Cantidad excesiva de prendas en usuario gratuito"); // Se espera mensaje de error
		
		g.agregarIndumentaria(new Indumentaria(camisaMangaCorta,algodon,"rojo"));
		g.agregarIndumentaria(new Indumentaria(chomba,algodon,"azul"));
		g.agregarIndumentaria(new Indumentaria(campera,polar,"negra"));
		g.agregarIndumentaria(new Indumentaria(buzo,algodon,"rojo"));
		g.agregarIndumentaria(new Indumentaria(pantalon,algodon,"negro"));
		g.agregarIndumentaria(new Indumentaria(falda,algodon,"verde"));
		g.agregarIndumentaria(new Indumentaria(botas,cuero,"negro"));
		g.agregarIndumentaria(new Indumentaria(zapatos,cuero,"marronOscuro"));
		g.agregarIndumentaria(new Indumentaria(sandalias,lona,"marronClaro"));
		g.agregarIndumentaria(new Indumentaria(bufanda,algodon,"violeta"));
		g.agregarIndumentaria(new Indumentaria(anteojosDeSol,plastico,"negro"));
	}
	
	@Test
	public void almacenarCualquierCantidadDeIndumentaria_UsuarioPremium() {
		usuario1Premium.setGuardarropa(guardarropa1);
		Guardarropa g = usuario1Premium.guardarropas().get(0);
		
		g.agregarIndumentaria(new Indumentaria(camisaMangaCorta,algodon,"rojo"));
		g.agregarIndumentaria(new Indumentaria(chomba,algodon,"azul"));
		g.agregarIndumentaria(new Indumentaria(campera,polar,"negra"));
		g.agregarIndumentaria(new Indumentaria(buzo,algodon,"rojo"));
		g.agregarIndumentaria(new Indumentaria(pantalon,algodon,"negro"));
		g.agregarIndumentaria(new Indumentaria(falda,algodon,"verde"));
		g.agregarIndumentaria(new Indumentaria(botas,cuero,"negro"));
		g.agregarIndumentaria(new Indumentaria(zapatos,cuero,"marronOscuro"));
		g.agregarIndumentaria(new Indumentaria(sandalias,lona,"marronClaro"));
		g.agregarIndumentaria(new Indumentaria(bufanda,algodon,"violeta"));
		g.agregarIndumentaria(new Indumentaria(anteojosDeSol,plastico,"negro"));
		
		assertEquals(11 , g.cantidadIndumentarias());
	}

}
