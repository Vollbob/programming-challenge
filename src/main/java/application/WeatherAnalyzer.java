package application;

import java.util.List;

import model.WeatherData;

public class WeatherAnalyzer implements DataAnalyzer<WeatherData> {
	
    public Double findMinimumDifference(List<WeatherData> weatherData) {
    	Double minimumDifference;
    	
    	if (weatherData.size() == 0) {
    		return 0.0;
    	} else {
    		minimumDifference = weatherData.get(0).getMxT() - weatherData.get(0).getMnT();
    	}
    	
    	for (int i = 1; i < weatherData.size(); i++) {
    		Double actualDifference = weatherData.get(i).getMxT() - weatherData.get(i).getMnT();
    		if (actualDifference < minimumDifference) {
    			minimumDifference = actualDifference;
    		}
    	}
        return minimumDifference;
    }
}