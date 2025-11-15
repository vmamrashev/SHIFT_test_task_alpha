package testtask.sorter;

import testtask.fileprocessor.FilesReader;
import testtask.fileprocessor.DataHandler;

public class Sorter {
    FilesReader fr;

    public Sorter(){
        this.fr = null;
    }

    public Sorter(FilesReader fr){
        this.fr = fr;
    }

    public void sortAndSendToDispatch(FilesReader fr, DataHandler dh){
        if (fr !=null && dh != null) {
            String currentString = fr.getNextString();
            while (currentString != null) {
                dh.handle(this.sort(currentString));
                currentString = fr.getNextString();
            }
        }
    }

    private SortResult sort(String string){
        try {
            Long i = Long.parseLong(string);
            return new SortResult(i, null, null, SortResult.ResultType.LONG);
        }
        catch (NumberFormatException e){
            try {
                Double d = Double.parseDouble(string);
                return new SortResult(null, d , null, SortResult.ResultType.DOUBLE);
            }
            catch (NumberFormatException e1){
                return new SortResult(null, null , string, SortResult.ResultType.STRING);
            }
        }
    }
}

