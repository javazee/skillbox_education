import java.lang.reflect.Array;
import java.util.*;

public class CoolNumbers {

    public static List<String> generateCoolNumbers() {
        int size = 100; //количество сгенерированных номеров
        Map <Integer, String> letters = new TreeMap<>();
        String[] listOfLetters = new String[]{"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        for (int i = 0; i < listOfLetters.length; i++){
            letters.put(i, listOfLetters[i]);
        }
        List <String> coolNumbers = new ArrayList<>();
        for (int i = 0; i < size; i ++) {
            StringBuilder coolNumber = new StringBuilder();
            for (int j = 0; j < 6; j++) {
                if (j == 0 || j > 3) {
                    int letter = (int) Math.round(Math.random() * (letters.size() - 1));
                    coolNumber.append(letters.get(letter));
                } else {
                    int number = (int) Math.round(Math.random() * 9);
                    coolNumber.append(number);
                }
            }
            int region = (int) Math.round(Math.random() * 199);
            coolNumber.append(region);
            coolNumbers.add(coolNumber.toString());
        }
        return coolNumbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        return false;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return false;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return false;
    }

}
