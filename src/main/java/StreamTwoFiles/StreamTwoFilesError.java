package StreamTwoFiles;

public class StreamTwoFilesError extends Exception {
    private final String fileName1;
    private final String fileName2;

    public StreamTwoFilesError(String message, String fileName1, String fileName2) {
        super(message);
        this.fileName1 = fileName1;
        this.fileName2 = fileName2;
    }

    public String getFileName1() {
        return fileName1;
    }

    public String getFileName2() {
        return fileName2;
    }
}
