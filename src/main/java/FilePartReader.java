import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;


    public FilePartReader(){
        this.filePath = "someInvalidPath";
        this.fromLine = -1;
        this.toLine = -1;
    }


    public void setup(String filePath, Integer fromLine, Integer toLine){
        if(toLine < fromLine || fromLine < 1){
            throw new IllegalArgumentException();
        }
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }


    public String read() throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }


    public String readLines() {
        String wholeString = null;
        try {
            wholeString = read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(new StringReader(wholeString));
        Stream<String> limited = bufferedReader.lines().skip(fromLine-1).limit(toLine-fromLine+1);
        return limited.collect(Collectors.joining("\n"));
    }

}
