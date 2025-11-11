package testtask.statscollector;

import testtask.sorter.SortResult;

public class StringStatsCollector implements StatsCollector{
    private  int maxLength = 0;
    private  int minLength = Integer.MAX_VALUE;
    private  int count = 0;
    private  boolean isFullStats;

    public void addValue(SortResult value){
        count++;
        if (isFullStats) {
            int currentStringLength = String.valueOf(value.getStringValue()).length();
            if (currentStringLength > maxLength) maxLength = currentStringLength;
            if (currentStringLength < minLength) minLength = currentStringLength;
        }
    }

    public String getStats(){
        String stats = "";
        if (isFullStats) {
            stats = "Number of written Strings = " + count +
                    "\n min String length = " + minLength +
                    "\n max String length = " + maxLength ;
        }
        else {
            stats = "Number of written Strings = " + count;
        }
        return stats;
    }
}