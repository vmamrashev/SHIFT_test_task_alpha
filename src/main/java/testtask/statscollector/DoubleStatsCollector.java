package testtask.statscollector;

import testtask.sorter.SortResult;

public class DoubleStatsCollector implements StatsCollector{
    private  int maxLength = 0;
    private  int minLength = Integer.MAX_VALUE;
    private  int count;
    private  boolean needFullStats;
    private int currentStringLength;

    public void addValue(SortResult value){
        count++;
        if (needFullStats) {
            currentStringLength = String.valueOf(value.getStringValue()).length();
            if (currentStringLength > maxLength) maxLength = currentStringLength;
            if (currentStringLength < minLength) minLength = currentStringLength;
        }
    }

    public String getStats(){
        return "String stats";
    }
}
