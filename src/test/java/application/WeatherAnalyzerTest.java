package application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.WeatherData;

public class WeatherAnalyzerTest {
	
	@Test
    void correctSmallestSpread() throws IOException, URISyntaxException{
		List<WeatherData> weatherData = new ArrayList<WeatherData>();
		
		WeatherData weatherData1 = new WeatherData();
		weatherData1.setDay(1);
		weatherData1.setMxT(20);
		weatherData1.setMnT(0);
		
		WeatherData weatherData2 = new WeatherData();
		weatherData2.setDay(2);
		weatherData2.setMxT(10);
		weatherData2.setMnT(0);
		
		WeatherData weatherData3 = new WeatherData();
		weatherData3.setDay(3);
		weatherData3.setMxT(20);
		weatherData3.setMnT(15);
		
		weatherData.add(weatherData1);
		weatherData.add(weatherData2);
		weatherData.add(weatherData3);
		
		WeatherAnalyzer analyzer = new WeatherAnalyzer();
		
    	assertEquals("3", analyzer.findMinimumDifference(weatherData), "The day of the smallest spread should be Day 3.");
    }
	
	@Test
    void correctSmallestSpreadEqual() throws IOException, URISyntaxException{
		List<WeatherData> weatherData = new ArrayList<WeatherData>();
		
		WeatherData weatherData1 = new WeatherData();
		weatherData1.setDay(1);
		weatherData1.setMxT(20);
		weatherData1.setMnT(18);
		
		WeatherData weatherData2 = new WeatherData();
		weatherData2.setDay(2);
		weatherData2.setMxT(20);
		weatherData2.setMnT(18);
		
		WeatherData weatherData3 = new WeatherData();
		weatherData3.setDay(3);
		weatherData3.setMxT(20);
		weatherData3.setMnT(18);
		
		weatherData.add(weatherData1);
		weatherData.add(weatherData2);
		weatherData.add(weatherData3);
		
		WeatherAnalyzer analyzer = new WeatherAnalyzer();
		
    	assertEquals("1", analyzer.findMinimumDifference(weatherData), "The day of the smallest spread should be Day 1.");
    }
}
