package src;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Api {
    private JsonObject conversionRatesUSD;
    private JsonObject conversionRatesCOP;
    private JsonObject conversionRatesMXN;
    public Api() {
        try {
            URL url = new URL("https://v6.exchangerate-api.com/v6/bafaec81ad825d50b4d98467/latest/USD");
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            JsonElement root = JsonParser.parseReader(
                    new InputStreamReader((InputStream) request.getContent())
            );
            JsonObject gsonObj = root.getAsJsonObject();

            conversionRatesUSD = gsonObj.getAsJsonObject("conversion_rates");

            url = new URL("https://v6.exchangerate-api.com/v6/bafaec81ad825d50b4d98467/latest/COP");
            request = (HttpURLConnection) url.openConnection();
            request.connect();

            root = JsonParser.parseReader(
                    new InputStreamReader((InputStream) request.getContent())
            );
            gsonObj = root.getAsJsonObject();

            conversionRatesCOP = gsonObj.getAsJsonObject("conversion_rates");

            url = new URL("https://v6.exchangerate-api.com/v6/bafaec81ad825d50b4d98467/latest/MXN");
            request = (HttpURLConnection) url.openConnection();
            request.connect();

            root = JsonParser.parseReader(
                    new InputStreamReader((InputStream) request.getContent())
            );
            gsonObj = root.getAsJsonObject();

            conversionRatesMXN = gsonObj.getAsJsonObject("conversion_rates");

            //System.out.println(currency + ": " + conversionRates.get(currency).getAsDouble());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public double convertir (String entrada, String salida, double cantidad) {
        double value = 0.0;
        switch (entrada) {
            case "USD":
                value = cantidad * conversionRatesUSD.get(salida).getAsDouble();
                break;
            case "COP":
                value = cantidad * conversionRatesCOP.get(salida).getAsDouble();
                break;
            case "MXN":
                value = cantidad * conversionRatesMXN.get(salida).getAsDouble();
                break;
        }
        return value;
    }
}
