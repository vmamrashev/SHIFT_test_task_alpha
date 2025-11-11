package testtask.statscollector;
import testtask.sorter.SortResult;


public interface  StatsCollector {


    public void addValue(SortResult value);

    public String getStats();
}
