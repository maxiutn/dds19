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
public class TestIndumentaria {
	
	private JSONIndumentaria jsonIndumentaria;
	private Indumentaria indumentaria;
	private TipoDePrenda campera;
	//private Guardarropa guardarropa1;
	private Categoria categoria;
	private List<Tela> telas, telas2;
	private Tela algodon,cuero,frizado;
	
	@Before
	public void init() throws IOException{
		jsonIndumentaria = new JSONIndumentaria();
		jsonIndumentaria.setFilePath("indumentarias.json");	
		
		categoria = new Categoria("Parte Superior");
		
		algodon = new Tela("Algodon");
		cuero = new Tela("Cuero");
		frizado = new Tela("Frizado");
		
		telas = new ArrayList<Tela>();		
		telas.add(algodon);
		
		telas2 = new ArrayList<Tela>();		
		telas2.add(cuero);
		telas2.add(frizado);		
		
		this.campera = new TipoDePrenda("Campera",telas2,categoria);
		//this.guardarropa1 = new Guardarropa("guardarropaUno");
	}
	
	@After
	public void reiniciarEstadoInit()throws IOException{
		jsonIndumentaria = new JSONIndumentaria();
		jsonIndumentaria.setFilePath("indumentarias.json");	
	}
	/*
	@Test
	public void persistirIndumentaria() throws IOException {
		Indumentaria prendaCampera = new Indumentaria(campera,cuero,"negro");
		jsonIndumentaria.add(prendaCampera);
		Assert.assertTrue(jsonIndumentaria.getAll().size()==1);		
	}*/
	
	@Test
	public void agregar() throws IOException {
		Indumentaria prendaCampera = new Indumentaria(campera,algodon,"azul");
		jsonIndumentaria.add(prendaCampera);
		Assert.assertTrue(jsonIndumentaria.getAll().size()==1);		
	}
}
