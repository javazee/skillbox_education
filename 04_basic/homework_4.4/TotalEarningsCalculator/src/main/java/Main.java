import static java.lang.Character.*;
import static java.lang.Integer.*;

public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    //TODO: напишите ваш код, результат вывести в консоль
    int secondNumber = 1;
    int firstNumber = 0;
    int salarySum = 0;
    for (int i = 0; i < text.length(); i ++ ){
      if (getNumericValue(text.charAt(i)) == 1 || getNumericValue(text.charAt(i)) == 2 || getNumericValue(text.charAt(i)) == 3 ||
              getNumericValue(text.charAt(i)) == 4 || getNumericValue(text.charAt(i)) == 5 || getNumericValue(text.charAt(i)) == 6 ||
              getNumericValue(text.charAt(i)) == 7 || getNumericValue(text.charAt(i)) == 8 || getNumericValue(text.charAt(i)) == 9) {
        if (secondNumber > firstNumber) {
          firstNumber = i;
          continue;
        }
      }
      if (getNumericValue(text.charAt(i)) != 1 && getNumericValue(text.charAt(i)) != 2 && getNumericValue(text.charAt(i)) != 3 &&
              getNumericValue(text.charAt(i)) != 4 && getNumericValue(text.charAt(i)) != 5 && getNumericValue(text.charAt(i)) != 6 &&
              getNumericValue(text.charAt(i)) != 7 && getNumericValue(text.charAt(i)) != 8 && getNumericValue(text.charAt(i)) != 9 &&
              getNumericValue(text.charAt(i)) != 0){
        if (secondNumber  < firstNumber) {
          secondNumber = i ;
          salarySum = salarySum +  parseInt(text.substring(firstNumber, secondNumber));
        }
      }
    }
    System.out.println(salarySum);
  }
}