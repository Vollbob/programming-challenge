package de.exxcellent.challenge;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import application.DataAnalysisService;
import dataimport.CsvReader;
import application.WeatherAnalyzer;
import application.FootballAnalyzer;
import dataimport.WeatherDataParser;
import dataimport.FootballTeamDataParser;
import model.FootballTeamData;
import model.WeatherData;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     * @throws IOException 
     * @throws URISyntaxException 
     */
    public static void main(String... args) throws IOException, URISyntaxException {
    	
    	DataAnalysisService<WeatherData> weatherDataAnalysisService = new DataAnalysisService<WeatherData>(new CsvReader(","), new WeatherDataParser(), new WeatherAnalyzer());
    	URL weatherResource = App.class.getClassLoader().getResource("de/exxcellent/challenge/weather.csv");
        File weatherFile = new File(weatherResource.toURI());
        
        String dayWithSmallestTempSpread = weatherDataAnalysisService.analyzeData(weatherFile.getAbsolutePath());
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        
        
        DataAnalysisService<FootballTeamData> footballDataAnalysisService = new DataAnalysisService<FootballTeamData>(new CsvReader(","), new FootballTeamDataParser(), new FootballAnalyzer());
    	URL footballResource = App.class.getClassLoader().getResource("de/exxcellent/challenge/football.csv");
        File footballFile = new File(footballResource.toURI());

        String teamWithSmallestGoalSpread = footballDataAnalysisService.analyzeData(footballFile.getAbsolutePath());
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
