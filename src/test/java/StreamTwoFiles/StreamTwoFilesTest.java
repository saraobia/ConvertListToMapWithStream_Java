package StreamTwoFiles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class StreamTwoFilesTest {

    static StreamTwoFiles stf;

    @BeforeEach
    void setUp() {
        stf = new StreamTwoFiles("data.txt", "data2.txt");
    }

    @Test
    public void testCountWordsWithMissingFile() {
        StreamTwoFiles streamTwoFiles = new StreamTwoFiles("missing_file1.txt", "missing_file2.txt");
        assertThrows(StreamTwoFilesError.class, () -> {
            streamTwoFiles.countWords();
        });
    }

    @Test
    void countWords() throws StreamTwoFilesError {
        long numExpected = 32l;
        long numActual = stf.countWords();
        assertEquals(numExpected, numActual);
    }

    @Test
    void words() throws StreamTwoFilesError {
        String[] arWordsSortedExpected = {"Adventure",
                                        "Butterfly",
                                        "Chocolate",
                                        "Elephant",
                                        "Happiness",
                                        "Laughter",
                                        "Mountain",
                                        "Mountain",
                                        "Ocean",
                                        "Serenity",
                                        "Sunshine",
                                        "bicycle",
                                        "book",
                                        "candy",
                                        "cat",
                                        "cat",
                                        "cloud",
                                        "elephant",
                                        "giraffe",
                                        "key",
                                        "lamp",
                                        "moon",
                                        "ocean",
                                        "piano",
                                        "star",
                                        "strawberry",
                                        "sun",
                                        "telephone",
                                        "tiger",
                                        "tree",
                                        "wind",
                                        "zoo"};



        String[] arWordsSortedActual = stf.words();
        assertArrayEquals(arWordsSortedExpected, arWordsSortedActual);

    }
    @Test
    void wordsAsString() throws StreamTwoFilesError {
        String wordsExpected = "lamp, elephant, strawberry, wind, book, piano, cat, star, zoo, cat, bicycle, cloud, Mountain, candy, ocean, telephone, giraffe, moon, key, sun, tiger, tree, Elephant, Sunshine, Mountain, Happiness, Butterfly, Chocolate, Adventure, Ocean, Serenity, Laughter";
        String wordsActual = stf.wordsAsString(", ");

        assertEquals(wordsExpected, wordsActual);
    }

    @Test
    void wordsNoDuplicates() throws StreamTwoFilesError {
        String[] arWordsNoDuplicateExpected = {"Adventure",
                                                "Butterfly",
                                                "Chocolate",
                                                "Elephant",
                                                "Happiness",
                                                "Laughter",
                                                "Mountain",
                                                "Ocean",
                                                "Serenity",
                                                "Sunshine",
                                                "bicycle",
                                                "book",
                                                "candy",
                                                "cat",
                                                "cloud",
                                                "elephant",
                                                "giraffe",
                                                "key",
                                                "lamp",
                                                "moon",
                                                "ocean",
                                                "piano",
                                                "star",
                                                "strawberry",
                                                "sun",
                                                "telephone",
                                                "tiger",
                                                "tree",
                                                "wind",
                                                "zoo"};
        String[] arWordsNoDuplicatesActual = stf.wordsNoDuplicates();
        assertArrayEquals(arWordsNoDuplicateExpected, arWordsNoDuplicatesActual);

    }

    @Test
    void wordsOfLength() throws StreamTwoFilesError {
        String[] arWordsWithLengthExpected = {"cat",
                                              "cat",
                                              "sun",
                                              "zoo"};
        String[] arWordsWithLengthActual = stf.wordsOfLength(3);

        assertArrayEquals(arWordsWithLengthExpected, arWordsWithLengthExpected);
    }

    @Test
    void addWord() throws StreamTwoFilesError {
        stf.addWord("dog");
        stf.addWord("new");
    }

    @Test
    void deleteWord() throws StreamTwoFilesError {
        assertTrue(stf.deleteWord("cat"));
        assertFalse(stf.deleteWord("newWordNoAdded"));
    }

    @Test
    void firstWord() throws StreamTwoFilesError {
        String firstWordExpected = "Adventure";
        String firstWordACtual = stf.firstWord();

        assertEquals(firstWordExpected, firstWordACtual);
    }

    @Test
    void lastWord() throws StreamTwoFilesError {
        String lastWordExpected = "zoo";
        String lastWordActual = stf.lastWord();

        assertEquals(lastWordExpected, lastWordActual);
    }

    @Test
    void wordOccurrences() throws StreamTwoFilesError {
        int numOccExpected = 2;
        int numOccActual = stf.wordOccurrences("cat");
        assertEquals(numOccExpected, numOccActual);
    }

    @Test
    void findWord() throws StreamTwoFilesError {
        assertTrue(stf.findWord("cat"));
        assertFalse(stf.findWord("NewWord"));
    }
}