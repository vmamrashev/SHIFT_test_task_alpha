package testtask.statscollector;
import testtask.sorter.SortResult;
import java.util.*;

public class StatsCollectorFactory {
    private Map<SortResult.ResultType, StatsCollector> collectors = new HashMap<>();

    public StatsCollector getCollector(SortResult.ResultType type) {

        if (!collectors.containsKey(type)) {
            collectors.put(type, createCollector(type));
        }

        return collectors.get(type);
    }

    private StatsCollector createCollector(SortResult.ResultType type) {
        if (type == SortResult.ResultType.LONG) {
            return new IntStatsCollector();
        } else if (type == SortResult.ResultType.DOUBLE) {
            return new DoubleStatsCollector();
        } else if (type == SortResult.ResultType.STRING) {
            return new StringStatsCollector();
        }
        throw new IllegalArgumentException("Unsupported data type: " + type);
    }

    public void printAllStatistics() {
        System.out.println("\n=== СТАТИСТИКА ===");
        for (Map.Entry<SortResult.ResultType, StatsCollector> entry : collectors.entrySet()) {
            System.out.println(entry.getValue().getStats());
        }
    }
}
