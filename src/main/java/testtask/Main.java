package testtask;

import java.util.ArrayList;
import java.util.List;
import testtask.fileprocessor.FilesReader;
import testtask.cliparser.Configuration;
public class Main {

    public static void main(String[] args) {
        List<String> files = new ArrayList<>();
        files.add("./1.txt");
        files.add("./2.txt");

        //FilesReader fr = new FilesReader(files);
        Configuration c = new Configuration(true, true, "./", "pref_", files);
        FilesReader fr = new FilesReader(c.getFiles());

        String str = fr.getNextString();
        while (str != null) {
            System.out.println(str);
            str = fr.getNextString();
        }
    }
}
