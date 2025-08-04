package dataimport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import model.WeatherData;

public class WeatherDataParserTest {
	
	@Test
    void emptyListThrows(){
		Map<String, String> data = new HashMap<>();
	    
    	WeatherDataParser parser = new WeatherDataParser();
    	assertThrows(IllegalArgumentException.class, () -> {
    		parser.parse(data);
        });
    }
	
	@Test
    void someKeyNotFoundThrows(){
		Map<String, String> data = new HashMap<>();
		data.put("day", "1");
	    
    	WeatherDataParser parser = new WeatherDataParser();
    	assertThrows(IllegalArgumentException.class, () -> {
    		parser.parse(data);
        });
    }
	
	@Test
    void wrongFormatFoundThrows(){
		Map<String, String> data = new HashMap<>();
		data.put("day", "1");
		data.put("mxT", "string");
		data.put("mnT", "59");
		data.put("avT", "74");
		data.put("avDP", "53.8");
		data.put("oneHrP_TPcpn", "0");
		data.put("pDir", "280");
		data.put("avSp", "9.6");
		data.put("dir", "270");
		data.put("mxS", "17");
		data.put("skyC", "1.6");
		data.put("mxR", "93");
		data.put("mn", "23");
		data.put("r_AvSLP", "1004.5");
	    
    	WeatherDataParser parser = new WeatherDataParser();
    	assertThrows(NumberFormatException.class, () -> {
    		parser.parse(data);
        });
    }
	
	@Test
    void shouldParseCorrectFormat(){
		Map<String, String> data = new HashMap<>();
		data.put("day", "1");
		data.put("mxT", "88");
		data.put("mnT", "59");
		data.put("avT", "74");
		data.put("avDP", "53.8");
		data.put("oneHrP_TPcpn", "0");
		data.put("pDir", "280");
		data.put("avSp", "9.6");
		data.put("dir", "270");
		data.put("mxS", "17");
		data.put("skyC", "1.6");
		data.put("mxR", "93");
		data.put("mn", "23");
		data.put("r_AvSLP", "1004.5");
	    
    	WeatherDataParser parser = new WeatherDataParser();
    	WeatherData weatherData = parser.parse(data);

    	assertEquals(1, weatherData.getDay(), "The first Day should be Day 1.");
        assertEquals(1004.5, weatherData.getR_AvSLP(), "The R AvSLP of Day 1 should be 1004.5.");
    }

}
