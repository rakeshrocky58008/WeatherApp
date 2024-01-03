package com.weather.weaterApplication.TodoWeather;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class TodoService {

	List<String> list = new ArrayList<String>();
	
	public static final String req = "api.weatherapi.com/v1/current.json?key=393159c2b27f4cd598a33408233112";
	
	public Todo generateWeatherData(String city) throws JsonMappingException, JsonProcessingException, UnsupportedEncodingException {
		
		String city1 = URLEncoder.encode(city, "UTF-8");
	//	logger.debug("Inside method getWeatherforCity"+ city);
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("http://"+ req + "&q="+ city1))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = null;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(response.body());
		   System.out.println("Status Code: " + response.statusCode());
		   
		   if ( response.statusCode() != 200)
		   {
			   return null;
		   }
		    // Parse JSON response
		    ObjectMapper objectMapper = new ObjectMapper();
		    JsonNode jsonNode = objectMapper.readTree(response.body());

		    // Access specific data
		    String locationName = jsonNode.path("location").path("name").asText();
		    double temperatureC = jsonNode.path("current").path("temp_c").asDouble();
		    double precipitationMM = jsonNode.path("current").path("precip_mm").asDouble();
			
		    
		 if ( ! city.toLowerCase().equals(locationName.toLowerCase()))
		 {	 
			 return null;
		 }
		    Todo todo = new Todo(locationName,temperatureC,precipitationMM);
		    return todo;	
		
	}
	
}
