package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class JSONGuardarropa {
	private String filePath;
	private Gson gson;
	private BufferedReader bufferToReader;
	private BufferedWriter bufferToWriter;

	public JSONGuardarropa() {
		this.gson = new GsonBuilder().setPrettyPrinting().create();
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public void add(Guardarropa guardarropa) throws IOException {
		this.writeJson(guardarropa);
	}
	
	public void delete(Guardarropa guardarropa) throws IOException {
		ArrayList<Guardarropa> guardarropas= new ArrayList<Guardarropa>();
		guardarropas.addAll((getAll()));
		if(guardarropas.contains(guardarropa)) {
			guardarropas.remove(guardarropa);
			for(Guardarropa g: guardarropas) {
				this.add(g);
			}
		}		
	}
	
	public ArrayList<Guardarropa> getAll() throws JsonSyntaxException, IOException{
		FileReader reader = new	FileReader(filePath);
		bufferToReader = new BufferedReader(reader);
		ArrayList<Guardarropa> guardarropas = gson.fromJson(getJson(), new TypeToken<ArrayList<Guardarropa>>(){}.getType());
		return guardarropas;
		
	}
	
	public void update(Guardarropa guardarropa) {
		
	}

	private String getJson() throws IOException{
		StringBuilder clienteSerializada = new StringBuilder();
		String linea;
		while( (linea=this.bufferToReader.readLine()) != null){
			clienteSerializada.append(linea);
		};
		this.bufferToReader.close();
		return clienteSerializada.toString();
	}

	private void writeJson(Guardarropa guardarropa) throws IOException{
		ArrayList<Guardarropa> guardarropas= new ArrayList<Guardarropa>();
		
		if(getAll()!=null) {
			guardarropas.addAll((getAll()));
		}
		
		guardarropas.add(guardarropa);
		
		String guardarropasString= this.gson.toJson(guardarropas);
	
		PrintWriter pw = new PrintWriter(this.filePath);
		pw.close();
		
		this.bufferToWriter = new BufferedWriter(new FileWriter(this.filePath, true));
		this.bufferToWriter.write(guardarropasString);
		this.bufferToWriter.close();
	}
	
	/*
	public Gson getMyGson() {
		return gson;
	}
	*/
/*
	public BufferedReader getBufferToReader() {
		return bufferToReader;
	}


	public BufferedWriter getBufferToWrite() {
		return bufferToWriter;
	}

	
	public String getFilePath() {
		return filePath;
	}
	
	*/
}
