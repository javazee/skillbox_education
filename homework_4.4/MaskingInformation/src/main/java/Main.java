public class Main {

    public static void main(String[] args) {
        String safe = searchAndReplaceDiamonds("Номер кредитной карты <5896 4668 7898> 5544" , "***");
        String example1 = searchAndReplaceDiamonds("><777>77>> 898998 < < 22>874 <  858>" , "***");
        String example2 = searchAndReplaceDiamonds("<5686>>" , "***");
        String example3 = searchAndReplaceDiamonds("<<5686>>" , "***");
        String example4 = searchAndReplaceDiamonds("номер < 8888 < 5555 > 8888 > some text <5555>", "***");

        System.out.println(safe);
        System.out.println(example1);
        System.out.println(example2);
        System.out.println(example3);
        System.out.println(example4);
    }
    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
        // проверка на соответствие количества левых скобочек количеству правых
        int leftSignSum = 0;
        int rightSignSum = 0;
        for (int i = 0; i < text.length(); i++){
            if (String.valueOf(text.charAt(i)).equals("<")){
                leftSignSum++;
            }
            if (String.valueOf(text.charAt(i)).equals(">")){
                rightSignSum++;
            }
        }
        if (leftSignSum != rightSignSum){
            return text;
        } else if (text.indexOf("<") != -1 && text.indexOf(">") != -1) {
            String initialText = text;
            text ="";
            int leftSign = -1;
            int rightSign = 0;
            for (int i = 0; i < initialText.length(); i++) {
                if (String.valueOf(initialText.charAt(i)).equals("<") && leftSign < rightSign){
                    leftSign = i;
                    if (rightSign != 0) {
                        text = text + placeholder;
                    }
                    text = text + initialText.substring(rightSign , leftSign);
                } else if (String.valueOf(initialText.charAt(i)).equals(">") && leftSign != -1) {
                    rightSign = i + 1;
                    if (i == initialText.length() - 1) {
                        text = text + placeholder;
                        break;
                    }
                } else if (i == initialText.length() - 1) {
                    text = text + placeholder + initialText.substring(rightSign);;
                }
            }
        }
        return text;
    }
}