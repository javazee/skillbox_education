public class Main {

    public static void main(String[] args) {
        String safe = searchAndReplaceDiamonds("Номер кредитной карты <<5896> <4668> <8898>> 5544", "***");
        String example1 = searchAndReplaceDiamonds("Номер кредитной карты <<5896>> 4668 <<8898>> 5544", "***");
        String example2 = searchAndReplaceDiamonds("<<5686>", "***");
        String example3 = searchAndReplaceDiamonds("<<5686>>", "***");
        String example4 = searchAndReplaceDiamonds("номер <8888 < 5555 > 8888 > some text <5555>", "***");

        System.out.println(safe);
        System.out.println(example1);
        System.out.println(example2);
        System.out.println(example3);
        System.out.println(example4);
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
        int count = 0;
        String initialText = text;
        text = "";
        State.setState(count);//не пойму, почему программа не работает без этой строки
        for (int i = 0; i < initialText.length(); i++) {
            if (String.valueOf(initialText.charAt(i)).equals("<")) {
                count++;
                State.setState(count);
            } else if (String.valueOf(initialText.charAt(i)).equals(">")) {
                count--;
                if (count < 0){
                    text = initialText;
                    break;
                }
                State.setState(count);
                if (State.getState()) {
                    text = text + placeholder;
                }
            } else if (State.getState()) {
                text = text + initialText.charAt(i);
            }
        }
        if (count > 0){
            text = initialText;
        }
        return text;
    }
}
class State {
    private static boolean isOpening;
    public State() {
        isOpening = false;
    }
    public static void setState(int count) {
        isOpening = count > 0;
    }
    public static boolean getState() {
        return !isOpening;
    }
}