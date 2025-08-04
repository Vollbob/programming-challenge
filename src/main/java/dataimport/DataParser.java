package dataimport;

import java.util.Map;

public interface DataParser<T> {
    T parse(Map<String, String> rawData);
}
