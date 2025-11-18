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
    private FileWriter intsWriter;
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
        try {
            this.intsWriter = new FileWriter(intsOutputFileName,  isAppend){
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(SortResult value){
        try {
            intsWriter.write(Math.toIntExact(value.getLongValue().orElse(0L)));
        }
        catch (IOException ioe){
            System.out.println("Unable to write to "+ intsOutputFileName + " file");
        }

    }

}






