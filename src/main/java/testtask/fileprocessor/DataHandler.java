package testtask.fileprocessor;
import testtask.sorter.SortResult;
import testtask.cliparser.Configuration;

public class DataHandler {
    boolean isIntFirstOccurrence = true;
    boolean isFloatFirstOccurrence = true;
    boolean isStringFirstOccurrence = true;
    boolean isAppend = false;
    boolean isFullStats = false;
    private String outputPath;
    private String outputFilenamesPrefix;
    Configuration cfg;

    public DataHandler(Configuration cfg){
        this.cfg = cfg;
        this.isFullStats = cfg.isFullStats();
        this.isAppend = cfg.isAppend();
        this.outputPath = cfg.getOutputPath();
        this.outputFilenamesPrefix = cfg.getOutputFilenamesPrefix();

    }


    public void hanlde(SortResult pr){

    }
}
