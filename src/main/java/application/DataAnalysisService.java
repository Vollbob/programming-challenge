package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dataimport.DataParser;
import dataimport.DataReader;

public class DataAnalysisService<T> {
 private final DataReader dataReader;
 private final DataParser<T> dataParser;
 private final DataAnalyzer<T> dataAnalyzer;
 
 public DataAnalysisService(DataReader reader, DataParser<T> parser, DataAnalyzer<T> analyzer) {
     this.dataReader = reader;
     this.dataParser = parser;
     this.dataAnalyzer = analyzer;
 }
 
 public double analyzeData(String dataSource) throws IOException{
     List<Map<String, String>> rawData = dataReader.readData(dataSource);
     
     
     List<T> parsedData = new ArrayList<>();
     for (Map<String, String> raw : rawData) {
         parsedData.add(dataParser.parse(raw));
     }
     
     return dataAnalyzer.findMinimumDifference(parsedData);
 }
}