package testtask.statscollector;

import testtask.sorter.SortResult;

public class DoubleStatsCollector implements StatsCollector{
    private double max = Double.NEGATIVE_INFINITY;
    private double min = Double.POSITIVE_INFINITY;
    private double sum = 0;
    private static int count;
    private  boolean isFullStats;

    public void addValue(SortResult value){
        count++;
        if (isFullStats) {
            double currentDouble = value.getDoubleValue().orElse(0.0);
            sum = sum + currentDouble;
            if (currentDouble > max) max = currentDouble;
            if (currentDouble < min) min = currentDouble;
        }
    }

    public String getStats(){
        String stats = "";
        if (isFullStats) {
            stats = "Number of written doubles = " + count +
                    "\n min double value = " + min +
                    "\n max double value = " + max +
                    "\n sum of all doubles = " + sum +
                    "\n mean of written doubles = " +
                    (count != 0 ? (sum / count) : 0d) ;
        }
        else {
            stats = "Number of written doubles = " + count;
        }
        return stats;
    }
}