package server;

import jdk.nashorn.internal.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import com.google.gson.*;

public class City2Adcode {
    private static final String baseURL = "http://restapi.amap.com/v3/config/district?";
    private static final String key = "100d181a9ca13b8f4099d1916f25740e";

    public static int getAdcode (String city) {
        String output;
        int result = -1;
        JsonParser parser = new JsonParser();

        try {
            String targetURL = baseURL+"keywords="+URLEncoder.encode(city,"utf-8")+"&key="+key;
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
            JsonObject json = (JsonObject)parser.parse(output);
            result = json.get("districts").getAsJsonArray().get(0).getAsJsonObject().get("adcode").getAsInt();

            httpConnection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }
}
