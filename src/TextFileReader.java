import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class TextFileReader {
    File file;

    public TextFileReader(File file){
        this.file = file;
    }

    public String getContentAsString() throws IOException{
        FileInputStream inputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(inputStream);

        String s = "";
        while (scanner.hasNext()) {
            s += (scanner.nextLine() + "\n");
        }
        inputStream.close();

        return s;

    }
}
