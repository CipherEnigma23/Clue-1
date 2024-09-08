import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

class OpenAIExample {

    private static final String API_KEY = "<YOUR_API_KEY>";

    public static void main(String[] args) {
        try {
            // Create an HttpClient instance
            HttpClient client = HttpClient.newHttpClient();

            // Define the OpenAI API URL and endpoint
            String urlString = "https://api.openai.com/v1/chat/completions";

            // Create the JSON request body as a string
            String json = "{\n" +
                    "  \"model\": \"gpt-3.5-turbo\",\n" +
                    "  \"messages\": [\n" +
                    "    { \"role\": \"user\", \"content\": \"Hello! How are you\" }\n" +
                    "  ]\n" +
                    "}";

            // Create an HttpRequest object
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(urlString))
                    .header("Authorization", "Bearer " + API_KEY)
                    .header("Content-Type", "application/json")
                    .POST(BodyPublishers.ofString(json)) // Set the request body
                    .build();

            // Send the request and receive the response
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

            // Extract and print only the main answer from the response
            String responseBody = response.body();
            System.out.println(responseBody);

        } catch (Exception e) {
            // Handle any exceptions by printing the stack trace
            e.printStackTrace();
        }
    }
}
