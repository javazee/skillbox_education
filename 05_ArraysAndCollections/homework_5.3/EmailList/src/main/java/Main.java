import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";

    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmailList emailList = new EmailList();
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            //TODO: write code here
            if (input.contains("ADD")){
                Pattern pattern = Pattern.compile("(?<=ADD)\\s+[A-Za-z-_0-9]+@[A-Za-z0-9-]+\\.[A-Za-z]+");
                Matcher match = pattern.matcher(input);
                if (input.contains("ADD")) {
                    if (match.find()) {
                        emailList.add(match.group().trim().toLowerCase());
                    } else {
                        System.out.println(Main.WRONG_EMAIL_ANSWER);
                    }
                }
            } else if (input.contains("LIST")){
                System.out.println(emailList.getSortedEmails());
            }
        }
    }
}
