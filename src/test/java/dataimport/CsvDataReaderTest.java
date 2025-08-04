package dataimport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Map;

/**
 * Test cases for the CsvDataReader.
 * @author Daniel Schäferling
 */
class CsvDataReaderTest {
	
	@Test
    void emptyCsv() {
    	CsvDataReader reader = new CsvDataReader(',');
    	List<Map<String, String>> weatherData = reader.readData("empty.csv");
    	assertEquals(0, weatherData.size(), "There should only be an empty List.csv");
    }
    
    @Test
    void singleLine() {
    	CsvDataReader reader = new CsvDataReader(',');
    	List<Map<String, String>> weatherData = reader.readData("singleLine.csv");
    	assertEquals(1, weatherData.size(), "There should be one column in singleLine.csv");
    }
    
    @Test
    void wrongDelimiter() {
    	CsvDataReader reader = new CsvDataReader(',');
    	assertThrows(IllegalArgumentException.class, () -> {
    		List<Map<String, String>> weatherData = reader.readData("weatherSemicolon.csv");
        });
    }

    @Test
    void shouldReadWeatherComma() {
    	CsvDataReader reader = new CsvDataReader(',');
    	List<Map<String, String>> weatherData = reader.readData("weatherComma.csv");
    	assertEquals(2, weatherData.size(), "There should be two columns in testweatherComma.csv");
        assertEquals("20", weatherData.get(0).get("Day"), "The first Day should be Day 20.");
        assertEquals("30", weatherData.get(1).get("Day"), "The second Day should be Day 30.");
        assertEquals("1032.5", weatherData.get(0).get("R AvSLP"), "The R AvSLP of Day 20 should be 1032.5.");
        assertEquals("1022.7", weatherData.get(1).get("R AvSLP"), "The R AvSLP of Day 30 should be 1022.7.");
    }
    
    @Test
    void shouldReadWeatherSemicolon() {
    	CsvDataReader reader = new CsvDataReader(';');
    	List<Map<String, String>> weatherData = reader.readData("testweatherSemicolon.csv");
    	assertEquals(2, weatherData.size(), "There should be two columns in testweatherComma.csv");
        assertEquals("20", weatherData.get(0).get("Day"), "The first Day should be Day 20.");
        assertEquals("30", weatherData.get(1).get("Day"), "The second Day should be Day 30.");
        assertEquals("1032.5", weatherData.get(0).get("R AvSLP"), "The R AvSLP of Day 20 should be 1032.5.");
        assertEquals("1022.7", weatherData.get(1).get("R AvSLP"), "The R AvSLP of Day 30 should be 1022.7.");
    }

}