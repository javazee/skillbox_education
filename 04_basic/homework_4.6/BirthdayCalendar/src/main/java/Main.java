import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 18;
        int month = 12;
        int year = 1992;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        //TODO реализуйте метод для построения строки в следующем виде
        Calendar myBirthday = new GregorianCalendar(year, month - 1, day);
        Calendar calendar = new GregorianCalendar();
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy - EE", Locale.ENGLISH);
        //DateFormat df = new SimpleDateFormat("dd.MM.yyyy - EEEE"); //вариант с выводом на русском
        DateFormat dayFormat = new SimpleDateFormat("EEE", Locale.ENGLISH);
        String listOfBirthday = "";
        int i = 0;
        while (myBirthday.getTime().before(calendar.getTime())){
            listOfBirthday += i + " - " + df.format(myBirthday.getTime()) + System.lineSeparator();
            myBirthday.add(Calendar.YEAR, 1);
            i++;
        }
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue
        return listOfBirthday;
    }
}
