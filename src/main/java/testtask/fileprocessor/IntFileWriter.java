package testtask.fileprocessor;
import java.io.FileWriter;
import java.io.IOException;

import testtask.cliparser.Configuration;
import testtask.sorter.SortResult;
// ToDo
// Обработка исключений

public class IntFileWriter implements FilesWriter{

    private String intOutputFileName;
    private  boolean isAppend;
    private  String outputPath;
    private  String outputFilenamesPrefix;
    private FileWriter intWriter;
    Configuration cfg;

    public IntFileWriter(Configuration cfg){
        this.cfg = cfg;
    }

    public IntFileWriter(String intOutputFileName, boolean isAppend,
                         String outputPath, String outputFilenamesPrefix){
        this.intOutputFileName = intOutputFileName;
        this.isAppend = isAppend;
        this.outputPath = outputPath;
        this.outputFilenamesPrefix = outputFilenamesPrefix;
        try {
            this.intWriter = new FileWriter(intOutputFileName, isAppend);
        } catch (IOException e) {
            System.err.println("Unable to write to "+ intOutputFileName + " file");
            e.printStackTrace();
        } 
        
    }

    public void writeToFile(SortResult value){
        try {
            intWriter.write(Math.toIntExact(value.getLongValue().orElse(0L)));
        }
        catch (IOException ioe){
            System.out.println("Unable to write to "+ intOutputFileName + " file");
        }
    }
}






