package clases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class TestGuardarropa {
	
	private JSONGuardarropa jsonGuardarropa;
	private Guardarropa guardarropa1;
	
	@Before
	public void init() throws IOException{
		jsonGuardarropa = new JSONGuardarropa();
		jsonGuardarropa.setFilePath("guardarropas.json");	
		this.guardarropa1 = new Guardarropa("guardarropaUno");
	}
	
	@After
	public void reiniciarEstadoInit()throws IOException{
		jsonGuardarropa = new JSONGuardarropa();
		jsonGuardarropa.setFilePath("guardarropas.json");
	}
	
	@Test
	public void persistirGuardarropa() throws IOException {
		jsonGuardarropa.add(this.guardarropa1);
		Assert.assertTrue(jsonGuardarropa.getAll().size()==1);		
	}
}
