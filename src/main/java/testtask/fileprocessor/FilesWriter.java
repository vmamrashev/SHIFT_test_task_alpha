package testtask.fileprocessor;
import testtask.cliparser.Configuration;
import testtask.sorter.SortResult;

public interface FilesWriter {

    public void writeToFile(SortResult value);
}
