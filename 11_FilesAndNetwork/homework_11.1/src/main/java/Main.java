import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите путь до папки:");
                String path = scanner.nextLine();
                System.out.println("Размер содержимого по адресу " + path + " " + FileUtils.calculateFolderSize(path) + " байт");
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            }
        }
    }
}
