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

public class JSONUsuario {
	private String filePath;
	private Gson gson;
	private BufferedReader bufferToReader;
	private BufferedWriter bufferToWriter;

	public JSONUsuario() {
		this.gson = new GsonBuilder().setPrettyPrinting().create();
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public void add(Usuario usuario) throws IOException {
		this.writeJson(usuario);
	}
	
	public void delete(Usuario usuario) throws IOException {
		ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
		usuarios.addAll((getAll()));
		if(usuarios.contains(usuario)) {
			usuarios.remove(usuario);
			for(Usuario u: usuarios) {
				this.add(u);
			}
		}		
	}
	
	public ArrayList<Usuario> getAll() throws JsonSyntaxException, IOException{
		FileReader reader = new	FileReader(filePath);
		bufferToReader = new BufferedReader(reader);
		ArrayList<Usuario> usuarios = gson.fromJson(getJson(), new TypeToken<ArrayList<Usuario>>(){}.getType());
		return usuarios;
		
	}
	
	public void update(Usuario usuario) {
		
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

	private void writeJson(Usuario usuario) throws IOException{
		ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
		
		if(getAll()!=null) {
			usuarios.addAll((getAll()));
		}
		
		usuarios.add(usuario);
		
		String usuariosString= this.gson.toJson(usuarios);
	
		PrintWriter pw = new PrintWriter(this.filePath);
		pw.close();
		
		this.bufferToWriter = new BufferedWriter(new FileWriter(this.filePath, true));
		this.bufferToWriter.write(usuariosString);
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
