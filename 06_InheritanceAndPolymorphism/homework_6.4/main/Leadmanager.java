public class Leadmanager extends Manager {
    double salary;
    static final double fixedSalary = 500;

    public Leadmanager(Company company) {
        super(company);
        salary = getMonthSalary();
    }

    public double getMonthSalary() {
        return fixedSalary;

    }
}
