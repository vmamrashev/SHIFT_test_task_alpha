package testtask.statscollector;

import testtask.sorter.SortResult;

public class IntStatsCollector implements StatsCollector{
    private  Long max = Long.MIN_VALUE;;
    private  Long min = Long.MAX_VALUE;
    private  Long sum = 0L;
    private  int count = 0;
    private  boolean isFullStats;

    public void addValue(SortResult value){
        count++;
        if (isFullStats) {
            long currentLong = value.getLongValue().orElse(0L);
            sum = sum + currentLong;
            if (currentLong > max) max = currentLong;
            if (currentLong < min) min = currentLong;
        }
    }

    public String getStats(){
        String stats = "";
        if (isFullStats) {
            stats = "Number of written integers = " + count +
                    "\n min integer value = " + min +
                    "\n max integer value = " + max +
                    "\n sum of all integers = " + sum +
                    "\n mean of written integers = " +
                    (count != 0 ? (sum / count) : 0L) ;
        }
        else {
            stats = "Number of written integers = " + count;
        }
        return stats;
    }
}