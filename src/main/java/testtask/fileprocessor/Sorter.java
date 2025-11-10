package testtask.fileprocessor;
import testtask.fileprocessor.FilesReader;
import testtask.fileprocessor.ParseResult;
import java.util.Optional;

public class Sorter {
    FilesReader fr;

    public Sorter(){
        this.fr = null;
    }

    public Sorter(FilesReader fr){
        this.fr = fr;
    }

    public ParseResult sort(){
        String currentString = fr.getNextString();
        try {
            Long i = Long.parseLong(currentString);
            return new ParseResult(i, null, null, ParseResult.ResultType.LONG);
        }
        catch (NumberFormatException e){
            try {
                Double d = Double.parseDouble(currentString);
                return new ParseResult(null, d , null, ParseResult.ResultType.DOUBLE);
            }
            catch (NumberFormatException e1){
                return new ParseResult(null, null , currentString, ParseResult.ResultType.STRING);
            }
        }
    }
}

