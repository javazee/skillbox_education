public class Main {

    public static void main(String[] args) {
        String safe = searchAndReplaceDiamonds("Номер кредитной карты <4008 1234 5678> 8912" , "***");
        System.out.println(safe);

    }
    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
        if (text.indexOf("<") != -1 && text.indexOf(">") != -1) {
            String initialText = text;
            text ="";
            int leftSign = -1;
            int rightSign = 0;
            for (int i = 0; i < initialText.length(); i++) {
                if (initialText.indexOf("<", leftSign) == i) {
                    rightSign = i;
                    text = text + initialText.substring(leftSign + 1, rightSign);
                    continue;
                }
                if (initialText.indexOf(">", rightSign) == i) {
                    text = text + placeholder;
                    leftSign = i;
                    if (i == initialText.lastIndexOf(">")) {
                        text = text + initialText.substring(initialText.lastIndexOf(">") + 1);
                        break;
                    }
                }
            }
        }
        return text;
    }
}