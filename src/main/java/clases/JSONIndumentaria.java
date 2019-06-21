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

public class JSONIndumentaria implements DAO{
	private String filePath;
	private Gson gson;
	private BufferedReader bufferToReader;
	private BufferedWriter bufferToWriter;

	public JSONIndumentaria() {
		this.gson = new GsonBuilder().setPrettyPrinting().create();
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public void add(Indumentaria prenda) throws IOException {
		this.writeJson(prenda);
	}
	
	public void delete(Indumentaria prenda) throws IOException {
		ArrayList<Indumentaria> prendas= new ArrayList<Indumentaria>();
		prendas.addAll((getAll()));
		if(prendas.contains(prenda)) {
			prendas.remove(prenda);
			for(Indumentaria p: prendas) {
				this.add(p);
			}
		}		
	}
	
	public ArrayList<Indumentaria> getAll() throws JsonSyntaxException, IOException{
		FileReader reader = new	FileReader(this.filePath);
		this.bufferToReader = new BufferedReader(reader);
		ArrayList<Indumentaria> prendas = this.gson.fromJson(getJson(), new TypeToken<ArrayList<Indumentaria>>(){}.getType());
		return prendas;
		
	}
	
	public void update(Indumentaria objeto) {
		
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

	private void writeJson(Indumentaria prenda) throws IOException{
		ArrayList<Indumentaria> prendas= new ArrayList<Indumentaria>();
		
		if(getAll()!=null) {
			prendas.addAll((getAll()));
		}
		
		prendas.add(prenda);
		
		String prendasString= this.gson.toJson(prendas);
	
		PrintWriter pw = new PrintWriter(this.filePath);
		pw.close();
		
		this.bufferToWriter = new BufferedWriter(new FileWriter(this.filePath, true));
		this.bufferToWriter.write(prendasString);
		this.bufferToWriter.close();
	}

	/*
	public Gson getMyGson() {
		return gson;
	}
	

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
