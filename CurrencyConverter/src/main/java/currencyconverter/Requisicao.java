package currencyconverter;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class Requisicao {
	
    public void req(float valor, String m1, String m2) {
        String apiKey = "";
        
        Properties prop = new Properties();
        try (FileInputStream input = new FileInputStream("config.properties")) {
            prop.load(input);
            apiKey = prop.getProperty("API_KEY");
        } catch (IOException e) {
            e.getMessage();
        }
        
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + m1 + "/" + m2 + "/" + valor;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .GET()
                        .header("Accept", "application/json")
                        .build();

            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                        .thenApply(HttpResponse::body)
                        .thenApply(this::parseConversionResult)
                        .thenAccept(response -> {
                            String formattedResponse = String.format("\nValor de %.2f [%s] ==>> %.2f [%s]", valor, m1, response, m2);
                            System.out.println(formattedResponse);
                        })
                        .join();  // Aguarda a resposta
    }

    private float parseConversionResult(String responseBody) {
        // Parse do JSON usando Gson
        JsonObject jsonResponse = JsonParser.parseString(responseBody).getAsJsonObject();
        // Extrai o valor de conversion_result
        return jsonResponse.getAsJsonPrimitive("conversion_result").getAsFloat();
    }
}
