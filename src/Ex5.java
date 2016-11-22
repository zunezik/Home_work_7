
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex5 {
    public static final int LENGTH = 10;

    public static void main(String[] args) throws IOException {
        menu();
    }

    public static void menu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1) Add new human.");
            System.out.println("2) Exit.");
            System.out.println("3) Read file.");
            System.out.println("4) Delete record.");
            System.out.print("Select option: ");
            int choice = scanner.nextInt();
            if (choice == 1) writeFile();
            if (choice == 2) System.exit(0);
            if (choice == 3) printFile();
            if (choice == 4) deleteFile();
        }
    }

    public static Human addHuman() {
        Scanner scanner = new Scanner(System.in);
        Human human = new Human();

        System.out.print("Enter name: ");
        human.name = scanner.nextLine();
        System.out.print("Enter surname:");
        human.surname = scanner.nextLine();
        System.out.print("Enter age: ");
        human.age = scanner.nextInt();
        return human;
    }

    public static void writeFile() throws IOException {
        Scanner scanner = new Scanner(System.in);
        File file = new File("D:/test-java.txt");
        file.createNewFile();
        FileOutputStream outputStream = new FileOutputStream(file, true); //(file, true) - дописать, (file) - перезаписать

        Human[] human = new Human[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            human[i] = new Human();
            human[i] = addHuman();
            String s = human[i].name + "|" + human[i].surname + "|" + human[i].age + "\r\n";
            outputStream.write(s.getBytes());
            System.out.println("Press '1' to finish, or any key to add new human");
            String finish = scanner.nextLine();
            if (finish.equals("1")) break;
        }
        outputStream.close();
    }

    public static String readStrings() throws IOException {
        File file = new File("D:/test-java.txt");
        if (file.exists() == false) {
            System.out.println("File does not exists!");
            menu();
        }
        FileInputStream inputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(inputStream);

        if (inputStream.available() == 0) {
            System.out.println("File is empty!");
            menu();
        }

        String s = "";
        while (scanner.hasNext()) {
            s += scanner.nextLine() + "\n";
        }
        inputStream.close();
        return s;
    }

    public static Human[] readFile() throws IOException {
        int personsCount = countLines(readStrings());
        String[] parts = mySplit(readStrings());
        Human[] human = new Human[personsCount];
        int k = 0;
        for (int i = 0; i < personsCount; i++) {
            human[i] = new Human();
            human[i].name = parts[k];
            k++;
            human[i].surname = parts[k];
            k++;
            human[i].age = Integer.parseInt(parts[k]);
            k++;
        }
        return human;
    }

    public static void printFile() throws IOException {
        Human[] humen = readFile();
        int personsCount = countLines(readStrings());
        for (int i = 0; i < personsCount; i++) {
            System.out.print(i + 1 + "-> Name: " + humen[i].name + "; ");
            System.out.print("Surname: " + humen[i].surname + "; ");
            System.out.print("Age: " + humen[i].age + "; ");
            System.out.println();
        }
    }

    public static String[] mySplit(String s) {
        String[] parts = s.split("\\||\n");
        return parts;
    }

    private static int countLines(String str) {
        String[] lines = str.split("\r\n|\r|\n");
        return lines.length;
    }

    public static void deleteFile() throws IOException {
        Scanner in = new Scanner(System.in);

        System.out.print("What record to delete? ->");
        int choice = in.nextInt();
        int trueChoice = choice - 1;

        File file = new File("D:/test-java2.txt");
        file.createNewFile();
        FileOutputStream outputStream = new FileOutputStream(file);

        Human[] human = new Human[LENGTH];
        Human[] humen = readFile();
        for (int i = 0; i < humen.length; i++) {
            if (i == trueChoice) continue;
            human[i] = humen[i];
            String s = human[i].name + "|" + human[i].surname + "|" + human[i].age + "\r\n";
            outputStream.write(s.getBytes());
        }
        outputStream.close();

        File oldFile = new File("D:/test-java.txt");
        oldFile.delete();
        file.renameTo(oldFile);
    }
}
