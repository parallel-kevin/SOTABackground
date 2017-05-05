package server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.*;
import java.net.*;

@WebService
public class Weather {
    private final String baseURL = "http://restapi.amap.com/v3/weather/weatherInfo?";
    private final String key = "100d181a9ca13b8f4099d1916f25740e";

    @WebMethod
    public String getWeather(String city) throws Exception{
        String output = "";

        try {
            int adcode = City2Adcode.getAdcode(city);
            String targetURL = baseURL+"city="+adcode+"&key="+key;
            URL restServiceURL = new URL(targetURL);
            System.out.println(targetURL);

            HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
            httpConnection.setRequestMethod("GET");
            httpConnection.setRequestProperty("Accept", "application/json");

            if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : "
                        + httpConnection.getResponseCode());
            }

            BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
                    httpConnection.getInputStream(), "utf-8"));

            System.out.println("Output from Server:  \n");
            output = responseBuffer.readLine();
            System.out.println(output);

            httpConnection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output;
    }
}
