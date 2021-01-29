public class Main {

    public static void main(String[] args) {
        String safe = searchAndReplaceDiamonds("Номер кредитной карты <4008 1234 5678> 8912" , "***");
        System.out.println(safe);

    }
    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
        if ((text.indexOf("<") == -1 && text.indexOf(">") == -1) || text.indexOf("<") == -1 || text.indexOf(">") == -1){
            return text;
        } else {
            String initialText = text;
            text = "";
            int leftSign = 0;
            int rightSign;
            for (int i = 0; i < text.length(); i++) {
                if (initialText.indexOf("<") == i){
                    rightSign = i;
                    text = text + initialText.substring(leftSign + 1, rightSign +1);
                }
                if (initialText.indexOf(">") == i) {
                    text = text + placeholder;
                    leftSign = i;
                }
            }
            return text;
        }
    }
}