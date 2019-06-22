import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {
    FilePartReader filePartReader;


    public FileWordAnalyzer(FilePartReader filePartReader){
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        String text = filePartReader.readLines();
        List<String> orderedWords = Arrays.asList(text.split("\\s+")).stream().sorted().collect(Collectors.toList());
        return orderedWords;
    }


    public List<String> getWordsContainingSubstrings(String subString) throws IOException{
        String text = filePartReader.readLines();
        List<String> words = Arrays.asList(text.split("\\s+")).stream().
                filter(element -> element.contains(subString)).collect(Collectors.toList());
        return words;
    }


    public List<String> getStringsWhichPalindromes() throws IOException{
        String text = filePartReader.readLines();
        List<String> words = Arrays.asList(text.split("\\s+")).
                stream().
                filter(element -> element.equals(new StringBuilder(element).reverse().toString())).
                collect(Collectors.toList());
        return words;
    }









}
