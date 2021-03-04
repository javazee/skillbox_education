public class Main {
    public static void main(String[] args) {
        Company apple = new Company("Apple");
        apple.hire(new TopManager(apple));
        apple.hire(new TopManager(apple));
        apple.hireAll(8, new TopManager(apple));
        apple.hireAll(180, new Operator(apple));
        apple.hireAll(80, new Manager(apple));
        System.out.println("Количество сотрудников компании " + apple.name  + ": " + apple.getCompanySize());
        System.out.println("Топ высоких зарплат сотрудников компании " + apple.name  + ":");
        for (Employee str : apple.getTopSalaryStaff(10)){
            System.out.println(str.getSalary() + " руб.");
        }
        System.out.println("Топ низких зарплат сотрудников компании " + apple.name + ":");
        for (Employee str : apple.getLowestSalaryStaff(30)){
            System.out.println(str.getSalary() + " руб.");
        }
        apple.fire(-5);
        apple.fire(apple.getCompanySize()/2);
        System.out.println("Топ высоких зарплат сотрудников компании " + apple.name  + ":");
        for (Employee str : apple.getTopSalaryStaff(10)){
            System.out.println(str.getSalary() + " руб.");
        }
        System.out.println("Топ низких зарплат сотрудников компании " + apple.name + ":");
        for (Employee str : apple.getLowestSalaryStaff(30)){
            System.out.println(str.getSalary() + " руб.");
        }

        Company orange = new Company("Orange");
        orange.hireAll(3, new TopManager(orange));
        orange.hireAll(15, new Operator(orange));
        orange.hireAll(10, new Manager(orange));
        System.out.println("Количество сотрудников компании " + orange.name  + ": " + orange.getCompanySize());
        System.out.println("Топ высоких зарплат сотрудников компании " + orange.name + ":");
        for (Employee str : orange.getTopSalaryStaff(5)){
            System.out.println(str.getSalary() + " руб");
        }
        System.out.println("Топ низких зарплат сотрудников компании " + orange.name  + ":");
        for (Employee str : orange.getLowestSalaryStaff(5)){
            System.out.println(str.getSalary() + " руб");
        }
    }
}