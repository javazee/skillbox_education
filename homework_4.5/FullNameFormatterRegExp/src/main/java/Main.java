import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      String regex = "(\s+)?[а-яА-ЯЁё](([а-яА-ЯЁё]+)?[-][а-яА-ЯЁё])?([а-яА-ЯЁё]+)?\s+" +    //фамилия, может содержать тире или быть из одной буквы
              "[а-яА-ЯЁё](([а-яА-ЯЁё]+)?[-][а-яА-ЯЁё]?)?[а-яА-ЯЁё]+\s+" +                   //имя, может быть с тире, минимум 2 символа
              "[а-яА-ЯЁё](([а-яА-ЯЁё]+)?[-][а-яА-ЯЁё]?)?[а-яА-ЯЁё]+(\s+)?";                 //отчество, может быть с тире, миннимум 2 символа
      Pattern familyPattern = Pattern.compile("\\b[а-яА-ЯЁё-]+\\b");
      Matcher family = familyPattern.matcher(input);
      if (Pattern.matches(regex, input)) {
        family.find();
        System.out.println("Фамилия: " + family.group());
        family.find();
        System.out.println("Имя: " + family.group());
        family.find();
        System.out.println("Отчество: " + family.group());
      } else {
        System.out.println("Введенная строка не является ФИО");
      }
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
    }
  }

}