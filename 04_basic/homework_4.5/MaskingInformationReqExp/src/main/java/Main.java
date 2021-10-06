import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String text = searchAndReplaceDiamonds("номер кредитной карты <<пп <5555> пп >sv <<<6974>svs.", "***");
        System.out.println(text);
        Pattern extraSign = Pattern.compile("[<>]");
        Matcher extraSignIs = extraSign.matcher(text);
        if (extraSignIs.find()){
            System.out.println("Ошибка - не парные скобки!");
        }

    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
        Pattern pattern = Pattern.compile("<[^<]+?>");
        Matcher match = pattern.matcher(text);
        while (match.find()) {
                text = match.replaceAll(placeholder);
                match = pattern.matcher(text);
        }
        return text;
    }
}
