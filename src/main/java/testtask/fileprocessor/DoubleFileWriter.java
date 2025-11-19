// ToDo
// Обработка исключений
package testtask.fileprocessor;
import java.io.FileWriter;
import java.io.IOException;

import testtask.cliparser.Configuration;
import testtask.sorter.SortResult;


public class DoubleFileWriter implements FilesWriter{

    private String doubleOutputFileName;
    private boolean isAppend;
    private String outputPath;
    private String outputFilenamesPrefix;
    private FileWriter doubleWriter;
    private Configuration cfg;

    public DoubleFileWriter(boolean isAppend, String outputPath,
                         String outputFilenamesPrefix){
        this.doubleOutputFileName = outputPath + "//" + outputFilenamesPrefix + "floats.txt";
        this.isAppend = isAppend;
        this.outputPath = outputPath;
        this.outputFilenamesPrefix = outputFilenamesPrefix;
        try {
            this.doubleWriter = new FileWriter(doubleOutputFileName, isAppend);
        } catch (IOException e) {
            System.err.println("Unable to write to "+ doubleOutputFileName + " file");
            e.printStackTrace();
        }

    }

    public void writeToFile(SortResult value){
        try {
            doubleWriter.write(Math.toIntExact(value.getLongValue().orElse(0L)));
        }
        catch (IOException ioe){
            System.out.println("Unable to write to "+ doubleOutputFileName + " file");
        }
    }
    
}
