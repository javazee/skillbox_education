import java.util.Calendar;
import java.util.GregorianCalendar;

public class DepositAccount extends BankAccount {
    Calendar lastIncome = new GregorianCalendar(1000, 0 , 1);
    public void take(double amountToTake) {
        //TODO: реализуйте метод и удалите todo
        if (amountToTake <= amount) {
            long difference = (Calendar.getInstance().getTimeInMillis() - lastIncome.getTimeInMillis())/(24 * 60 * 60 * 1000);
            System.out.println(difference);
            if (difference >= 30) {
                amount = amount - amountToTake;
                setAmount(amount);
                lastIncome = Calendar.getInstance();
            } else {
                System.out.println("Вы можете снять деньги только спустя 30 дней после последнего снятия");
            }
        } else {
            System.out.println("Недостаточно средств");
        }
    }
}
