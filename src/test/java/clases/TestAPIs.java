package clases;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestAPIs {
	
		Ubicacion buenosAires = new Ubicacion(-34.6131500,-58.3772300);
		Ubicacion mendoza = new Ubicacion(-32.8908400,-68.8271700);
		
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
		//Nota: cambiar las temperaturas cuando cambia el dia
		@Test
		public void obtenerTemperaturaDeUnaCiudad() {
			adaptador.agregarServicio(servicioOpenWeather);
			adaptador.setServicio();
			assertEquals(15,adaptador.recibirTemperatura(buenosAires),2.0);
		}
		
		@Test
		public void obtenerTemperaturasDeDosCiudades() {
				adaptador.agregarServicio(servicioDarkSkyWeather);
				adaptador.setServicio();
				assertEquals(15,adaptador.recibirTemperatura(buenosAires),4.0);
				assertEquals(20,adaptador.recibirTemperatura(mendoza),4.0);
		}
}