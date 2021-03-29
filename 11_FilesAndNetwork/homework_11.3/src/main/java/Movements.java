import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Movements {
    private HashSet<ExpenseItem> expenseByItem;
    private List<String> lines ;
    private final String path;
    private final long createTime;

    public Movements(String path)  {
        this.path = path;
        lines = getLines();
        createTime = getTime();
    }

    private String getPath(){
        return path;
    }

    public double getExpenseSum() {
        if (!fileIsModified()){
            lines = getLines();
        }
        double sum = 0;
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
        return sum;
    }

    public double getIncomeSum() {
        if (!fileIsModified()){
            lines = getLines();
        }
        double sum = 0;
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
        return sum;
    }

    public HashSet<ExpenseItem> getExpenseSumByItem() {
        if (!fileIsModified()){
            lines = getLines();
        }
        expenseByItem = new HashSet<>();
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

    private List<String> getLines() {
        try {
            return Files.readAllLines(Paths.get(getPath()));
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return lines;
    }

    private Long getTime(){
        File file = new File(getPath());
        return file.lastModified();
    }

    private Boolean fileIsModified(){
        return getTime() == createTime;
    }
}
