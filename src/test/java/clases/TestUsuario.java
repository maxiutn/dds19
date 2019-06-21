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
public class TestUsuario {
	
	private JSONUsuario jsonUsuario;
	private Usuario usuario;
	private Guardarropa guardarropa1;
	
	@Before
	public void init() throws IOException{
		jsonUsuario = new JSONUsuario();
		jsonUsuario.setFilePath("usuarios.json");	
		this.usuario = new Usuario("Pier");
		this.guardarropa1 = new Guardarropa("guardarropaUno");
	}
	
	@After
	public void reiniciarEstadoInit()throws IOException{
		jsonUsuario = new JSONUsuario();
		jsonUsuario.setFilePath("usuarios.json");
	}
	
	@Test
	public void persistirUsuario() throws IOException {
		usuario.setGuardarropa(guardarropa1);
		jsonUsuario.add(this.usuario);
		Assert.assertTrue(jsonUsuario.getAll().size()==1);		
	}
}
