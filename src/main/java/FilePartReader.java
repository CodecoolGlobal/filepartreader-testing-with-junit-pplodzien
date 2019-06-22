import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;


    public FilePartReader(){
    }


    public void setup(String filePath, Integer fromLine, Integer toLine){
        this.filePath = filePath;
        if(toLine < fromLine || fromLine < 1){
            throw new IllegalArgumentException();
        }
        else {
            this.fromLine = fromLine;
            this.toLine = toLine;
        }
    }


    public String read() throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }


    public String readLines() throws IOException{
        String wholeString = read();
        BufferedReader bufferedReader = new BufferedReader(new StringReader(wholeString));
        Stream<String> limited = bufferedReader.lines().skip(fromLine-1).limit(toLine);
        return limited.collect(Collectors.joining("\n"));
    }
















}
