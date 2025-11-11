package testtask.fileprocessor;
import testtask.cliparser.Configuration;

public class FilesWriter {
    private String intsOutputFileName;
    private String floatsOutputFileName;
    private String stringsOutputFileName;
    Configuration cfg;

    public FilesWriter(Configuration cfg){
        this.cfg = cfg;
    }


}
