public class BankAccount {
  double amount = 0;

  public double getAmount() {
    //TODO: реализуйте метод и удалите todo
    return amount;
  }

  public void put(double amountToPut) {
    //TODO: реализуйте метод и удалите todo
    if (amountToPut >= 0 ){
      amount = amount + amountToPut;
      System.out.println("Вы внесли " + amountToPut + ". " + "Сумма средств на счете после пополнения: " + getAmount() + " руб.");
    } else {
      System.out.println("Некорректный ввод. Сумма осталась прежней: " + getAmount() + " руб.");
    }
  }

  public void take(double amountToTake) {
    //TODO: реализуйте метод и удалите todo
    if (amountToTake <= amount){
      amount = amount - amountToTake;
      System.out.println("Вы сняли " + amountToTake + ". " + "Сумма средств на счете после снятия: " + getAmount() + " руб.");
    }
    else {
      System.out.println("Недостаточно средств для снятия. Вам доступно " + getAmount() + " руб.");
    }
  }

  boolean send(BankAccount receiver, double amount){
    double balance = getAmount();
    take(amount);
    if (balance != getAmount()) {
      receiver.put(amount);
      return true;
    } else {
      return false;
    }
  }
}
