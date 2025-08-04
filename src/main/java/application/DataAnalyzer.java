package application;

import java.util.List;

public interface DataAnalyzer<T> {
    Double findMinimumDifference(List<T> data);
}
