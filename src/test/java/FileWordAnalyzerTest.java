import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class FileWordAnalyzerTest {
    FilePartReader filePartReader;
    FileWordAnalyzer fileWordAnalyzer;


    @BeforeEach
    public void setup(){
        filePartReader = mock(FilePartReader.class);
        fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

    }

    @DisplayName("Should return ordered list of strings")
    @Test
    void shouldReturnOrderedListOfWords() {
        when(filePartReader.readLines()).thenReturn("1 This is example, using Diffrent diffrent @signs. 20");
        List<String> expected = Arrays.asList(new String[]{"1", "20", "diffrent", "diffrent", "example", "is", "signs", "this", "using"});
        List<String> actual = fileWordAnalyzer.getWordsOrderedAlphabetically();
        Assertions.assertEquals(expected, actual);
    }


    @DisplayName("Should return list containing substring")
    @Test
    void shouldReturnListContainingSubstring() {
        when(filePartReader.readLines()).thenReturn("Example string of words: apple, carrot, maple, talk, rotten, tomato, rolls, tron, marot");
        List<String> expected = Arrays.asList(new String[]{"carrot", "rotten", "marot"});
        List<String> actual = fileWordAnalyzer.getWordsContainingSubstrings("rot");
        Assertions.assertEquals(expected, actual);
    }


    @DisplayName("Should return list of words which are palindromes")
    @Test
    void shouldReturnListOfPalindromes() {
        when(filePartReader.readLines()).thenReturn("Example string of words: zakaz, Kajak, agga, grot, małpa, alppla, jaj, tron, marot");
        List<String> expected = Arrays.asList(new String[]{"zakaz", "kajak", "agga", "alppla", "jaj"});
        List<String> actual = fileWordAnalyzer.getStringsWhichPalindromes();
        Assertions.assertEquals(expected, actual);
    }


}
