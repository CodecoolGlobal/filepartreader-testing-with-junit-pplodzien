import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {
    FilePartReader filePartReader;


    public FileWordAnalyzer(FilePartReader filePartReader){
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically(){
        String text = prepareStringForComparing();
        List<String> orderedWords = Arrays.asList(text.split("\\s+")).stream().sorted().collect(Collectors.toList());
        return orderedWords;
    }


    public List<String> getWordsContainingSubstrings(String subString){
        String text = prepareStringForComparing();
        List<String> words = Arrays.asList(text.split("\\s+")).stream().
                filter(element -> element.contains(subString.toLowerCase())).collect(Collectors.toList());
        return words;
    }


    public List<String> getStringsWhichPalindromes(){
        String text = prepareStringForComparing();
        List<String> words = Arrays.asList(text.split("\\s+")).
                stream().
                filter(element -> element.equals(new StringBuilder(element).reverse().toString())).
                collect(Collectors.toList());
        return words;
    }

    private String prepareStringForComparing(){
        return filePartReader.readLines().replaceAll("[^\\sa-zA-Z0-9]+", "").toLowerCase();
    }

}
