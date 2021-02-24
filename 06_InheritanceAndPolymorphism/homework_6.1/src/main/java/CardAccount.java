public class CardAccount extends BankAccount {
    public void take(double amountToTake) {
        //TODO: реализуйте метод и удалите todo
        if (amountToTake * 1.01 <= amount) {
            amount = amount - amountToTake * 1.01;
            System.out.println("Вы сняли " + amountToTake + ". " + "Сумма средств на счете после снятия: " + getAmount() + " руб.");
        } else {
            System.out.println("Недостаточно средств для снятия. Вам доступно " + getAmount() + " руб.");
        }
    }
}
