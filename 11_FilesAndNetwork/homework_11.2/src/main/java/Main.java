import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите путь папки, файлы с которой необходимо копировать:");
            String inputPath = scanner.nextLine();
            System.out.println("Введите путь папки, в которую необходимо копировать файлы:");
            String outputPath = scanner.nextLine();
            FileUtils.copyFolder(inputPath, outputPath);
        } catch (IllegalArgumentException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
