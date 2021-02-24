public class BankAccount {
  double amount = 1000;

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public double getAmount() {
    //TODO: реализуйте метод и удалите todo
    return amount;
  }

  public void put(double amountToPut) {
    //TODO: реализуйте метод и удалите todo
    if (amountToPut >= 0 ){
      amount = amount + amountToPut;
      setAmount(amount);
    }
  }

  public void take(double amountToTake) {
    //TODO: реализуйте метод и удалите todo
    if (amountToTake <= amount){
      amount = amount - amountToTake;
      setAmount(amount);
    }
    else {
      System.out.println("Недостаточно средств");
    }

  }
}
