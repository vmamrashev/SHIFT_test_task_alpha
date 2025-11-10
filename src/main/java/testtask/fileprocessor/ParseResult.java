package testtask.fileprocessor;

import java.util.Optional;

public class ParseResult {
    private final Long longValue;
    private final Double doubleValue;
    private final String stringValue;
    private final ResultType type;

    public enum ResultType { LONG, DOUBLE, STRING }

    ParseResult(Long longValue, Double doubleValue, String stringValue, ResultType type) {
        this.longValue = longValue;
        this.doubleValue = doubleValue;
        this.stringValue = stringValue;
        this.type = type;
    }

    public static ParseResult ofLong(long value) {
        return new ParseResult(value, null, null, ResultType.LONG);
    }

    public static ParseResult ofDouble(double value) {
        return new ParseResult(null, value, null, ResultType.DOUBLE);
    }

    public static ParseResult ofString(String value) {
        return new ParseResult(null, null, value, ResultType.STRING);
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