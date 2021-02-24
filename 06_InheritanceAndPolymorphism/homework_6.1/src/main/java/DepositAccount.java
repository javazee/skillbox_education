import java.util.Calendar;
import java.util.GregorianCalendar;

public class DepositAccount extends BankAccount {
    Calendar lastIncome = new GregorianCalendar(1000, 0 , 1);
    public void take(double amountToTake) {
        //TODO: реализуйте метод и удалите todo
        if (amountToTake <= amount) {
            long difference = (Calendar.getInstance().getTimeInMillis() - getTime().getTimeInMillis())/(24 * 60 * 60 * 1000);
            if (difference >= 30) {
                amount = amount - amountToTake;
                lastIncome = Calendar.getInstance();
                System.out.println("Сумма средств на счете после снятия: " + getAmount() + " руб.");
            } else {
                System.out.println("Вы можете снять деньги только спустя 30 дней после последнего снятия");
            }
        } else {
            System.out.println("Недостаточно средств для снятия. Вам доступно " + getAmount() + " руб.");
        }
    }
    public void setTime (int year, int month, int day){
        lastIncome.set(year, month, day);
    }
    public Calendar getTime (){
        return lastIncome;
    }
}
