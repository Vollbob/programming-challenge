package dataimport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import model.FootballTeamData;

public class FootballDataParserTest {
	
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
		data.put("Team", "Arsenal");
	    
    	WeatherDataParser parser = new WeatherDataParser();
    	assertThrows(IllegalArgumentException.class, () -> {
    		parser.parse(data);
        });
    }
	
	@Test
    void wrongFormatFoundThrows(){
		Map<String, String> data = new HashMap<>();
		data.put("Team","Arsenal");
		data.put("Games","38");
		data.put("Wins","26");
		data.put("Losses","test");
		data.put("Draws","3");
		data.put("Goals","79");
		data.put("Goals Allowed","36");
		data.put("Points","87");
	    
		FootballTeamDataParser parser = new FootballTeamDataParser();
    	assertThrows(NumberFormatException.class, () -> {
    		parser.parse(data);
        });
    }
	
	@Test
    void shouldParseCorrectFormat(){
		Map<String, String> data = new HashMap<>();
		data.put("Team","Arsenal");
		data.put("Games","38");
		data.put("Wins","26");
		data.put("Losses","9");
		data.put("Draws","3");
		data.put("Goals","79");
		data.put("Goals Allowed","36");
		data.put("Points","87");
	    
		FootballTeamDataParser parser = new FootballTeamDataParser();
		FootballTeamData footballTeamData = parser.parse(data);

    	assertEquals("Arsenal", footballTeamData.getTeam(), "The Team should be Arsenal.");
        assertEquals(36, footballTeamData.getGoals_allowed(), "Goals Allowed should be 36.");
    }

}
