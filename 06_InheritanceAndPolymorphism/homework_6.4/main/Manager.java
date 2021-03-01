public class Manager implements Employee{
    static double salary;
    static String name;
    static final double fixedSalary = 50000;

    public Manager (){
        name = getName();
        salary = getMonthSalary();
    }

    @Override
    public double getMonthSalary() {
        return (fixedSalary + 0.05 * Math.round(Math.random() * (140000 - 115000) + 115000));
    }

    public String getName() {
        String[] names = new String[]{"OlegPetrovich", "MariyaNikolaevna", "SergeyVictorovich", "OlgaPavlovna", "IvanDmitrievich"};
        return names[(int) Math.round(Math.random() * (names.length - 1))];
    }
}
