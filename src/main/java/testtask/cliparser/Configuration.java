package testtask.cliparser;
import java.util.ArrayList;
import java.util.List;

public class Configuration {
    private  boolean isFullStats;
    private  boolean isAppend;
    private  String outputPath;
    private  String outputFilenamesPrefix;
    private  List<String> files;

    public Configuration() {
        this.isFullStats = false;
        this.isAppend = false;
        this.outputPath = "./";
        this.outputFilenamesPrefix = "";
        this.files = new ArrayList<String>();
    }

    public Configuration(boolean isFullStats, boolean isAppend,
                         String outputPath, String outputFilenamesPrefix,
                         List<String> files) {
        this.isFullStats = isFullStats;
        this.isAppend = isAppend;
        this.outputPath = outputPath;
        this.outputFilenamesPrefix = outputFilenamesPrefix;
        this.files = files;
    }

    public boolean isFullStats() {
        return isFullStats;
    }

    public boolean isAppend() {
        return isAppend;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public String getOutputFilenamesPrefix() {
        return outputFilenamesPrefix;
    }

    public List<String> getFiles() {
        return files;
    }


    public void setFullStats(boolean isFullStats) {

        this.isFullStats = isFullStats;
    }

    public void setAppend(boolean isAppend) {
        this.isAppend = isAppend;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public void setOutputFilenamesPrefix(String outputFilenamesPrefix ) {
        this.outputFilenamesPrefix = outputFilenamesPrefix;
    }

    public void setFiles(ArrayList<String> files) {
        this.files = files;
    }
}