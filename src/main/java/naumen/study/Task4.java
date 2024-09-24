package naumen.study;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

public class Task4 {

    public void getIdHttp() {
        try {
            // Создаем URL объект
            URL url = new URL("https://httpbin.org/ip");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(response.toString());
                String ipAddress = jsonNode.get("origin").asText();

                System.out.println("Ваш IP адрес: " + ipAddress);
            } else {
                System.out.println("GET запрос не удался. Код ответа: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
