public interface Employee {
    default double getMonthSalary(){
        return 0;
    }
}
