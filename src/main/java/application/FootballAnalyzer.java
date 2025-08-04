package application;

import java.util.List;

import model.FootballTeamData;

public class FootballAnalyzer implements DataAnalyzer<FootballTeamData>{

	@Override
	public String findMinimumDifference(List<FootballTeamData> footballData) {
		int minimumDifference;
    	String teamName = "";
    	
    	if (footballData.size() == 0) {
    		return teamName;
    	} else {
    		minimumDifference = Math.abs(footballData.get(0).getGoals() - footballData.get(0).getGoals_allowed());
    		teamName = footballData.get(0).getTeam();
    	}
    	
    	for (int i = 1; i < footballData.size(); i++) {
    		int actualDifference = Math.abs(footballData.get(i).getGoals() - footballData.get(i).getGoals_allowed());
    		if (actualDifference < minimumDifference) {
    			minimumDifference = actualDifference;
    			teamName = footballData.get(i).getTeam();
    		}
    	}
        return teamName;
	}

}
