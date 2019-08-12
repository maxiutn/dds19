package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class ServicioA implements ServicioClima {
	
	private String servicio = "OpenWeather";
	private boolean estaDisponible;
	
	public void establecerConexion() throws IOException {
		URL url = new URL("http://api.openweathermap.org/data/2.5/weather?lat=-34.9214516&lon=-57.9545288&APPID=1a64185d78a4d75ff65a0ed724e83530");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        int responseCode = conn.getResponseCode();
        this.verificarConexion(responseCode);
	}
	
	public void verificarConexion(int codigoDeRespuesta) {
		if(codigoDeRespuesta != 200) {
        	this.estaDisponible = false;
        } else {
        	this.estaDisponible = true;
        }
	}
	
	public double getTemperatura(Ubicacion ciudad) {
		try {

            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?lat="+ciudad.getLatitud()+"&lon="+ciudad.getLongitud()+"&APPID=1a64185d78a4d75ff65a0ed724e83530");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            //if (conn.getResponseCode() != 200) {throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());}
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            double temperatura = 0;
            while ((output = br.readLine()) != null) {
            	JSONObject obj = new JSONObject(output);
                JSONObject pageName = (JSONObject) obj.getJSONObject("main");
                temperatura = pageName.getInt("temp");
            }
            conn.disconnect();

            return (temperatura - 273.15);

        } catch (Exception ex) {
            //System.out.println("Exception in NetClientGet:- " + e);
            //return -1;
        }
		return 0;
	}
	
	public boolean estaDisponible() {
		return this.estaDisponible;
	}
	
	public String servicio() {
		return this.servicio;
	}
}
