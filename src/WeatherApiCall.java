import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.TreeMap;
import com.google.gson.Gson;
import java.net.URI;

public class WeatherApiCall {

    public String getWeather(String city) {
        return this.callRemoteService(city, "weather");
    }

    public String getHumidity(String city) {
        return this.callRemoteService(city, "humidity");
    }

    public String getWind(String city) {
        return this.callRemoteService(city, "wind");
    }

    public String callRemoteService(String city, String dataType)
    {
        String urlString = "http://api.openweathermap.org/data/2.5/weather?appid=c15e2598880e57fad011a64061948fac&units=metric&q=" + city;

        try {
            URL url = new URL(urlString);
            URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
            url = uri.toURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                int errorCodeInt = conn.getResponseCode();
                throw new Exception();
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output = null;
            output = br.readLine();
            if (output != null) {
                WebServiceResponseJson resultClass = parseJsonObj(output);

                if(dataType.equals("weather")) {
                    return resultClass.main.temp.toString() + " °C";
                } else if(dataType.equals("humidity")) {
                    return resultClass.main.humidity.toString();
                } else if(dataType.equals("wind")) {
                    return resultClass.wind.speed.toString() + " KM";
                } else {
                    return "Data type not found";
                }
            } else {
                throw new Exception("Unable get result from web-service call!");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
            return "Error";
        }
    }
    private WebServiceResponseJson parseJsonObj(String jsonString) {
        WebServiceResponseJson result = null;
        try {
            Gson gson = new Gson();
            result = gson.fromJson(jsonString,WebServiceResponseJson.class);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
