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
	private Indumentaria indumentaria;
	private TipoDePrenda campera,remera;
	private Categoria categoria;
	private List<Tela> telas, telas2;
	private Tela algodon,cuero,frizado;
	
	@Before
	public void init() throws IOException{
		jsonUsuario = new JSONUsuario();
		jsonUsuario.setFilePath("usuarios.json");	
		this.usuario = new Gratuito("Pier");
		this.guardarropa1 = new Guardarropa("guardarropaUno");
		
		categoria = new Categoria("Parte Superior");
		
		algodon = new Tela("Algodon");
		cuero = new Tela("Cuero");
		frizado = new Tela("Frizado");
		
		telas = new ArrayList<Tela>();		
		telas.add(algodon);
		
		telas2 = new ArrayList<Tela>();		
		telas2.add(cuero);
		telas2.add(frizado);		
		
		this.remera = new TipoDePrenda("Remera",telas,categoria,15);
		this.campera = new TipoDePrenda("Campera",telas2,categoria,20);
	}
	
	@After
	public void reiniciarEstadoInit()throws IOException{
		jsonUsuario = new JSONUsuario();
		jsonUsuario.setFilePath("usuarios.json");
	}
	
	@Test
	public void persistirUsuario() throws IOException {
		Indumentaria prendaCampera = new Indumentaria(campera,cuero,"negro");
		guardarropa1.agregarIndumentaria(prendaCampera);
		usuario.setGuardarropa(guardarropa1);
		jsonUsuario.add(this.usuario);
		Assert.assertTrue(jsonUsuario.getAll().size()==1);		
	}
}
