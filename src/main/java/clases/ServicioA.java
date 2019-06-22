package clases;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class ServicioA extends ServicioClima{
	
	public ServicioA() {
		
	}
	
	public double getTemperatura(Evento e) {
		try {

            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?lat="+e.getUbicacion().getLatitud()+"&lon="+e.getUbicacion().getLongitud()+"&APPID=1a64185d78a4d75ff65a0ed724e83530");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
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
}
