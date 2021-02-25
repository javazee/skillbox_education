import java.util.Calendar;
import java.util.GregorianCalendar;

public class DepositAccount extends BankAccount {
    private Calendar lastIncome = new GregorianCalendar(1000, 0 , 1);
    protected void take(double amountToTake) {
        //TODO: реализуйте метод и удалите todo
        if (amountToTake <= getAmount()) {
            long difference = (Calendar.getInstance().getTimeInMillis() - getTime().getTimeInMillis())/(24 * 60 * 60 * 1000);
            if (difference >= 30) {
                setAmount(getAmount() - amountToTake);
                lastIncome = Calendar.getInstance();
                System.out.println("Сумма средств на счете после снятия: " + getAmount() + " руб.");
            } else {
                System.out.println("Вы можете снять деньги только спустя 30 дней после последнего снятия");
            }
        } else {
            System.out.println("Недостаточно средств для снятия. Вам доступно " + getAmount() + " руб.");
        }
    }
    protected void setTime (int year, int month, int day){
        lastIncome.set(year, month, day);
    }
    private Calendar getTime (){
        return lastIncome;
    }
}
