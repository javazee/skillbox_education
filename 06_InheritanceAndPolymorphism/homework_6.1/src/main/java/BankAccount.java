public class BankAccount {
  private double amount = 0;

  protected void setAmount(double amount) {
    this.amount = amount;
  }

  protected double getAmount() {
    return amount;
  }

  protected void put(double amountToPut) {
    if (amountToPut >= 0 ){
      amount = amount + amountToPut;
      System.out.println("Вы внесли " + amountToPut + ". " + "Сумма средств на счете после пополнения: " + getAmount() + " руб.");
    } else {
      System.out.println("Некорректный ввод. Сумма осталась прежней: " + getAmount() + " руб.");
    }
  }

  protected void take(double amountToTake) {
    if (amountToTake <= amount){
      amount = amount - amountToTake;
      System.out.println("Вы сняли " + amountToTake + ". " + "Сумма средств на счете после снятия: " + getAmount() + " руб.");
    }
    else {
      System.out.println("Недостаточно средств для снятия. Вам доступно " + getAmount() + " руб.");
    }
  }

  protected boolean send(BankAccount receiver, double amount){
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
