import net.sf.saxon.expr.Component;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        System.out.println("Введите номер, имя или команду:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern patternName = Pattern.compile("[А-Яа-я]+");
        Pattern patternPhone = Pattern.compile("[\\+\\d]+.+");
        Matcher name = patternName.matcher(input);
        Matcher phone = patternPhone.matcher(input);
        if (Pattern.matches("/[А-Яа-я]+\\s+(\\+)?([78]\\s*\\(\\d{3}\\)\\s*)?\\d\\s*[\\d\\s-]+\\d\\s*\\z/gm", input)){
            phoneBook.addContact(phone.toString(), name.toString());
        }
        System.out.println(phoneBook.getAllContacts());
    }
}
