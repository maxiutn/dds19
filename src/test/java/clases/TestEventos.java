package clases;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

import org.junit.Test;

public class TestEventos {
	
	// Ubicacion
	Ubicacion buenosAires = new Ubicacion(-34.6131500,-58.3772300);
	
	// API Clima
	ServicioA servicioOpenWeather = new ServicioA();
	ServicioB servicioDarkSkyWeather = new ServicioB();
	ServicioClima servicio = servicioOpenWeather;
	
	// Adaptador
	Adapter adaptador = new Adapter();
	
	
	//Evento
	//Evento trabajo = new Evento("trabajo",LocalDate.parse("2019-07-22"),buenosAires,servicioOpenWeather);
	//Evento bautismo = new Evento("bautismo",LocalDate.parse("2019-07-22"),buenosAires,servicioOpenWeather);
	//Evento partido = new Evento("ver un partido",LocalDate.parse("2019-07-22"),buenosAires,servicioOpenWeather);
	//Evento fiestaAmigos = new Evento("fiesta con amigos",LocalDate.parse("2019-08-12"),buenosAires,adaptador);
	
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
		
		@Test
		public void establecerConexionesAPIs() {
		try {
			servicioOpenWeather.establecerConexion();
			servicioDarkSkyWeather.establecerConexion();
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue(servicioOpenWeather.estaDisponible());
		assertTrue(servicioDarkSkyWeather.estaDisponible());
		/*	
			adaptador.agregarServicio(servicioOpenWeather);
			adaptador.agregarServicio(servicioDarkSkyWeather);
			adaptador.setServicio();
			System.out.println(adaptador.servicio());
		*/
		}
		
		@Test
		public void fallarConexionesAPIs() {
			servicioOpenWeather.verificarConexion(404);
			servicioDarkSkyWeather.verificarConexion(404);
			assertFalse(servicioOpenWeather.estaDisponible());
			assertFalse(servicioDarkSkyWeather.estaDisponible());
		}
		
		
		/*
		@Test
		public void generarAtuendosConPrendasAnidadasParaUnEvento() {
							
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
			
			System.out.println("");
			System.out.println("");
		}
			
		@Test
		public void generarAtuendosConPrendasAnidadasParaDosEventos() {
							
			usuario.agregarNuevoGuardarropa(guardarropa1);
			usuario.agregarEvento(trabajo);
			usuario.agregarEvento(bautismo);
			
			guardarropa1.agregarIndumentaria(new Indumentaria(remera,algodon,"blanco"));
			guardarropa1.agregarIndumentaria(new Indumentaria(camisaMangaLarga,algodon,"verde"));
			guardarropa1.agregarIndumentaria(new Indumentaria(sueter,lana,"negro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(campera,polar,"negro"));
				
			guardarropa1.agregarIndumentaria(new Indumentaria(pantalon,algodon,"azulOscuro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(zapatos,cuero,"negro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(bufanda,lana,"rojo"));
				
			sugerenciaSistema.realizarSugerencias(usuario);
			
			System.out.println("");
			System.out.println("");
		}
		
		@Test
		public void generarAtuendosConPrendasAnidadasParaVariosEventos() {
							
			usuario.agregarNuevoGuardarropa(guardarropa1);
			usuario.agregarEvento(trabajo);
			usuario.agregarEvento(bautismo);
			usuario.agregarEvento(partido);
			
			guardarropa1.agregarIndumentaria(new Indumentaria(remera,algodon,"blanco"));
			guardarropa1.agregarIndumentaria(new Indumentaria(camisaMangaLarga,algodon,"verde"));
			guardarropa1.agregarIndumentaria(new Indumentaria(sueter,lana,"negro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(campera,polar,"negro"));
				
			guardarropa1.agregarIndumentaria(new Indumentaria(pantalon,algodon,"azulOscuro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(zapatos,cuero,"negro"));
			guardarropa1.agregarIndumentaria(new Indumentaria(bufanda,lana,"rojo"));
				
			sugerenciaSistema.realizarSugerencias(usuario);
			
			System.out.println("");
			System.out.println("");
		}
		*/
}
