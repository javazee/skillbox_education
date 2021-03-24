public class Main {
    public static void main(String[] args) {
        Expense expense = new Expense();
        Income income = new Income();
        String path = "D:\\Winfolders\\Documents\\skillbox\\java_basics\\11_FilesAndNetwork\\" +
                "homework_11.3\\src\\test\\resources\\movementList.csv";
        Movements expenseMovement = new Movements(path);
        Movements incomeMovement = new Movements(path);
        expense.addSum(expenseMovement.getExpenseSum());
        income.addSum(incomeMovement.getIncomeSum());
        expense.printInfo();
        income.printInfo();

    }
}
