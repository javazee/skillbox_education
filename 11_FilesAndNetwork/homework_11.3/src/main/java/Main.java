public class Main {
    public static void main(String[] args) {
        Expense expense = new Expense();
        Income income = new Income();
        String path = "D:\\Winfolders\\Documents\\skillbox\\java_basics\\11_FilesAndNetwork\\" +
                "homework_11.3\\src\\test\\resources\\movementList.csv";
        Movements movements = new Movements(path);
        expense.addSum(movements.getExpenseSum());
        income.addSum(movements.getIncomeSum());
        expense.printInfo();
        income.printInfo();
        System.out.println("\nСуммы расходов по организациям:");
        for (ExpenseItem expenseItem: movements.getExpenseSumByItem()){
            System.out.println(expenseItem);
        }
    }
}
