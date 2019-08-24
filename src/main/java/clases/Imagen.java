package clases;

import java.awt.image.*; 
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;



public class Imagen {
	private double tamanio;
	private URL direccion;
	private BufferedImage imagen;
	
	public Imagen(String dirURL){
		try {
			this.direccion = new URL(dirURL);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.imagen = ImageIO.read(this.direccion);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DataBuffer dataBuffer = imagen.getData().getDataBuffer();

		// Each bank element in the data buffer is a 32-bit integer
		long sizeBytes = ((long) dataBuffer.getSize()) * 4l;
		long sizeMB = sizeBytes / (1024l * 1024l);
		
		this.tamanio = sizeMB;
		
	}
	
	public URL getFuenteImagen(){
		return this.direccion;
	}
	
	/*
	public BufferedImage getImagen(){
		return this.imagen;
	}
	*/
}
