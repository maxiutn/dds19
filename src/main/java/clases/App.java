package clases;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Premium usuario = new Premium("Pier");
		//Guardarropa g1 = new Guardarropa("guardarropa uno");
		/*Categoria categoria = new Categoria("Parte Superior");
		
		Tela algodon = new Tela("Algodon");
		Tela cuero = new Tela("Cuero");
		Tela frizado = new Tela("Frizado");
		
		List<Tela> telas = new ArrayList<Tela>();		
		telas.add(algodon);
		
		List<Tela> telas2 = new ArrayList<Tela>();		
		telas2.add(cuero);
		telas2.add(frizado);		
		
		TipoDePrenda campera = new TipoDePrenda("Campera",telas2,categoria,20);
		Indumentaria prendaCampera = new Indumentaria(campera,algodon,"azul");
		
		g1.agregarIndumentaria(prendaCampera);*/
		
		//-----------------------------
		
		ServicioA servicio = new ServicioA();

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
		Tela jeans = new Tela("jean's");
		//Tela plastico = new Tela("plastico");
				
		//Lista Tipo de telas aceptables
		List<Tela> telasCampera = new ArrayList<Tela>();
		telasCampera.add(cuero);
		
		List<Tela> telasRemera = new ArrayList<Tela>();
		telasRemera.add(algodon);
		telasRemera.add(laycra);
		
		List<Tela> telasPantalon = new ArrayList<Tela>();
		telasPantalon.add(jeans);	
		
		List<Tela> telasCalzado = new ArrayList<Tela>();
		telasCalzado.add(cuero);
		telasCalzado.add(jeans);
		
		// Tipo de Prendas
		TipoDePrenda campera = new TipoDePrenda("Campera",telasCampera,parteSuperior,20);
		TipoDePrenda remera = new TipoDePrenda("Remera",telasRemera,parteSuperior,15);		
		TipoDePrenda pantalon = new TipoDePrenda("Pantalon",telasPantalon,parteInferior,20);
		TipoDePrenda zapato = new TipoDePrenda("Zapato",telasCalzado,calzado,15);
		TipoDePrenda zapatilla = new TipoDePrenda("Zapatilla",telasCalzado,calzado,15);
		
		// Parte Superior
		Indumentaria prendaCampera = new Indumentaria(campera,cuero,"negro");
		Indumentaria chomba = new Indumentaria(remera,algodon,"azul");
		
		// Parte Inferior
		Indumentaria prendaPantalon = new Indumentaria(pantalon,jeans,"azul");
		
		// Calzado
		Indumentaria prendaZapato = new Indumentaria(zapatilla,jeans,"blanco");
		Indumentaria botas = new Indumentaria(zapato,cuero,"marron");
		
		// Accesorios
		//TipoDePrenda anteojosDeSol = new TipoDePrenda("anteojosDeSol","accesorio");
		//Indumentaria panuelo = new Indumentaria("pañuelo",Arrays.asList(algodon),accesorio);
			
		usuario.agregarNuevoGuardarropa(guardarropa1);
		guardarropa1.agregarIndumentaria(prendaCampera);
		guardarropa1.agregarIndumentaria(chomba);
		guardarropa1.agregarIndumentaria(prendaPantalon);
		guardarropa1.agregarIndumentaria(prendaZapato);
		
		
		Ubicacion ubicacion = new Ubicacion(-34.6088891,-58.406088200000006);
		
		Evento evento = new Evento("facultad",LocalDate.now(),ubicacion);
		
		double temperatura = servicio.getTemperatura(evento);
		
		SugerenciaStrategy sugerenciaSistema;
		
		if(temperatura > 10) {
			sugerenciaSistema = new SugerenciaVerano();
		}else {
			sugerenciaSistema = new SugerenciaInvierno();
		}
		
		sugerenciaSistema.generarSugerencias(usuario);

	}

}
