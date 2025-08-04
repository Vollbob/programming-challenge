package dataimport;

import java.util.Map;

import model.WeatherData;

public class WeatherDataParser implements DataParser<WeatherData> {

    public WeatherData parse(Map<String, String> map) {
        WeatherData weatherData = new WeatherData();

        weatherData.setDay(parseInt(map, "Day"));
        weatherData.setMxT(parseDouble(map, "MxT"));
        weatherData.setMnT(parseDouble(map, "MnT"));
        weatherData.setAvT(parseDouble(map, "AvT"));
        weatherData.setAvDP(parseDouble(map, "AvDP"));
        weatherData.setOneHrP_TPcpn(parseDouble(map, "1HrP TPcpn"));
        weatherData.setpDir(parseDouble(map, "PDir"));
        weatherData.setAvSp(parseDouble(map, "AvSp"));
        weatherData.setDir(parseDouble(map, "Dir"));
        weatherData.setMxS(parseDouble(map, "MxS"));
        weatherData.setSkyC(parseDouble(map, "SkyC"));
        weatherData.setMxR(parseDouble(map, "MxR"));
        weatherData.setMn(parseDouble(map, "Mn"));
        weatherData.setR_AvSLP(parseDouble(map, "R AvSLP"));

        return weatherData;
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

    //Throws Exception, if a value is not present or not parsable to double
    //TODO: Maybe refactor exception handling to accept Objects with some keys/values missing or handle special cases, according to what is needed
    private double parseDouble(Map<String, String> map, String key) {
        String value = map.get(key);
        if (value == null) {
            throw new IllegalArgumentException("Key '" + key + "' not found.");
        }
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Value for key '" + key + "' is no valid Double: " + value);
        }
    }
}

