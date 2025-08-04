package dataimport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvReader implements DataReader {
	private final String delimiter;
	
	public CsvReader(String delimiter) {
		this.delimiter = delimiter;
	}
	
	public List<Map<String, String>> readData(String filename) throws IOException {
        List<Map<String, String>> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String headerLine = reader.readLine();
            if (headerLine == null) {
                return result;
            }

            String[] headers = splitLine(headerLine);
            
            if (!headerLine.contains(delimiter)) {
                throw new IOException("Delimiter '" + delimiter + "' was not found in header line.");
            }

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = splitLine(line);
                Map<String, String> row = new HashMap<>();

                for (int i = 0; i < headers.length; i++) {
                    String key = headers[i];
                    String value = "";
                    if (i < values.length) {
                    	value = values[i];
                    }
                    row.put(key, value);
                }

                result.add(row);
            }
        }

        return result;
    }
	
	private String[] splitLine(String line) {
        return line.split(delimiter);
    }

}
