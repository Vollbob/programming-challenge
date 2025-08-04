package application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.FootballTeamData;

public class FootballAnalyzerTest {
	
	@Test
    void correctSmallestSpread() throws IOException, URISyntaxException{
		List<FootballTeamData> footballData = new ArrayList<FootballTeamData>();
		
		FootballTeamData footballData1 = new FootballTeamData();
		footballData1.setTeam("Arsenal");
		footballData1.setGoals(79);
		footballData1.setGoals_allowed(36);
		
		FootballTeamData footballData2 = new FootballTeamData();
		footballData2.setTeam("Liverpool");
		footballData2.setGoals(67);
		footballData2.setGoals_allowed(30);
		
		FootballTeamData footballData3 = new FootballTeamData();
		footballData3.setTeam("Manchester");
		footballData3.setGoals(87);
		footballData3.setGoals_allowed(45);
		
		footballData.add(footballData1);
		footballData.add(footballData2);
		footballData.add(footballData3);
		
		FootballAnalyzer analyzer = new FootballAnalyzer();
		
    	assertEquals("Liverpool", analyzer.findMinimumDifference(footballData), "The team with the smallest distance should be Liverpool.");
    }
	
	@Test
    void correctSmallestSpreadEqual() throws IOException, URISyntaxException{
		List<FootballTeamData> footballData = new ArrayList<FootballTeamData>();
		
		FootballTeamData footballData1 = new FootballTeamData();
		footballData1.setTeam("Manchester");
		footballData1.setGoals(79);
		footballData1.setGoals_allowed(36);
		
		FootballTeamData footballData2 = new FootballTeamData();
		footballData2.setTeam("Arsenal");
		footballData2.setGoals(79);
		footballData2.setGoals_allowed(36);
		
		FootballTeamData footballData3 = new FootballTeamData();
		footballData3.setTeam("Liverpool");
		footballData3.setGoals(79);
		footballData3.setGoals_allowed(36);
		
		footballData.add(footballData1);
		footballData.add(footballData2);
		footballData.add(footballData3);
		
		FootballAnalyzer analyzer = new FootballAnalyzer();
		
    	assertEquals("Manchester", analyzer.findMinimumDifference(footballData), "The team with the smallest distance should be Manchester.");
    }

}
