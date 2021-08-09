import java.io.PrintWriter;

public class Loader {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        PrintWriter writer = new PrintWriter("res/numbers.txt");

        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
        int cores = Runtime.getRuntime().availableProcessors();
        int partForThread = 1000/cores;

        for (int i = 0; i < cores; i ++){
            int startNumber = i * partForThread;
            new Thread(() -> {
                for (int number = startNumber; number < startNumber + partForThread; number++) {
                    StringBuffer buffer = new StringBuffer();
                    int regionCode = 199;
                    for (char firstLetter : letters) {
                        for (char secondLetter : letters) {
                            for (char thirdLetter : letters) {
                                buffer.append(firstLetter);
                                buffer.append(padNumber(number, 3));
                                buffer.append(secondLetter);
                                buffer.append(thirdLetter);
                                buffer.append(padNumber(regionCode, 2));
                                buffer.append("\n");
                            }
                        }
                    }
                    writer.write(buffer.toString());
                }
                writer.flush();
                writer.close();
                System.out.println((System.currentTimeMillis() - start) + " ms");
            }).start();
        }
    }

    private static String padNumber(int number, int numberLength) {
//        String numberStr = Integer.toString(number);
//        int padSize = numberLength - numberStr.length();
//
//        for (int i = 0; i < padSize; i++) {
//            numberStr = '0' + numberStr;
//        }
//
//        return numberStr;
        String numberStr = Integer.toString(number);
        int padSize = numberLength - numberStr.length();
        StringBuilder builder = new StringBuilder(numberStr);
        for (int i = 0; i < padSize; i++) {
            builder.insert(0,"0");
        }
        return builder.toString();
    }
}
