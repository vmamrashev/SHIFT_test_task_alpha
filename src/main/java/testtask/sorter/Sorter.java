package testtask.fileprocessor;

import testtask.fileprocessor.FilesReader;
import testtask.fileprocessor.FilesReader;
import testtask.fileprocessor.ParseResult;
import testtask.fileprocessor.DataHandler;
import java.util.Optional;

public class Sorter {
    FilesReader fr;

    public Sorter(){
        this.fr = null;
    }

    public Sorter(FilesReader fr){
        this.fr = fr;
    }



    public ParseResult sort(String string){
        try {
            Long i = Long.parseLong(string);
            return new ParseResult(i, null, null, ParseResult.ResultType.LONG);
        }
        catch (NumberFormatException e){
            try {
                Double d = Double.parseDouble(string);
                return new ParseResult(null, d , null, ParseResult.ResultType.DOUBLE);
            }
            catch (NumberFormatException e1){
                return new ParseResult(null, null , string, ParseResult.ResultType.STRING);
            }
        }

    }

    public void sortNDispatchAll(FilesReader fr, DataHandler dh){
        if (fr !=null && dh != null) {
            String currentString = fr.getNextString();
            while (currentString != null) {
                dh.hanlde(this.sort(currentString));
                currentString = fr.getNextString();
            }
        }
    }






}

