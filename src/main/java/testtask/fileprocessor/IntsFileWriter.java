package testtask.fileprocessor;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import testtask.cliparser.Configuration;
import testtask.sorter.SortResult;


public class IntsFileWriter implements FilesWriter{

    private String intsOutputFileName;
    private  boolean isAppend;
    private  String outputPath;
    private  String outputFilenamesPrefix;
    Configuration cfg;

    public IntsFileWriter(Configuration cfg){
        this.cfg = cfg;
    }

    public IntsFileWriter(String intsOutputFileName, boolean isAppend,
                            String outputPath, String outputFilenamesPrefix){
        this.intsOutputFileName = intsOutputFileName;
        this.isAppend = isAppend;
        this.outputPath = outputPath;
        this.outputFilenamesPrefix = outputFilenamesPrefix;
    }

    public void writeToFile(SortResult value){
        FileWriter intsWriter = new FileWriter(intsOutputFileName,  isAppend);

    }

}






