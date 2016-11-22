import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) throws IOException {
        File file = new File("D:/test-java.txt");
        file.createNewFile();


        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write("Hello, dear student!\nHow are you?".getBytes());
        outputStream.close();

        System.out.println(getAllTextFromFile(file));

        file.delete();
    }


    public static String getAllTextFromFile(File file) throws IOException {
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