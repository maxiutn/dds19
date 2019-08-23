package clases;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class ServicioB implements ServicioClima {
	
	private String servicio = "DarkSkyWeather";
	
	public double getTemperatura(Ubicacion ciudad) {
		try {
            URL url = new URL("https://api.darksky.net/forecast/a1f3b3b6357a3aa519aa6c87589fac57/" + ciudad.getLatitud() + "," + ciudad.getLongitud());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) { throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());}
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            double temperatura = 0;
            while ((output = br.readLine()) != null) {
            	JSONObject obj = new JSONObject(output);
                JSONObject pageName = (JSONObject) obj.getJSONObject("currently");
                temperatura = pageName.getInt("temperature");
            }
            conn.disconnect();

            return ((temperatura - 32) * 5 / 9) + 3; //sumo tres porque hay un margen de error de casi tres grados (La tempde la api esta en farenheit)

        } catch (Exception ex) {
            //System.out.println("Exception in NetClientGet:- " + e);
            //return -1;
        }
		return 0;
	}
	
	public String servicio() {
		return this.servicio;
	}
}