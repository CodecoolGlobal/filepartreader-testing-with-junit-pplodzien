import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.io.IOException;


class FilePartReaderTest {
    FilePartReader filePartReader;


    @BeforeEach
    public void setup(){
        filePartReader = new FilePartReader();
    }


    @DisplayName("Should throw IllegalArgumentException when parameters are wrong")
    @ParameterizedTest(name = "File with starting line = {1} and ending line = {2} throws Exception")
    @CsvSource({
            "someFilePath, -1, 2",
            "someFilePath, 5, -5",
            "someFilePath, 0, 0",
            "someFilePath, 0, 1",
            "someFilePath, 1, 0"
    })
    void setupWithWrongInputsThrowIllegalArgumentException(String filePath, Integer fromLine, Integer toLine) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> filePartReader.setup(filePath, fromLine, toLine));
    }

    @DisplayName("Should throw IOException when file path is wrong")
    @Test
    void fileWithWrongPathThrowsIOException() {
        filePartReader.setup("someWrongPath", 1, 5);
        Assertions.assertThrows(IOException.class, () -> filePartReader.read());
    }


//    private int get
//
//    @Test
//    void readLines() {
//
//    }
}