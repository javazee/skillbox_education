import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {

    TreeMap<String, String> phonebook = new TreeMap<>();
    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
        if (Pattern.matches("[А-Яа-я]+\\s+(\\+)?([78]\\s*\\(\\d{3}\\)\\s*)?\\d\\s*[\\d\\s-]+\\d\\s*\\z", name + " " + phone)) {
            if (!getRightFormat(phone).isEmpty()) {
                phonebook.put(getRightFormat(phone), name);
            }
        }
    }
    public String getNameByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        if (!phonebook.containsKey(getRightFormat(phone))) {
            System.out.println("Такого номера нет в телефонной книге.");
            System.out.println("Введите имя абонента для номера " +  getRightFormat(phone));
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            Pattern patternName = Pattern.compile("[А-Яа-я]+");
            Matcher name = patternName.matcher(input);
            if (name.find()){
                phonebook.put(getRightFormat(phone), name.group().trim());
            }
        }
        return phonebook.get(getRightFormat(phone)) + " - " + getRightFormat(phone);
    }

    public Set<String> getPhonesByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        if (!phonebook.containsValue(name)) {
            System.out.println("Такого имени нет в телефонной книге.");
            System.out.println("Введите номер для абонента " + name);
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            Pattern patternPhone = Pattern.compile("[\\+\\d]+.+");
            Matcher phone = patternPhone.matcher(input);
            if (phone.find()) {
                phonebook.put(getRightFormat(phone.group()), name);
            }
        }
        Set<Map.Entry<String,String>> entrySet = phonebook.entrySet();
        Set<String> phoneByName = new HashSet<>();
        for (Map.Entry<String,String> contact : entrySet) {
            if (name.contains(contact.getValue())) {
                phoneByName.add(name + " - " + contact.getKey());
            }
        }
        return phoneByName;
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        ArrayList<String> allContacts = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> phones = new ArrayList<>();
        for (Map.Entry<String, String> stringIntegerEntry : phonebook.entrySet()) {
            String key = stringIntegerEntry.getKey();
            String value = stringIntegerEntry.getValue();
            names.add(value);
            phones.add(key);
        }
        for (int i = 0; i < names.size(); i++){
            if (i != 0 && names.get(i).equals(names.get(i - 1))){
                allContacts.add(allContacts.get(i-1) + ", " + phones.get(i));
                allContacts.remove(i-1);
                continue;
            }
            allContacts.add(names.get(i) + " - " + phones.get(i));
        }
        return new TreeSet<>(allContacts);
    }
    public String getRightFormat (String phone){
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
            return phone;
        } else {
            System.out.println("Неверный формат ввода");
            return "";
        }
    }

}