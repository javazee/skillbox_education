
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
      Pattern space = Pattern.compile("\\D");
      Matcher number = space.matcher(input);
      Pattern pattern = Pattern.compile("\\b([78])?\\d{10}\\b");
      Matcher onlynumber = pattern.matcher(number.replaceAll(""));
      if (onlynumber.find()){
        if (onlynumber.toString().length() == 10) {
          System.out.println(("7" + onlynumber.group()));
        } else {
          System.out.println((onlynumber.group().replaceFirst("[78]?", "7")));
        }
      } else {
        System.out.println("Неверный формат номера");
      }


    }
  }

}
