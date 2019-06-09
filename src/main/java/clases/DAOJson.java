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

public class DAOJson implements DAO{
	private String filePath;
	private Gson gson;
	private BufferedReader bufferToReader;
	private BufferedWriter bufferToWriter;

	public DAOJson() {
		this.gson = new GsonBuilder().setPrettyPrinting().create();
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public void add(Prenda prenda) throws IOException {
		this.writeJson(prenda);
	}
	
	public void delete(Prenda prenda) throws IOException {
		ArrayList<Prenda> prendas= new ArrayList<Prenda>();
		prendas.addAll((getAll()));
		prendas.removeIf(c->c.getDescripcion().equals(prenda.getDescripcion()));
		for(Prenda p: prendas) {
			this.add(p);
		}
	}
	
	public ArrayList<Prenda> getAll() throws JsonSyntaxException, IOException{
		FileReader reader = new	FileReader(this.filePath);
		this.bufferToReader = new BufferedReader(reader);
		ArrayList<Prenda> prendas = this.gson.fromJson(getJson(), new TypeToken<ArrayList<Prenda>>(){}.getType());
		return prendas;
		
	}
	
	public void update(Prenda objeto) {
		
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

	private void writeJson(Prenda prenda) throws IOException{
		ArrayList<Prenda> prendas= new ArrayList<Prenda>();
		
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
