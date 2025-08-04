package dataimport;

import java.util.Map;

import model.WeatherData;

public class WeatherDataParser implements DataParser<WeatherData> {

    public WeatherData parse(Map<String, String> map) {
        WeatherData weatherData = new WeatherData();

        weatherData.setDay(parseInt(map, "day"));
        weatherData.setMxT(parseDouble(map, "mxT"));
        weatherData.setMnT(parseDouble(map, "mnT"));
        weatherData.setAvT(parseDouble(map, "avT"));
        weatherData.setAvDP(parseDouble(map, "avDP"));
        weatherData.setOneHrP_TPcpn(parseDouble(map, "oneHrP_TPcpn"));
        weatherData.setpDir(parseDouble(map, "pDir"));
        weatherData.setAvSp(parseDouble(map, "avSp"));
        weatherData.setDir(parseDouble(map, "dir"));
        weatherData.setMxS(parseDouble(map, "mxS"));
        weatherData.setSkyC(parseDouble(map, "skyC"));
        weatherData.setMxR(parseDouble(map, "mxR"));
        weatherData.setMn(parseDouble(map, "mn"));
        weatherData.setR_AvSLP(parseDouble(map, "r_AvSLP"));

        return weatherData;
    }

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

