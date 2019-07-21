package clases;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.Test;

public class TestEventos {
	
	// Ubicacion
	Ubicacion buenosAires = new Ubicacion(-34.6131500,-58.3772300);
	
	//Evento
	Evento trabajo = new Evento("trabajo",LocalDate.parse("2019-07-13"),buenosAires);
	
	// API Clima
	ServicioA apiClima = new ServicioA();
	
	// Generador de Sugerencias
	SugerenciaInvierno si = new SugerenciaInvierno();
	SugerenciaVerano sv = new SugerenciaVerano();
	
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
		Usuario usuario2Gratuito = new Usuario("usuario","Gratuito");

		@Test
		public void obtenerTemperaturaDelEvento() {
							
			usuario2Gratuito.agregarEvento(trabajo);
			Evento e = usuario2Gratuito.getListaEventos().get(0);
			
			System.out.print("Temperatura del Evento: ");
			System.out.println(apiClima.getTemperatura(e));
			System.out.println("");
		}
						
			@Test
			public void generarAtuendosConPrendasAnidadasSegunEvento() {
							
				usuario2Gratuito.agregarNuevoGuardarropa(guardarropa1);
				usuario2Gratuito.agregarEvento(trabajo);

				guardarropa1.agregarIndumentaria(new Indumentaria(remera,algodon,"blanco"));
				guardarropa1.agregarIndumentaria(new Indumentaria(camisaMangaLarga,algodon,"verde"));
				guardarropa1.agregarIndumentaria(new Indumentaria(sueter,lana,"negro"));
				guardarropa1.agregarIndumentaria(new Indumentaria(campera,polar,"negro"));
				
				guardarropa1.agregarIndumentaria(new Indumentaria(pantalon,algodon,"azulOscuro"));
				guardarropa1.agregarIndumentaria(new Indumentaria(zapatos,cuero,"negro"));
				guardarropa1.agregarIndumentaria(new Indumentaria(bufanda,lana,"rojo"));
				
				Evento e = usuario2Gratuito.getListaEventos().get(0);
				
				if(apiClima.getTemperatura(e) < 15) {
					System.out.println("Test Generar Atuendos con Prendas Anidadas Segun Evento:");
					si.generarSugerencias(usuario2Gratuito);
					System.out.println("");
				} else {
					System.out.println("Test Generar Atuendos con Prendas Anidadas Segun Evento:");
					sv.generarSugerencias(usuario2Gratuito);
					System.out.println("");
				}
			}
					
			@Test
			public void generarAtuendosConPrendasAnidadasSegunEvento2() {
							
				usuario2Gratuito.agregarNuevoGuardarropa(guardarropa1);
				usuario2Gratuito.agregarEvento(trabajo);
				
				guardarropa1.agregarIndumentaria(new Indumentaria(remera,algodon,"blanco"));
				
				guardarropa1.agregarIndumentaria(new Indumentaria(pantalon,algodon,"azulOscuro"));
				guardarropa1.agregarIndumentaria(new Indumentaria(zapatos,cuero,"negro"));
				guardarropa1.agregarIndumentaria(new Indumentaria(bufanda,lana,"rojo"));
				
				Evento e = usuario2Gratuito.getListaEventos().get(0);
							
				if(apiClima.getTemperatura(e) + 10 < 15) {
					System.out.println("Test Generar Atuendos con Prendas Anidadas Segun Evento2:");
					si.generarSugerencias(usuario2Gratuito);
					System.out.println("");
				} else {
					System.out.println("Test Generar Atuendos con Prendas Anidadas Segun Evento2:");
					sv.generarSugerencias(usuario2Gratuito);
					System.out.println("");
				}
			}

}
