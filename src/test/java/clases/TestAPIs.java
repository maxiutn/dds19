package clases;

import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestAPIs {
		
		// API Clima
		ServicioA servicioOpenWeather = new ServicioA();
		ServicioB servicioDarkSkyWeather = new ServicioB();
		
		// Adaptador
		Adapter adaptador = new Adapter();
			
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
		}
			
		@Test
		public void fallarConexionesAPIs() {
			servicioOpenWeather.verificarConexion(404);
			servicioDarkSkyWeather.verificarConexion(404);
			assertFalse(servicioOpenWeather.estaDisponible());
			assertFalse(servicioDarkSkyWeather.estaDisponible());
		}
		
		@Test
		public void establecerServicioOpenWeather() {
			try {
				servicioOpenWeather.establecerConexion();
				servicioDarkSkyWeather.establecerConexion();
			} catch (IOException e) {
				e.printStackTrace();
			}
			adaptador.agregarServicio(servicioOpenWeather);
			adaptador.agregarServicio(servicioDarkSkyWeather);
			adaptador.setServicio();
			assertEquals(adaptador.servicio(),"OpenWeather");
		}
		
		@Test
		public void establecerServicioDarkSkyWeather() {
			servicioOpenWeather.verificarConexion(404);
			try {
				servicioDarkSkyWeather.establecerConexion();
			} catch (IOException e) {
				e.printStackTrace();
			}
			adaptador.agregarServicio(servicioOpenWeather);
			adaptador.agregarServicio(servicioDarkSkyWeather);
			adaptador.setServicio();
			assertEquals(adaptador.servicio(),"DarkSkyWeather");
		}
		
		@Test
		public void noHayServicio() {
			servicioOpenWeather.verificarConexion(404);
			servicioDarkSkyWeather.verificarConexion(404);
			adaptador.agregarServicio(servicioOpenWeather);
			adaptador.agregarServicio(servicioDarkSkyWeather);
			adaptador.setServicio();
			assertTrue(adaptador.noHayServicio());
		}
}