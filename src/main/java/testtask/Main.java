package testtask;
import java.util.ArrayList;
import java.util.List;
import testtask.fileprocessor.FilesReader;
public class Main {

    public static void main(String[] args) {
        List<String> files = new ArrayList<>();
        files.add("./1.txt");
        files.add("./2.txt");
        FilesReader fr = new FilesReader(files);

        String str = fr.getNextString();
        while (str != null) {
            System.out.println(str);
            str = fr.getNextString();
        }
    }
}
