package com.human.springboot.aiController;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.stereotype.Service;

@Service
public class OpenAIService {
	
	
	public String openAIGet() { 
		String result = "";
	 try {
         // Set your OpenAI API key
         String apiKey = "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";

         // Set the API endpoint URL
         String apiUrl = "https://api.openai.com/v1/your-endpoint";

         // Create URL object
         URL url = new URL(apiUrl);

         // Open a connection
         HttpURLConnection connection = (HttpURLConnection) url.openConnection();

         // Set the request method
         connection.setRequestMethod("GET");

         // Set the API key in the request header
         connection.setRequestProperty("Authorization", "Bearer " + apiKey);

         // Get the response code
         int responseCode = connection.getResponseCode();

         // Read the response
         BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
         String line;
         StringBuilder response = new StringBuilder();

         while ((line = reader.readLine()) != null) {
             response.append(line);
         }
         reader.close();

         // Handle the response as needed (parse JSON, etc.)
         System.out.println("Response Code: " + responseCode);
         System.out.println("Response Body: " + response.toString());
         result = response.toString();

     } catch (Exception e) {
         e.printStackTrace();
     }
	 	return result;
	}
}
