public class Operator implements Employee{
    static double salary;
    static String name;

    public Operator (){
        name = getName();
        salary = getMonthSalary();
    }
    @Override
    public double getMonthSalary() {
        return Math.round(Math.random() * (50000 - 30000) + 20000);
    }
    public String getName() {
        String[] names = new String[]{"Petya", "Dima", "Vasya", "Valera", "Semenych", "Augusto", "SanSanych", "Katya", "Masha", "Vova", "Petrovich", "Olga", "Irina"};
        return names[(int) Math.round(Math.random() * (names.length - 1))];
    }
}
