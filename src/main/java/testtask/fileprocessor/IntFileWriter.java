// ToDo
// Переделать FileWriter на BufferedFileWriter
// Обработка исключений
package testtask.fileprocessor;
import java.io.FileWriter;
import java.io.IOException;

import testtask.cliparser.Configuration;
import testtask.sorter.SortResult;


public class IntFileWriter implements FilesWriter{

    private String intOutputFileName;
    private boolean isAppend;
    private String outputPath;
    private String outputFilenamesPrefix;
    private FileWriter intWriter;
    private Configuration cfg;

    public IntFileWriter(Configuration cfg){
        this.cfg = cfg;
    }

    public IntFileWriter(boolean isAppend, String outputPath,
                          String outputFilenamesPrefix){
        this.intOutputFileName = outputPath + "//" + outputFilenamesPrefix + "integers.txt";
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






