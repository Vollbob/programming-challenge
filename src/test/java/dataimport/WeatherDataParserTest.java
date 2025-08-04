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
		data.put("Day", "1");
		data.put("MxT", "string");
		data.put("MnT", "59");
		data.put("AvT", "74");
		data.put("AvDP", "53.8");
		data.put("1HrP TPcpn", "0");
		data.put("PDir", "280");
		data.put("AvSp", "9.6");
		data.put("Dir", "270");
		data.put("MxS", "17");
		data.put("SkyC", "1.6");
		data.put("MxR", "93");
		data.put("Mn", "23");
		data.put("R AvSLP", "1004.5");
	    
    	WeatherDataParser parser = new WeatherDataParser();
    	assertThrows(NumberFormatException.class, () -> {
    		parser.parse(data);
        });
    }
	
	@Test
    void shouldParseCorrectFormat(){
		Map<String, String> data = new HashMap<>();
		data.put("Day", "1");
		data.put("MxT", "88");
		data.put("MnT", "59");
		data.put("AvT", "74");
		data.put("AvDP", "53.8");
		data.put("1HrP TPcpn", "0");
		data.put("PDir", "280");
		data.put("AvSp", "9.6");
		data.put("Dir", "270");
		data.put("MxS", "17");
		data.put("SkyC", "1.6");
		data.put("MxR", "93");
		data.put("Mn", "23");
		data.put("R AvSLP", "1004.5");
	    
    	WeatherDataParser parser = new WeatherDataParser();
    	WeatherData weatherData = parser.parse(data);

    	assertEquals(1, weatherData.getDay(), "The first Day should be Day 1.");
        assertEquals(1004.5, weatherData.getR_AvSLP(), "The R AvSLP of Day 1 should be 1004.5.");
    }

}
