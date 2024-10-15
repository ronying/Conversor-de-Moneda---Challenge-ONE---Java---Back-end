package com.conversor.servicio;

import com.conversor.modelo.Conversion;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConversorServicio {
    private static final String API_KEY = "4fcee3fe718f1ea72419ff8d";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

    public Conversion convertirMoneda(String monedaOrigen, String monedaDestino, double cantidad) throws Exception {
        String urlString = API_URL + monedaOrigen + "/" + monedaDestino;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("HTTP error code : " + responseCode);
        }

        Scanner sc = new Scanner(url.openStream());
        String inline = "";
        while (sc.hasNext()) {
            inline += sc.nextLine();
        }
        sc.close();

        JSONObject jsonResponse = new JSONObject(inline);
        double tasaCambio = jsonResponse.getDouble("conversion_rate");
        double totalConvertido = cantidad * tasaCambio;

        return new Conversion(monedaOrigen, monedaDestino, cantidad, totalConvertido, tasaCambio);
    }
}
