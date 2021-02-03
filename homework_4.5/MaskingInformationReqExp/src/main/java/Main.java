import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String text = searchAndReplaceDiamonds("номер кредитной карты <<<5555>>sv <6974>>svs.", "***");
        System.out.println(text);
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
        Pattern pattern = Pattern.compile("<.+?>+");
        Matcher match = pattern.matcher(text);
        String newtext ="";
        if (match.find()) {
            newtext = match.replaceAll(placeholder);
        } else
        {
            newtext = text;
        }
        return newtext;
    }
}
