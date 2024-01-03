package com.weather.weaterApplication.TodoWeather;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;



@Controller
public class TodoController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	
private TodoService todoservice; 
	
	public TodoController(TodoService todoservice) {
		this.todoservice = todoservice;
	}

	
	
	@RequestMapping(value= "dataIn",method= RequestMethod.GET)
	public String getInputdata() {
		logger.debug("Inside method DataIn ");
		return "dataIn";
	}

	
	
	@RequestMapping(value= "dataIn" ,method = RequestMethod.POST)
	public String getWeatherforCity(@RequestParam String city, ModelMap model) throws JsonMappingException, JsonProcessingException, UnsupportedEncodingException {
		model.put("city", city);
	
		System.out.println("CITY:"+ city);
		 Todo todo = todoservice.generateWeatherData(city);
		 if(todo == null)
		 {
			 return "dataIn";
		 }
			model.addAttribute("todo", todo);
		return "weatherData";
	}
	
	
}
