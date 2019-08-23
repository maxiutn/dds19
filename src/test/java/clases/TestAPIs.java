package clases;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestAPIs {
		
		// API Clima
		ServicioA servicioOpenWeather = new ServicioA();
		ServicioB servicioDarkSkyWeather = new ServicioB();
		
		// Adaptador
		Adapter adaptador = new Adapter();
			
		@Test
		public void establecerServicioA() {
			adaptador.agregarServicio(servicioOpenWeather);
			adaptador.agregarServicio(servicioDarkSkyWeather);
			adaptador.setServicio();
			
			assertEquals("OpenWeather",servicioOpenWeather.servicio());
		}
			
		@Test
		public void establecerServicioB() {
			adaptador.agregarServicio(servicioDarkSkyWeather);
			adaptador.setServicio();
			
			assertEquals("DarkSkyWeather",adaptador.servicio());
		}
		
		@Test
		public void noHayServicio() {
			adaptador.setServicio();
			assertTrue(adaptador.noHayServicio());
		}
}