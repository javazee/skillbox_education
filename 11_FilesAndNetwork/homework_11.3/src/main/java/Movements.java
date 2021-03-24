import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Movements {
    private String pathMovementsCsv;

    public Movements(String pathMovementsCsv) {
        this.pathMovementsCsv = pathMovementsCsv;
    }

    public double getExpenseSum() {
        double sum = 0;
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathMovementsCsv));
            String delimiter = ",(?=([^\"]*\"[^\"]*\")*(?![^\"]*\"))";
            for (int i = 1; i < lines.size(); i++) {
                String[] fragment = lines.get(i).split(delimiter);
                if (fragment.length != 8) {
                    System.out.println("Wrong line: " + lines.get(i));
                } else {
                    if (fragment[7].matches("\".+")){
                        Pattern pattern = Pattern.compile("\\d*,\\d*");
                        Matcher match = pattern.matcher(fragment[7]);
                        if (match.find()) {
                            sum += Double.parseDouble(match.group().replace(",","."));
                        }
                        continue;
                    }
                    sum += Double.parseDouble(fragment[7].replace(",","."));
                }
            }
            return sum;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sum;
    }



        public double getIncomeSum() {
            double sum = 0;
            try {
                List<String> lines = Files.readAllLines(Paths.get(pathMovementsCsv));
                String delimiter = ",(?=([^\"]*\"[^\"]*\")*(?![^\"]*\"))";
                for (int i = 1; i < lines.size(); i++) {
                    String[] fragment = lines.get(i).split(delimiter);
                    if (fragment.length != 8) {
                        System.out.println("Wrong line: " + lines.get(i));
                    } else {
                        if (fragment[6].matches("\".+")){
                            Pattern pattern = Pattern.compile("\\d*,\\d*");
                            Matcher match = pattern.matcher(fragment[6]);
                            if (match.find()) {
                                String d = match.group().replace(",",".");
                                sum += Double.parseDouble(d);
                            }
                            continue;
                        }
                        String d = fragment[6].replace(",",".");
                        sum += Double.parseDouble(d);
                    }
                }
                return sum;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sum;
    }
}
