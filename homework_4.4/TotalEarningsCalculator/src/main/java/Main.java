import static java.lang.Integer.*;

public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    //TODO: напишите ваш код, результат вывести в консоль
    int vasyaEarnLeft = text.indexOf("л") + 1;
    int vasyaEarnRight = text.indexOf(" ", text.indexOf("л") + 2);
    String vasyaEarn = (text.substring(vasyaEarnLeft, vasyaEarnRight)).trim();
    //System.out.println(vasyaEarn);
    int petyaEarnLeft = text.indexOf("-") + 1;
    int petyaEarnRight = text.indexOf(" ", petyaEarnLeft + 2);
    String petyaEarn = (text.substring(petyaEarnLeft, petyaEarnRight)).trim();
    //System.out.println(petyaEarn);
    int mashaEarnLeft = text.lastIndexOf("-");
    int mashaEarnRight = text.lastIndexOf("р");
    String mashaEarn = (text.substring(mashaEarnLeft + 1, mashaEarnRight)).trim();
    //System.out.println(mashaEarn);
    int moneyAmount = parseInt(petyaEarn) + parseInt(vasyaEarn) + parseInt(mashaEarn);
    System.out.println(moneyAmount);

  }

}