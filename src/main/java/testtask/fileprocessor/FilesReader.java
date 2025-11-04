package testtask.fileprocessor;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FilesReader {
    private int currentIndex = 0;
    private List<String> inputFiles;
    private List<BufferedReader> fileReaders = new ArrayList<>();

    public FilesReader(List<String> inputFiles) {
        this.inputFiles = inputFiles;
        this.openFiles(this.inputFiles);
    }

    public void openFiles(List<String> inputFiles) {
        if (inputFiles.isEmpty()) System.err.println("No filenames were provided");
        for (String fileName : inputFiles) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                fileReaders.add(br);
            } catch (FileNotFoundException fnfe) {
                System.err.println("Can't open file " + fileName);
            }
        }
    }

    public String getNextString(){

        while (!fileReaders.isEmpty()) {
            BufferedReader br = fileReaders.get(currentIndex);
            try {
                String line = br.readLine();
                if (line != null) {
                    currentIndex = (currentIndex + 1) % fileReaders.size();
                    return line;
                } else {
                    br.close();
                    fileReaders.remove(currentIndex);
                    if (fileReaders.isEmpty()) {
                        return null;
                    }
                    currentIndex = currentIndex % fileReaders.size();
                }
            } catch (IOException ioe) {
                System.err.println("Error reading from file: " + ioe.getMessage());
                try {
                    br.close();
                } catch (IOException ce) {
                    System.err.println("Error closing file: " + ce.getMessage());
                }
                fileReaders.remove(currentIndex);
                if (fileReaders.isEmpty()) {
                    return null;
                }
                currentIndex = currentIndex % fileReaders.size();
            }
        }
        return null;
    }
}