import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {

    TreeMap<String, Integer> phonebook = new TreeMap<>();
    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
        Pattern space = Pattern.compile("\\D");
        Matcher number = space.matcher(phone);
        Pattern pattern = Pattern.compile("\\b([78])?\\d{10}\\b");
        Matcher onlyDigit = pattern.matcher(number.replaceAll(""));
        if (onlyDigit.find()){
            if (onlyDigit.toString().length() == 10) {
                phone = "7" + onlyDigit.group();
            } else {
                phone = onlyDigit.group().replaceFirst("[78]?", "7");
            }
            phonebook.put(name, Integer.parseInt(phone));
            System.out.println(phonebook.keySet());
        } else {
            System.out.println("Неверный формат ввода");
        }

    }
    public String getNameByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        return "";
    }

    public Set<String> getPhonesByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        return new TreeSet<>();
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        Set<String> copyPhoneBook = phonebook.keySet();
        return copyPhoneBook;
    }

}