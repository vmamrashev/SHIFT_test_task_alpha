package testtask.fileprocessor;

import testtask.cliparser.Configuration;
import testtask.fileprocessor.FilesWriter;
import testtask.sorter.SortResult;
import testtask.fileprocessor.IntFileWriter;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
// ToDo
// Определиться, надо ли столько полей

public class WriterFactory {
    private Map<SortResult.ResultType, FilesWriter> writers = new HashMap<>();
    private String intOutputFileName;
    private  boolean isAppend;
    private  String outputPath;
    private  String outputFilenamesPrefix;
    private FileWriter intWriter;
    Configuration cfg;

    public FilesWriter getWriter(SortResult.ResultType type) {

        if (!writers.containsKey(type)) {
            writers.put(type, createWriter(type));
        }

        return writers.get(type);
    }

    private FilesWriter createWriter(SortResult.ResultType type) {
        if (type == SortResult.ResultType.LONG) {
            return new IntFileWriter(isAppend, outputPath, outputFilenamesPrefix);
        } else if (type == SortResult.ResultType.DOUBLE) {
            return new DoubleFileWriter(isAppend, outputPath, outputFilenamesPrefix);
        } else if (type == SortResult.ResultType.STRING) {
            return new StringFileWriter(isAppend, outputPath, outputFilenamesPrefix);
        }
        throw new IllegalArgumentException("Unsupported data type: " + type);
    }

}
