import net.sf.saxon.expr.Component;

import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        while (true) {
            System.out.println("Введите номер, имя или команду:");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            Pattern patternName = Pattern.compile("[А-Яа-я]+");
            Pattern patternPhone = Pattern.compile("[\\+\\d]+.+");
            Matcher name = patternName.matcher(input);
            Matcher phone = patternPhone.matcher(input);
            if (name.find() && phone.find()) {
                phoneBook.addContact(phone.group(), name.group());
            } else if (phone.find() && !name.find()){
                System.out.println(phoneBook.getNameByPhone(phone.group()));
            } else if (name.find() && !phone.find()){
                for (String getPhone : phoneBook.getPhonesByName(name.group())) {
                    System.out.println(getPhone);
                }
            } else if (input.contains("LIST")) {
                for (String getContact : phoneBook.getAllContacts()) {
                    System.out.println(getContact);
                }
            }
        }

    }
}
