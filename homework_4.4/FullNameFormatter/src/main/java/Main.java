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
      if (input.indexOf("0") != -1 || input.indexOf("1") != -1 || input.indexOf("2") != -1 || input.indexOf("3") != -1 ||
              input.indexOf("4") != -1 || input.indexOf("5") != -1 || input.indexOf("6") != -1 || input.indexOf("7") != -1 ||
              input.indexOf("8") != -1 || input.indexOf("9") != -1) {
        System.out.println("Введенная строка не является ФИО");
        break;
      }
      int secondSpace = input.indexOf(" ", input.trim().indexOf(" ") + 2);
      if (secondSpace == input.trim().lastIndexOf(" ")) {
        if (secondSpace != -1) {
          String surname = input.trim().substring(0, input.trim().indexOf(" "));
          String name = input.trim().substring(input.trim().indexOf(" ") +1, secondSpace);
          String patronymic = input.substring(secondSpace).trim();
          System.out.printf("Фамилия: %s%nИмя: %s%nОтчество: %s", surname, name, patronymic);
          break;
        } else {
          System.out.println("Введенная строка не является ФИО");
        }
      } else {
        System.out.println("Введенная строка не является ФИО");
        break;
      }
      break;
    }
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
    }
  }