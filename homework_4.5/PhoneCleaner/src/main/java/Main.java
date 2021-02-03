import net.sf.saxon.expr.Component;

import java.sql.SQLOutput;
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
      //while (number.find())
        //System.out.println(number.replaceAll(""));
      Pattern case1 = Pattern.compile("\\b7\\d{10}\\b");
      Pattern case2 = Pattern.compile("\\b8\\d{10}\\b");
      Pattern case3 = Pattern.compile("\\b\\d{10}\\b");
      Matcher numbercase1 = case1.matcher(number.replaceAll(""));
      Matcher numbercase2 = case2.matcher(number.replaceAll(""));
      Matcher numbercase3 = case3.matcher(number.replaceAll(""));
      if (numbercase1.find()){
        System.out.println(numbercase1.group());
      } else if (numbercase2.find()){
        System.out.println((numbercase2.group().replaceFirst("8", "7")));
      } else if (numbercase3.find()){
        System.out.println("7" + numbercase3.group());
      } else {
        System.out.println("Неверный формат номера");
      }


    }
  }

}
