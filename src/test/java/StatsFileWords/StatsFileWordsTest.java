package StatsFileWords;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class StatsFileWordsTest {
    static StatsFileWords sfw;
    @BeforeEach
    void setUp() throws IOException {
        sfw = new StatsFileWords("data.txt");
        System.out.println(sfw);
    }

    @Test
    void countAll() throws IOException {
        long expectedCounter = 22l;
        long actualCounter = sfw.countAll();
        assertEquals(expectedCounter, actualCounter);
    }

    @Test
    void words() throws IOException {
        String[] arActualWords = sfw.words();
        String[] arExpectedWords = {"lamp",
                                    "elephant",
                                    "strawberry",
                                    "wind",
                                    "book",
                                    "piano",
                                    "cat",
                                    "star",
                                    "zoo",
                                    "cat",
                                    "bicycle",
                                    "cloud",
                                    "mountain",
                                    "candy",
                                    "ocean",
                                    "telephone",
                                    "giraffe",
                                    "moon",
                                    "key",
                                    "sun",
                                    "tiger",
                                    "tree"};

    assertArrayEquals(arExpectedWords, arActualWords);
    }

    @Test
    void count() throws IOException {
        long expectedCounterWord = 2l;
        long actualCounterWord = sfw.count("cat");
        assertEquals(expectedCounterWord, actualCounterWord);
    }

    @Test
    void wordGreater() throws IOException {
        String wordExpected = "zoo";
        String wordActual = sfw.wordGreater();
        assertEquals(wordExpected, wordActual);
    }

    @Test
    void wordsWithLenghtLessThen() throws IOException {
        String [] arLessThenFourExpected = {"cat",
                                            "zoo",
                                            "cat",
                                            "key",
                                            "sun"
        };

        String [] arLessThenFourActual = sfw.wordsWithLenghtLessThen(4);
        assertArrayEquals(arLessThenFourExpected, arLessThenFourActual);
    }

    @Test
    void wordsJoined() throws IOException {
        String allWordsExpected = "lamp, elephant, strawberry, wind, book, piano, cat, star, zoo, cat, bicycle, cloud, mountain, candy, ocean, telephone, giraffe, moon, key, sun, tiger, tree";
        String allWordsActual = sfw.wordsJoined();

        assertEquals(allWordsExpected, allWordsActual);
    }
}