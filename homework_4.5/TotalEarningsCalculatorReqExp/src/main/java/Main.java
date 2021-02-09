import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {
    int sum = calculateSalarySum(" Вася заработал 50000р, Катя - 30000 р., а Коля 56000");
    System.out.println(sum);
  }

  public static int calculateSalarySum(String text){
    //TODO: реализуйте метод
    Pattern pattern = Pattern.compile("\\d+");
    Matcher mather = pattern.matcher(text);
    int sum = 0;
    while (mather.find()){
      sum += Integer.parseInt(mather.group());
    }
    return sum;
  }

}