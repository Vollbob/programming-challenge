package application;

import java.util.List;

public interface DataAnalyzer<T> {
    String findMinimumDifference(List<T> data);
}
