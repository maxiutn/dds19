package clases;
		
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
		
public class Ejemplo2JsonTest {
	private String filePath;
	private Gson gson;
	private BufferedReader bufferToReader;
	private BufferedWriter bufferToWriter;
		
	@Test
	public void obtenerLista() throws JsonParseException, IOException {
		
		DAOJson dj = new DAOJson();
		dj.setFilePath("prendas.json");
		System.out.println(dj.getAll());
		dj.getAll().stream().forEach(p -> System.out.println(p.descripcion));
		
	}
}