import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Movements {
    private final String pathMovementsCsv;
    private HashSet<ExpenseItem> expenseByItem;

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
                    sum += Double.parseDouble(fragment[7]);
                }
            }
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
                        if (fragment[6].matches("\".+\"")){
                            Pattern pattern = Pattern.compile("\\d*,\\d*");
                            Matcher match = pattern.matcher(fragment[6]);
                            if (match.find()) {
                                String d = match.group().replace(",",".");
                                sum += Double.parseDouble(d);
                            }
                            continue;
                        }
                        sum += Double.parseDouble(fragment[6]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sum;
    }

    public HashSet<ExpenseItem> getExpenseSumByItem() {
        expenseByItem = new HashSet<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathMovementsCsv));
            String delimiter = ",(?=([^\"]*\"[^\"]*\")*(?![^\"]*\"))";
            for (int i = 1; i < lines.size(); i++) {
                String[] fragment = lines.get(i).split(delimiter);
                if (fragment.length != 8) {
                    System.out.println("Wrong line: " + lines.get(i));
                } else {
                    double expenseSum;
                    if (fragment[7].matches("\".+\"")){
                        Pattern pattern = Pattern.compile("\\d*,\\d*");
                        Matcher match = pattern.matcher(fragment[7]);
                        if (match.find()) {
                            expenseSum = Double.parseDouble(match.group().replace(",","."));
                            if (expenseSum != 0) {
                                expenseByItem.add(createExpenseItem(getItemName(fragment[5]), expenseSum));
                            }
                        }
                        continue;
                    }
                    expenseSum = Double.parseDouble(fragment[7]);
                    if (expenseSum != 0) {
                        expenseByItem.add(createExpenseItem(getItemName(fragment[5]), expenseSum));
                    }
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return expenseByItem;
    }

    private ExpenseItem createExpenseItem(String name, double sum){
        for (ExpenseItem expenses: expenseByItem){
            String nameExpense = expenses.getName();
            if (nameExpense.equals(name)){
                expenses.addSum(sum);
                return expenses;
            }
        }
        ExpenseItem expenseItem = new ExpenseItem(name);
        expenseItem.addSum(sum);
        return expenseItem;
    }

    private String getItemName(String name){
        Pattern pattern = Pattern.compile("(?<=(\\d{6}(\\+){6}\\d{4})).+(?=(\\d\\d\\.\\d\\d\\.\\d\\d\\s\\d\\d\\.\\d\\d\\.\\d\\d))");
        Matcher match = pattern.matcher(name);
        if (match.find()){
            return match.group().trim();
        } else return name;
    }
}
