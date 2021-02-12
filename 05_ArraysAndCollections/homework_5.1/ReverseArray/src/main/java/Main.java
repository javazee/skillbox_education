import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String line = "Каждый охотник желает знать, где сидит фазан";
        String[] strings = line.split("([^А-Яа-яЁё])?\\s+");
        for (int i = 0; i < 2; i++ ){
            System.out.println(Arrays.toString(ReverseArray.reverse(strings)));
        }
    }
}
