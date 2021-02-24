public class CardAccount extends BankAccount {
    public void take(double amountToTake) {
        //TODO: реализуйте метод и удалите todo
        if (amountToTake <= amount) {
            amount = amount - amountToTake * 1.01;
            setAmount(amount);
        } else {
            System.out.println("Недостаточно средств");
        }
    }
}
