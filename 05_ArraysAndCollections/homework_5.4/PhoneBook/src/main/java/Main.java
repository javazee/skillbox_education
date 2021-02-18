import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        while (true) {
            System.out.println("Введите номер, имя или команду:");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            Pattern patternName = Pattern.compile("[А-Яа-яЁёA-Za-z-]+");
            Pattern patternPhone = Pattern.compile("[\\+\\d]+.+");
            Matcher name = patternName.matcher(input);
            Matcher phone = patternPhone.matcher(input);
            if (input.contains("LIST")) {
                for (String getContact : phoneBook.getAllContacts()) {
                    System.out.println(getContact);
                }
            } else if (phone.find() && name.find()) {
                phoneBook.addContact(phone.group(), name.group());
            } else if (!name.find()){
                System.out.println(phoneBook.getNameByPhone(phone.group()));
            } else if (!phone.find()){
                for (String getContact : phoneBook.getPhonesByName(name.group())) {
                    System.out.println(getContact);
                }
            }
        }

    }
}
