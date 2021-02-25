public class CardAccount extends BankAccount {
    protected void take(double amountToTake) {
        if (amountToTake * 1.01 <= getAmount()) {
            setAmount(getAmount() - amountToTake * 1.01);
            System.out.println("Вы сняли " + amountToTake + ". " + "Сумма средств на счете после снятия: " + getAmount() + " руб.");
        } else {
            System.out.println("Недостаточно средств для снятия. Вам доступно " + getAmount() + " руб.");
        }
    }
}
