package dataimport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Test cases for the CsvDataReader.
 * @author Daniel Schäferling
 */
class CsvDataReaderTest {
	
	@Test
    void emptyCsv() throws IOException, URISyntaxException{
		URL resource = getClass().getClassLoader().getResource("empty.csv");
	    File file = new File(resource.toURI());
        
    	CsvReader reader = new CsvReader(",");
    	List<Map<String, String>> weatherData = reader.readData(file.getAbsolutePath());
    	assertEquals(0, weatherData.size(), "There should only be an empty List.csv");
    }
    
    @Test
    void singleLine() throws IOException, URISyntaxException {
    	URL resource = getClass().getClassLoader().getResource("singleLine.csv");
	    File file = new File(resource.toURI());
	    
    	CsvReader reader = new CsvReader(",");
    	List<Map<String, String>> weatherData = reader.readData(file.getAbsolutePath());
    	assertEquals(1, weatherData.size(), "There should be one column in singleLine.csv");
    }
    
    @Test
    void wrongDelimiter() throws URISyntaxException{
    	URL resource = getClass().getClassLoader().getResource("weatherSemicolon.csv");
	    File file = new File(resource.toURI());
	    
    	CsvReader reader = new CsvReader(",");
    	assertThrows(IOException.class, () -> {
    		reader.readData(file.getAbsolutePath());
        });
    }

    @Test
    void shouldReadWeatherComma() throws IOException, URISyntaxException{
    	URL resource = getClass().getClassLoader().getResource("weatherComma.csv");
	    File file = new File(resource.toURI());
	    
    	CsvReader reader = new CsvReader(",");
    	List<Map<String, String>> weatherData = reader.readData(file.getAbsolutePath());
    	assertEquals(2, weatherData.size(), "There should be two columns in weatherComma.csv");
        assertEquals("20", weatherData.get(0).get("Day"), "The first Day should be Day 20.");
        assertEquals("30", weatherData.get(1).get("Day"), "The second Day should be Day 30.");
        assertEquals("1032.5", weatherData.get(0).get("R AvSLP"), "The R AvSLP of Day 20 should be 1032.5.");
        assertEquals("1022.7", weatherData.get(1).get("R AvSLP"), "The R AvSLP of Day 30 should be 1022.7.");
    }
    
    @Test
    void shouldReadWeatherSemicolon() throws IOException, URISyntaxException{
    	URL resource = getClass().getClassLoader().getResource("weatherSemicolon.csv");
	    File file = new File(resource.toURI());
	    
    	CsvReader reader = new CsvReader(";");
    	List<Map<String, String>> weatherData = reader.readData(file.getAbsolutePath());
    	assertEquals(2, weatherData.size(), "There should be two columns in weatherSemicolon.csv");
        assertEquals("20", weatherData.get(0).get("Day"), "The first Day should be Day 20.");
        assertEquals("30", weatherData.get(1).get("Day"), "The second Day should be Day 30.");
        assertEquals("1032.5", weatherData.get(0).get("R AvSLP"), "The R AvSLP of Day 20 should be 1032.5.");
        assertEquals("1022.7", weatherData.get(1).get("R AvSLP"), "The R AvSLP of Day 30 should be 1022.7.");
    }

}