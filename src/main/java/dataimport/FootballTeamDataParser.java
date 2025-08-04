package dataimport;

import java.util.Map;

import model.FootballTeamData;

public class FootballTeamDataParser implements DataParser<FootballTeamData> {

	public FootballTeamData parse(Map<String, String> map) {
		FootballTeamData footballData = new FootballTeamData();
		
		footballData.setTeam(map.get("Team"));
		footballData.setGames(parseInt(map, "Games"));
		footballData.setWins(parseInt(map, "Wins"));
		footballData.setLosses(parseInt(map, "Losses"));
		footballData.setDraws(parseInt(map, "Draws"));
		footballData.setGoals(parseInt(map, "Goals"));
		footballData.setGoals_allowed(parseInt(map, "Goals Allowed"));
		footballData.setPoints(parseInt(map, "Points"));

        return footballData;
    }
	
	//Throws Exception, if a value is not present or not parsable to int
    //TODO: Maybe refactor exception handling to accept Objects with some keys/values missing or handle special cases, according to what is needed
    private int parseInt(Map<String, String> map, String key) {
        String value = map.get(key);
        
        if (value == null) {
            throw new IllegalArgumentException("Key '" + key + "' not found.");
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Value for key '" + key + "' is no valid Integer: " + value);
        }
    }
}
