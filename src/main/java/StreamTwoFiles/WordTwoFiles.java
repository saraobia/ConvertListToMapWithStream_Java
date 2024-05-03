package StreamTwoFiles;

import java.io.IOException;

public interface WordTwoFiles {

    /* 1. Returns the counter of all words */
    long countWords() throws StreamTwoFilesError;
    /* 2. Returns all words sorted */
    String[] words() throws StreamTwoFilesError;
    /* 3. Returns all words with supplied delimiter */
    String wordsAsString(String delimiter) throws StreamTwoFilesError;
    /* 4. Returns all words sorted with no duplicates */
    String[] wordsNoDuplicates() throws StreamTwoFilesError;
    /* 5. Returns all words with supplied length */
    String[] wordsOfLength(int length) throws StreamTwoFilesError;
    /* 6. Add a words */
    void addWord(String word) throws StreamTwoFilesError;
    /* 7. delete a word */
    boolean deleteWord(String word) throws StreamTwoFilesError;
    /* 8. Return the first word (sorted) */
    String firstWord() throws StreamTwoFilesError;
    /* 9. Return the last word (sorted) */
    String lastWord() throws StreamTwoFilesError;
    /* 10. Return the occurrences of supplied word */
    int wordOccurrences(String word) throws StreamTwoFilesError;
    /* 11. Return true if the supplied word is present */
    boolean findWord(String word) throws StreamTwoFilesError;
}

