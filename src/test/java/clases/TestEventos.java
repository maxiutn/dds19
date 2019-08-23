package clases;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
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
	Evento trabajo = new Evento("trabajo",LocalDate.parse("2019-08-23"),buenosAires,adaptador);
	Evento bautismo = new Evento("bautismo",LocalDate.parse("2019-08-23"),mendoza,adaptador);
	
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
		TipoDePrenda falda = new TipoDePrenda("falda",Arrays.asList(algodon),parteInferior,5);
								
		// Calzado
		TipoDePrenda zapatillas = new TipoDePrenda("zapatilla",Arrays.asList(lona,cuero,nylon),calzado,5);
		TipoDePrenda botas = new TipoDePrenda("botas",Arrays.asList(cuero),calzado,5);
		TipoDePrenda zapatos = new TipoDePrenda("zapatos",Arrays.asList(cuero),calzado,5);
								
		// Accesorios
		TipoDePrenda bufanda = new TipoDePrenda("bufanda",Arrays.asList(lana),accesorio,0);
								
		// Usuarios
		Usuario usuario = new Usuario("Usuario","Gratuito");
		/*
		@Test
		public void obtenerTemperaturaDeUnaCiudad() {
			adaptador.agregarServicio(servicioOpenWeather);
			adaptador.agregarServicio(servicioDarkSkyWeather);
			adaptador.setServicio();
			assertEquals(11,adaptador.recibirTemperatura(buenosAires),1.5);
		}
		
		@Test
		public void obtenerTemperaturasDeDosCiudades() {
				adaptador.agregarServicio(servicioOpenWeather);
				adaptador.agregarServicio(servicioDarkSkyWeather);
				adaptador.setServicio();
				bautismo.setTemperatura(mendoza);
				trabajo.setTemperatura(buenosAires);
				assertEquals(14,bautismo.getTemperatura(),1.5); //revisar temperatura de mendoza
				assertEquals(11,trabajo.getTemperatura(),1.5);
		}
		*/
		
		@Test
		public void generarAtuendosConPrendasAnidadasParaUnEvento() {
			adaptador.agregarServicio(servicioOpenWeather);
			adaptador.agregarServicio(servicioDarkSkyWeather);
			adaptador.setServicio();
			trabajo.setTemperatura(buenosAires);
			
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
			
			Atuendo atuendo = guardarropa1.getAtuendos().get(0);
			List<String> parteSuperior = atuendo.getParteSuperior();
			String parteInferior = atuendo.getParteInferior();
			String calzado = atuendo.getCalzado();
			String accesorio = atuendo.getAccesorio();
			
			String[] arrayEsperadoPS = {"remera" , "camisaMangaLarga" , "sueter" ,"campera"};
			String parteInferiorEsperado = "pantalon";
			String calzadoEsperado = "zapatos";
			String accesorioEsperado = "bufanda";
			
			assertArrayEquals(arrayEsperadoPS,parteSuperior.toArray());
			assertEquals(parteInferiorEsperado,parteInferior);
			assertEquals(calzadoEsperado,calzado);
			assertEquals(accesorioEsperado,accesorio);
		}
		/*
		@Test
		public void generarAtuendosConPrendasAnidadasParaDosEventos() {
			adaptador.agregarServicio(servicioOpenWeather);
			adaptador.agregarServicio(servicioDarkSkyWeather);
			adaptador.setServicio();
			trabajo.setTemperatura(buenosAires);
							
			usuario.agregarNuevoGuardarropa(guardarropa1);
			usuario.agregarEvento(trabajo);
			usuario.agregarEvento(bautismo);
			
			guardarropa1.agregarIndumentaria(new Indumentaria(remera,algodon,"blanco"));
			guardarropa1.agregarIndumentaria(new Indumentaria(camisaMangaLarga,algodon,"verde"));
			guardarropa1.agregarIndumentaria(new Indumentaria(sueter,lana,"negro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(saco,tweed,"azulOscuro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(campera,polar,"negro"));

			guardarropa1.agregarIndumentaria(new Indumentaria(pantalon,algodon,"azulOscuro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(zapatos,cuero,"negro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(bufanda,lana,"rojo"));

			sugerenciaSistema.realizarSugerencias(usuario);
			
			Atuendo atuendo = guardarropa1.getAtuendos().get(0);
			Atuendo otroAtuendo = guardarropa1.getAtuendos().get(1);
			
			List<String> parteSuperior = atuendo.getParteSuperior();
			String parteInferior = atuendo.getParteInferior();
			String calzado = atuendo.getCalzado();
			String accesorio = atuendo.getAccesorio();
			
			List<String> parteSuperior1 = otroAtuendo.getParteSuperior();
			String parteInferior1 = otroAtuendo.getParteInferior();
			String calzado1 = otroAtuendo.getCalzado();
			String accesorio1 = otroAtuendo.getAccesorio();
			
			String[] arrayEsperadoPS = {"remera" , "camisaMangaLarga" , "sueter" ,"campera"};
			String parteInferiorEsperado = "pantalon";
			String calzadoEsperado = "zapatos";
			String accesorioEsperado = "bufanda";
			
			String[] arrayEsperadoPS1 = {"remera" , "camisaMangaLarga" , "saco" ,"campera"};
			String parteInferiorEsperado1 = "pantalon";
			String calzadoEsperado1 = "zapatos";
			String accesorioEsperado1 = "bufanda";
			
			assertArrayEquals(arrayEsperadoPS,parteSuperior.toArray());
			assertEquals(parteInferiorEsperado,parteInferior);
			assertEquals(calzadoEsperado,calzado);
			assertEquals(accesorioEsperado,accesorio);
			
			assertArrayEquals(arrayEsperadoPS1,parteSuperior1.toArray());
			assertEquals(parteInferiorEsperado1,parteInferior1);
			assertEquals(calzadoEsperado1,calzado1);
			assertEquals(accesorioEsperado1,accesorio1);
		}
		*/
}
