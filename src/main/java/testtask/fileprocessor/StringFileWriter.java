// ToDo
// Переделать FileWriter на BufferedFileWriter
// Обработка исключений
package testtask.fileprocessor;
import java.io.FileWriter;
import java.io.IOException;
import testtask.cliparser.Configuration;
import testtask.sorter.SortResult;

public class StringFileWriter implements FilesWriter {
    private String StringOutputFileName;
    private boolean isAppend;
    private String outputPath;
    private String outputFilenamesPrefix;
    private FileWriter StringWriter;
    private Configuration cfg;

    public StringFileWriter(Configuration cfg){
        this.cfg = cfg;
    }

    public StringFileWriter(boolean isAppend, String outputPath,
                         String outputFilenamesPrefix){
        this.StringOutputFileName = outputPath + "//" + outputFilenamesPrefix + "strings.txt";
        this.isAppend = isAppend;
        this.outputPath = outputPath;
        this.outputFilenamesPrefix = outputFilenamesPrefix;
        try {
            this.StringWriter = new FileWriter(StringOutputFileName, isAppend);
        } catch (IOException e) {
            System.err.println("Unable to write to "+ StringOutputFileName + " file");
            e.printStackTrace();
        }

    }

    public void writeToFile(SortResult value){
        try {
            StringWriter.write(Math.toIntExact(value.getLongValue().orElse(0L)));
        }
        catch (IOException ioe){
            System.out.println("Unable to write to "+ StringOutputFileName + " file");
        }
    }

}
