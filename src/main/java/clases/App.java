package clases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		DAOJson jsonPrenda = new DAOJson();
		jsonPrenda.setFilePath("prendas.json");

		//creo tipo de prenda
		TipoDePrenda tipo_prenda = new TipoDePrenda("tipo prenda","categoria adecuada");
		
		//creo tipo de tela
		ArrayList<String> list = new ArrayList<String>();  
		list.add("tipo 1");  
	    list.add("tipo 2");  
		TipoDeTela tipo_tela = new TipoDeTela(list);
		
		//creo categoria
		Categoria categoria = new Categoria("categoria C1");
		
		//agrego una prenda
		Prenda prenda = new Prenda("remera", tipo_prenda, tipo_tela, categoria, "Rojo");
		
		//agrego prenda al archivo json
		jsonPrenda.add(prenda);
		
		//ahora traigo todas las prenda y muestro la descripción
		List<Prenda> listadoPrendas = jsonPrenda.getAll();
		
		for(Prenda p: listadoPrendas) {
			System.out.println(p.getDescripcion());
		}
	}

}
