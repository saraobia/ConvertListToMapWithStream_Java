package StreamTwoFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTwoFiles implements WordTwoFiles {
    private final String fileName1;
    private final String fileName2;



    public StreamTwoFiles(String fileName1, String fileName2) {
        this.fileName1 = fileName1;
        this.fileName2 = fileName2;
    }

    @Override
    public long countWords() throws StreamTwoFilesError {
        return streamSplitInWord()
               .count();
    }

    @Override
    public String[] words() throws StreamTwoFilesError {
        return streamSplitInWord()
               .sorted()
               .toArray(String[]::new);
    }

    @Override
    public String wordsAsString(String delimiter) throws StreamTwoFilesError {
        return streamSplitInWord()
               .collect(Collectors.joining(", "));
    }

    @Override
    public String[] wordsNoDuplicates() throws StreamTwoFilesError {
        return streamSplitInWord()
               .distinct()
               .sorted()
               .toArray(String[]::new);
    }

    @Override
    public String[] wordsOfLength(int length) throws StreamTwoFilesError {
        return streamSplitInWord()
               .filter(s -> s.length() == length)
               .toArray(String[]::new);
    }

    @Override
    public void addWord(String word) throws StreamTwoFilesError {
        List<String> wordsList = streamSplitInWord().collect(Collectors.toList());
        wordsList.add(word);
    }

    @Override
    public boolean deleteWord(String word) throws StreamTwoFilesError {
        List<String> wordsList = streamSplitInWord().collect(Collectors.toList());
        return wordsList.remove(word);
    }

    @Override
    public String firstWord() throws StreamTwoFilesError {
        return streamSplitInWord()
               .sorted()
               .findFirst()
               .orElse("");
    }

    @Override
    public String lastWord() throws StreamTwoFilesError {
        return streamSplitInWord()
               .sorted(Comparator.reverseOrder())
               .findFirst()
               .orElse("");
    }

    @Override
    public int wordOccurrences(String word) throws StreamTwoFilesError {
        return (int) streamSplitInWord()
                .filter(s -> s.equals(word))
                .count();
    }

    @Override
    public boolean findWord(String word) throws StreamTwoFilesError {
        return streamSplitInWord()
               .anyMatch(s -> s.equals(word));
    }

    private Stream<String> filesToStream(String fileName1, String fileName2) throws StreamTwoFilesError {
        Stream<String> streamFiles;
        File file1 = new File(fileName1);
        File file2 = new File(fileName2);
        Path path1 = file1.toPath();
        Path path2 = file2.toPath();
        try {
            Stream<String> stream1 = Files.lines(path1);
            Stream<String> stream2 = Files.lines(path2);
            streamFiles = Stream.concat(stream1, stream2);
        } catch (IOException e) {
            throw new StreamTwoFilesError("Error accessing files", fileName1, fileName2);
        }
        return streamFiles;
    }

    private Stream<String> streamSplitInWord() throws StreamTwoFilesError {
        return filesToStream(fileName1, fileName2)
                .flatMap(line -> Stream.of(line.split("\\s+")))
                .filter(s -> !s.isEmpty());
    }



}
