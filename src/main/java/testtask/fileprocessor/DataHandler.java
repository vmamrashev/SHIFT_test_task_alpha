package testtask.fileprocessor;
import testtask.sorter.SortResult;
import testtask.cliparser.Configuration;
import testtask.statscollector.StatsCollectorFactory;

public class DataHandler {
    boolean isIntFirstOccurrence = true;
    boolean isFloatFirstOccurrence = true;
    boolean isStringFirstOccurrence = true;
    boolean isAppend = false;
    boolean isFullStats = false;
    private String outputPath;
    private String outputFilenamesPrefix;
    private StatsCollectorFactory scf;
    Configuration cfg;

    public DataHandler(Configuration cfg, StatsCollectorFactory scf){
        this.cfg = cfg;
        this.scf = scf;
        this.isFullStats = cfg.isFullStats();
        this.isAppend = cfg.isAppend();
        this.outputPath = cfg.getOutputPath();
        this.outputFilenamesPrefix = cfg.getOutputFilenamesPrefix();
    }

    public void handle(SortResult value){
        scf.getCollector(value.getType()).addValue(value);
    }
}
