
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("/codecool/plik.txt", 1, 1);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        System.out.println(fileWordAnalyzer.getWordsOrderedAlphabetically());
        System.out.println(fileWordAnalyzer.getWordsContainingSubstrings("ggg"));
        System.out.println(fileWordAnalyzer.getStringsWhichPalindromes());
        System.out.println(filePartReader.readLines());

    }



    }



