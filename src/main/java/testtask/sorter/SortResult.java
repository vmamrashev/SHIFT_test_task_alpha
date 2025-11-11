package testtask.sorter;

import java.util.Optional;

public class SortResult {
    private final Long longValue;
    private final Double doubleValue;
    private final String stringValue;
    private final ResultType type;

    public enum ResultType { LONG, DOUBLE, STRING }

    SortResult(Long longValue, Double doubleValue, String stringValue, ResultType type) {
        this.longValue = longValue;
        this.doubleValue = doubleValue;
        this.stringValue = stringValue;
        this.type = type;
    }

    public static SortResult ofLong(long value) {
        return new SortResult(value, null, null, ResultType.LONG);
    }

    public static SortResult ofDouble(double value) {
        return new SortResult(null, value, null, ResultType.DOUBLE);
    }

    public static SortResult ofString(String value) {
        return new SortResult(null, null, value, ResultType.STRING);
    }

    public Optional<Long> getLongValue() {
        return Optional.ofNullable(longValue);
    }

    public Optional<Double> getDoubleValue() {
        return Optional.ofNullable(doubleValue);
    }

    public Optional<String> getStringValue() {
        return Optional.ofNullable(stringValue);
    }

    public ResultType getType() {
        return type;
    }
}