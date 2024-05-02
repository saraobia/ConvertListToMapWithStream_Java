package StatsFileWords;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StatsFileWords implements StreamWords {
    private String fileName;

    public StatsFileWords(String fileName) throws IOException {
        this.fileName = fileName;
    }

    @Override
    public long countAll() throws IOException {
        return fileToStream(fileName)
                .flatMap(line -> Stream.of(line.split(" +")))
                .filter(s -> !s.isEmpty())
                .count();
    }

    @Override
    public String[] words() throws IOException {
        return fileToStream(fileName)
                .flatMap(line -> Stream.of(line.split("\\s+")))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList())
                .toArray(String[]::new);
    }

    @Override
    public long count(String word) throws IOException {
        return fileToStream(fileName)
                .flatMap(line -> Stream.of(line.split("\\s+")))
                .filter(s -> !s.isEmpty() && s.equals(word))
                .count();
    }

    @Override
    public String wordGreater() throws IOException {
        return fileToStream(fileName)
                .flatMap(line -> Stream.of(line.split("\\s+")))
                .filter(s -> !s.isEmpty())
                .sorted(((o1, o2) -> o2.compareTo(o1)))
                .findFirst()
                .get();
    }

    @Override
    public String[] wordsWithLenghtLessThen(int numChar) throws IOException {
        return fileToStream(fileName)
               .flatMap(line -> Stream.of(line.split("\\s+")))
                .filter(s -> !s.isEmpty() && s.length() < numChar)
                .collect(Collectors.toList())
                .toArray(String[]::new);
    }

    @Override
    public String wordsJoined() throws IOException {
        return fileToStream(fileName)
                .flatMap(line -> Stream.of(line.split("\\s+")))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining(", "));
    }

    private Stream<String> fileToStream(String fileName) throws IOException {
        Stream<String> streamFile = null;
        File file = new File(fileName);
        try {
            Path path = file.toPath();
            streamFile = Files.lines(path);
        } catch(IOException e) {
            System.out.println("File " + fileName + " is not found");
        }
        return streamFile;
    }
}
