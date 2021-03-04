public interface Employee extends Comparable<Employee> {
    default double getMonthSalary(){
        return 0;
    }
    default double getSalary(){
        return 0;
    }
}
