import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessor {
    public String readFile(String fileName) {
        try {
            Path filePath = Path.of(fileName);
            return Files.readString(filePath).toLowerCase();
        } catch (IOException e) {
            System.out.println("Error! File was not found!\n");
            return "";
        }
    }

    public String[] convertToArrayOfWords(String text) {
        text = text.replaceAll("\\n+", " ");
        text = text.replaceAll("[^a-zA-Z0-9'\\s]", " ");
        String[] wordsArray = text.split("\\s+");
        return wordsArray;
    }
}
