package application;

import java.util.List;

import model.WeatherData;

public class WeatherAnalyzer implements DataAnalyzer<WeatherData> {
	
    public String findMinimumDifference(List<WeatherData> weatherData) {
    	Double minimumDifference;
    	String dayOfMinimumDifference = "";
    	
    	if (weatherData.size() == 0) {
    		return dayOfMinimumDifference;
    	} else {
    		minimumDifference = weatherData.get(0).getMxT() - weatherData.get(0).getMnT();
    		dayOfMinimumDifference = String.valueOf(weatherData.get(0).getDay());
    	}
    	
    	for (int i = 1; i < weatherData.size(); i++) {
    		Double actualDifference = weatherData.get(i).getMxT() - weatherData.get(i).getMnT();
    		if (actualDifference < minimumDifference) {
    			minimumDifference = actualDifference;
    			dayOfMinimumDifference = String.valueOf(weatherData.get(i).getDay());
    		}
    	}
        return dayOfMinimumDifference;
    }
}