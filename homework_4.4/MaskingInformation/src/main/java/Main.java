import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String safe = searchAndReplaceDiamonds("Номер кредитной карты <<5896> <4668> <8898>> 5544" , "***");
        String example1 = searchAndReplaceDiamonds("Номер кредитной карты <<5896>> 4668 <<8898>> 5544" , "***");
        String example2 = searchAndReplaceDiamonds("<5686>>" , "***");
        String example3 = searchAndReplaceDiamonds("<<5686>>" , "***");
        String example4 = searchAndReplaceDiamonds("номер <8888 < 5555 > 8888 > some text <5555>", "***");

        System.out.println(safe);
        System.out.println(example1);
        System.out.println(example2);
        System.out.println(example3);
        System.out.println(example4);
    }
    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
        // проверка на соответствие количества левых скобочек количеству правых
        ArrayList<Integer> leftBrace= new ArrayList<>();
        ArrayList<Integer> rightBrace= new ArrayList<>();
        for (int i = 0; i < text.length(); i++){
            if (String.valueOf(text.charAt(i)).equals("<")){
                leftBrace.add(i);
            }
            if (String.valueOf(text.charAt(i)).equals(">")){
                rightBrace.add(i);
            }
        }
        if (leftBrace.size() != rightBrace.size()){
            return text;
        } else if (text.contains("<")) {
            String initialText = text;
            leftBrace.add(text.length());
            text ="";
            int leftSign = -1;
            int rightSign = 0;
            for (int i = 0; i < rightBrace.size(); i++) {
                if (leftBrace.get(i) < rightBrace.get(i) && leftSign < rightSign ){
                    leftSign = leftBrace.get(i);
                    text = text + initialText.substring(rightSign , leftSign);
                }
                if (rightBrace.get(i) > leftBrace.get(i) && rightBrace.get(i) < leftBrace.get(i + 1)){
                    rightSign = rightBrace.get(i) + 1;
                    text = text + placeholder;
                    if (i == rightBrace.size() - 1){
                        text = text + initialText.substring(rightSign);
                    }
                }
            }
        }
        return text;
    }
}