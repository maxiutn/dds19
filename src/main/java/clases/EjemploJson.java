package clases;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class EjemploJson {

	public static void main(String[] args) {

		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();

		Type listType = new TypeToken<List<Prenda>>() {
		}.getType();

		// final String prendas =
		// "[{\"tipoDePrenda\":{},\"tipoDeTela\":{},\"categoria\":{},\"color\":green,\"descripcion\":remera\"}]";
		final String prendas = "[{\"tipoDePrenda\":{},\"tipoDeTela\":{},\"categoria\":{\"categoria\":\"categoria C1\"},\"color\":green,\"descripcion\":remera\"}]";
		
		
		List<Prenda> Prendas = gson.fromJson(prendas, listType);
		System.out.println("TEXT : " + Prendas.get(0).categoria());
	}
}