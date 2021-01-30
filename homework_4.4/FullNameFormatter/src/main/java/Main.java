import java.util.Scanner;
public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    while (true) {
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      //Проверка на наличие цифр и символов в тексте
      if (input.indexOf("0") != -1 || input.indexOf("1") != -1 || input.indexOf("2") != -1 || input.indexOf("3") != -1 ||
              input.indexOf("4") != -1 || input.indexOf("5") != -1 || input.indexOf("6") != -1 || input.indexOf("7") != -1 ||
              input.indexOf("8") != -1 || input.indexOf("9") != -1 || input.indexOf("_") != -1 || input.indexOf("/") != -1 ||
              input.indexOf("*") != -1 || input.indexOf("+") != -1 || input.indexOf("!") != -1 || input.indexOf(":") != -1){
        System.out.println("Введенная строка не является ФИО");
        break;
      }
      //Отработка сценария, когда между словами несколько пробелов
      int leftIndexOfFirstSpace = -1;
      int rightIndexOfFirstSpace = -1;
      int leftIndexOfSecondSpace = -1;
      int rightIndexOfSecondSpace = -1;
      int leftIndexOfThirdSpace = -1;
      boolean secondSpace = false;
      boolean thirdSpace = false;
      for (int i = 0; i < input.trim().length(); i++){
        String spaceFounder = String.valueOf(input.trim().charAt(i));
        if (spaceFounder.equals(" ") && leftIndexOfFirstSpace == -1){
          leftIndexOfFirstSpace = i;
        } else if (!spaceFounder.equals(" ") && rightIndexOfFirstSpace < leftIndexOfFirstSpace) {
          rightIndexOfFirstSpace = i;
        } else if (spaceFounder.equals(" ") && leftIndexOfSecondSpace < rightIndexOfFirstSpace){
          leftIndexOfSecondSpace = i;
        } else if (!spaceFounder.equals(" ") && rightIndexOfSecondSpace < leftIndexOfSecondSpace){
          rightIndexOfSecondSpace = i;
          secondSpace = true;
        } else if (spaceFounder.equals(" ") && leftIndexOfThirdSpace < rightIndexOfSecondSpace){
          leftIndexOfThirdSpace = i;
        } else if (!spaceFounder.equals(" ") &&  leftIndexOfThirdSpace != -1){
          thirdSpace = true;
          break;
        }
      }
      //проверка на корректность расположения дефиса в тексте
      boolean dashIsCorrect = true;
      for (int i = 0; i < input.length() - 1; i++){
        if (String.valueOf(input.trim().charAt(i)).equals("-") && String.valueOf(input.trim().charAt(i + 1)).equals(" ")){
          dashIsCorrect = false;
        }
      }
      for (int i = input.length() - 1; i > 1; i--){
        if (String.valueOf(input.trim().charAt(i)).equals("-") && String.valueOf(input.trim().charAt(i - 1)).equals(" ")){
          dashIsCorrect = false;
        }
      }
      if (String.valueOf(input.trim().charAt(0)).equals("-") || String.valueOf(input.trim().charAt(input.trim().length() - 1)).equals("-")){
        dashIsCorrect = false;
      }
      /////////////////////////////////////
      if (secondSpace && !thirdSpace && dashIsCorrect){
        String surname = input.trim().substring(0, leftIndexOfFirstSpace);
        String name = input.trim().substring(rightIndexOfFirstSpace, leftIndexOfSecondSpace);
        String patronymic = input.substring(rightIndexOfSecondSpace).trim();
        System.out.printf("Фамилия: %s%nИмя: %s%nОтчество: %s", surname, name, patronymic);
      } else {
        System.out.println("Введенная строка не является ФИО");
      }
      break;
    }
  }
}
