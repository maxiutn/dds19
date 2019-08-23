package clases;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestEventos {
	
	// Ubicacion
	Ubicacion buenosAires = new Ubicacion(-34.6131500,-58.3772300);
	Ubicacion mendoza = new Ubicacion(-32.8908400,-68.8271700);
	
	// API Clima
	ServicioA servicioOpenWeather = new ServicioA();
	ServicioB servicioDarkSkyWeather = new ServicioB();
	ServicioClima servicio = servicioOpenWeather;
	
	// Adaptador
	Adapter adaptador = new Adapter();
	
	
	//Evento (Cambiar la fecha de evento cuando se hagan nuevos test)
	Evento trabajo = new Evento("irATrabajar",LocalDate.parse("2019-08-23"),buenosAires);
	Evento bautismo = new Evento("celebrarBautismo",LocalDate.parse("2019-08-23"),mendoza);
	
	// Generador de Sugerencias
	Sugerencia sugerenciaSistema = new Sugerencia();
	
	
	// Categorias		
	Categoria parteSuperior = new Categoria("parteSuperior");
	Categoria parteInferior = new Categoria("parteInferior");
	Categoria calzado = new Categoria("calzado");
	Categoria accesorio = new Categoria("accesorio");
								
	//Guardarropas	
	Guardarropa guardarropa1 = new Guardarropa("guardarropa1");
					
	// Tipo de Telas
	Tela tweed = new Tela("tweed");
	Tela algodon = new Tela("algodon");
	Tela lana = new Tela("lana");
	Tela polar = new Tela("polar");
	Tela cuero = new Tela("cuero");
	Tela lona = new Tela("lona");
	Tela nylon = new Tela("nylon");
								
	// Tipo de Prendas
								
		//Parte Superior
		TipoDePrenda remera = new TipoDePrenda("remera",Arrays.asList(algodon),parteSuperior,5);
		TipoDePrenda camisaMangaLarga = new TipoDePrenda("camisaMangaLarga",Arrays.asList(algodon),parteSuperior,10);
		TipoDePrenda termica = new TipoDePrenda("termica",Arrays.asList(algodon),parteSuperior,10);
		TipoDePrenda sueter = new TipoDePrenda("sueter",Arrays.asList(lana),parteSuperior,15);
		TipoDePrenda campera = new TipoDePrenda("campera",Arrays.asList(polar),parteSuperior,20);
		TipoDePrenda saco = new TipoDePrenda("saco",Arrays.asList(tweed),parteSuperior,15);
								
								
		// Parte Inferior
		TipoDePrenda pantalon = new TipoDePrenda("pantalon",Arrays.asList(algodon),parteInferior,5);
		TipoDePrenda pantalonDeVestir = new TipoDePrenda("pantalonDeVestir",Arrays.asList(algodon),parteInferior,5);
								
		// Calzado
		TipoDePrenda botas = new TipoDePrenda("botas",Arrays.asList(cuero),calzado,5);
		TipoDePrenda zapatos = new TipoDePrenda("zapatos",Arrays.asList(cuero),calzado,5);
								
		// Accesorios
		TipoDePrenda bufanda = new TipoDePrenda("bufanda",Arrays.asList(lana),accesorio,0);
		TipoDePrenda corbata = new TipoDePrenda("corbata",Arrays.asList(algodon),accesorio,0);
								
		// Usuarios
		Usuario usuario = new Usuario("Usuario","Gratuito");
		
		@Test
		public void generarAtuendosConPrendasAnidadasParaUnEventoConCondicionDelUsuario() {
			Indumentaria bufandaRoja = new Indumentaria(bufanda,lana,"rojo");
			
			adaptador.agregarServicio(servicioOpenWeather);
			adaptador.agregarServicio(servicioDarkSkyWeather);
			adaptador.setServicio();
			
			trabajo.setTemperatura(5);
			trabajo.setCondicionDelUsuario(Arrays.asList(bufandaRoja));
			
			usuario.agregarNuevoGuardarropa(guardarropa1);
			usuario.agregarEvento(trabajo);
			
			guardarropa1.agregarIndumentaria(new Indumentaria(remera,algodon,"blanco"));
			guardarropa1.agregarIndumentaria(new Indumentaria(camisaMangaLarga,algodon,"verde"));
			guardarropa1.agregarIndumentaria(new Indumentaria(sueter,lana,"negro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(campera,polar,"negro"));
			
			guardarropa1.agregarIndumentaria(new Indumentaria(pantalon,algodon,"azulOscuro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(zapatos,cuero,"negro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(bufanda,lana,"rojo"));
				
			sugerenciaSistema.realizarSugerencias(usuario);
			
			Atuendo atuendo = trabajo.getSugerenciasAceptadas().get(0);
			List<String> parteSuperior = atuendo.getParteSuperior();
			String parteInferior = atuendo.getParteInferior();
			String calzado = atuendo.getCalzado();
			String accesorio = atuendo.getAccesorio();
			
			String[] arrayEsperadoPS = {"remera" , "camisaMangaLarga" , "sueter" , "campera"};
			String parteInferiorEsperado = "pantalon";
			String calzadoEsperado = "zapatos";
			String accesorioEsperado = "bufanda";
			
			assertArrayEquals(arrayEsperadoPS,parteSuperior.toArray());
			assertEquals(parteInferiorEsperado,parteInferior);
			assertEquals(calzadoEsperado,calzado);
			assertEquals(accesorioEsperado,accesorio);
			
		}
		
		@Test
		public void generarAtuendosConPrendasAnidadasParaDosEventosConCondicionDelUsuario() {
			Indumentaria camisaMangaLargaVerde = new Indumentaria(camisaMangaLarga,algodon,"verde");
			Indumentaria pantalonDeVestirNegro = new Indumentaria(pantalonDeVestir,algodon,"negro");
			Indumentaria corbataVerde = new Indumentaria(corbata,algodon,"verde");
			
			trabajo.setTemperatura(5);
			trabajo.setCondicionDelUsuario(Arrays.asList(camisaMangaLargaVerde));
			
			bautismo.setTemperatura(13);
			bautismo.setCondicionDelUsuario(Arrays.asList(pantalonDeVestirNegro,corbataVerde));
			
			usuario.agregarNuevoGuardarropa(guardarropa1);
			usuario.agregarEvento(trabajo);
			usuario.agregarEvento(bautismo);
			
			guardarropa1.agregarIndumentaria(new Indumentaria(remera,algodon,"blanco"));
			guardarropa1.agregarIndumentaria(new Indumentaria(camisaMangaLarga,algodon,"verde"));
			guardarropa1.agregarIndumentaria(new Indumentaria(sueter,lana,"negro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(campera,polar,"negro"));

			guardarropa1.agregarIndumentaria(new Indumentaria(pantalon,algodon,"azulOscuro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(pantalonDeVestir,algodon,"negro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(zapatos,cuero,"negro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(corbata,algodon,"verde"));

			sugerenciaSistema.realizarSugerencias(usuario);
			
			Atuendo atuendoTrabajo = trabajo.getSugerenciasAceptadas().get(0);
			Atuendo atuendoBautismo = bautismo.getSugerenciasAceptadas().get(0);
			
			List<String> parteSuperior = atuendoTrabajo.getParteSuperior();
			String parteInferior = atuendoTrabajo.getParteInferior();
			String calzado = atuendoTrabajo.getCalzado();
			
			List<String> parteSuperior1 = atuendoBautismo.getParteSuperior();
			String parteInferior1 = atuendoBautismo.getParteInferior();
			String calzado1 = atuendoBautismo.getCalzado();
			String accesorio1 = atuendoBautismo.getAccesorio();
			
			String[] trabajoArrayEsperadoPS = {"remera" , "camisaMangaLarga" , "sueter" , "campera" };
			String trabajoParteInferiorEsperado = "pantalon";
			String trabajoCalzadoEsperado = "zapatos";
			
			String[] bautismoArrayEsperadoPS = {"remera" , "camisaMangaLarga" , "sueter"};
			String bautismoParteInferiorEsperado = "pantalonDeVestir";
			String bautismoCalzadoEsperado = "zapatos";
			String bautismoAccesorioEsperado = "corbata";
			
			assertArrayEquals(trabajoArrayEsperadoPS,parteSuperior.toArray());
			assertEquals(trabajoParteInferiorEsperado,parteInferior);
			assertEquals(trabajoCalzadoEsperado,calzado);
			
			assertArrayEquals(bautismoArrayEsperadoPS,parteSuperior1.toArray());
			assertEquals(bautismoParteInferiorEsperado,parteInferior1);
			assertEquals(bautismoCalzadoEsperado,calzado1);
			assertEquals(bautismoAccesorioEsperado,accesorio1);
		}
		
		@Test
		public void generarAtuendosSinCondicionDelUsuario() {
			trabajo.setTemperatura(5);
			trabajo.setCondicionDelUsuario(Arrays.asList());
			
			usuario.agregarNuevoGuardarropa(guardarropa1);
			usuario.agregarEvento(trabajo);
			
			guardarropa1.agregarIndumentaria(new Indumentaria(remera,algodon,"blanco"));
			guardarropa1.agregarIndumentaria(new Indumentaria(camisaMangaLarga,algodon,"verde"));
			guardarropa1.agregarIndumentaria(new Indumentaria(sueter,lana,"negro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(campera,polar,"negro"));

			guardarropa1.agregarIndumentaria(new Indumentaria(pantalon,algodon,"azulOscuro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(pantalonDeVestir,algodon,"negro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(zapatos,cuero,"negro"));

			sugerenciaSistema.realizarSugerencias(usuario);
			
			Atuendo atuendo1Trabajo = trabajo.getSugerenciasAceptadas().get(0);
			Atuendo atuendo2Trabajo = trabajo.getSugerenciasAceptadas().get(1);
			
			//Atuendo1
			List<String> parteSuperior = atuendo1Trabajo.getParteSuperior();
			String parteInferior = atuendo1Trabajo.getParteInferior();
			String calzado = atuendo1Trabajo.getCalzado();
			
			String[] arrayEsperadoPS = {"remera" , "camisaMangaLarga" , "sueter" , "campera" };
			String parteInferiorEsperado = "pantalon";
			String calzadoEsperado = "zapatos";
			
			// Atuendo 2
			List<String> parteSuperior2 = atuendo2Trabajo.getParteSuperior();
			String parteInferior2 = atuendo2Trabajo.getParteInferior();
			String calzado2 = atuendo2Trabajo.getCalzado();
			
			String[] arrayEsperadoPS2 = {"remera" , "camisaMangaLarga" , "sueter" , "campera"};
			String parteInferiorEsperado2 = "pantalonDeVestir";
			String calzadoEsperado2 = "zapatos";
			
			assertArrayEquals(arrayEsperadoPS,parteSuperior.toArray());
			assertEquals(parteInferiorEsperado,parteInferior);
			assertEquals(calzadoEsperado,calzado);
			
			assertArrayEquals(arrayEsperadoPS2,parteSuperior2.toArray());
			assertEquals(parteInferiorEsperado2,parteInferior2);
			assertEquals(calzadoEsperado2,calzado2);
		}
		
}
