package com.weather.weaterApplication.TodoWeather;

public class Todo {

	private String location;
	private double temperature;
	private double precipitation;
	public Todo(String location, double temperature, double precipitation) {
		super();
		this.location = location;
		this.temperature = temperature;
		this.precipitation = precipitation;
	}
	
	
	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public double getTemperature() {
		return temperature;
	}


	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}


	public double getPrecipitation() {
		return precipitation;
	}


	public void setPrecipitation(double precipitation) {
		this.precipitation = precipitation;
	}


	@Override
	public String toString() {
		return "Todo [location=" + location + ", temperature=" + temperature + ", precipitation=" + precipitation + "]";
	}
	
	
	
}
