import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        System.out.println("Введите задачу для добавления в список:");
        Scanner getTask = new Scanner(System.in);
        String task = getTask.nextLine();
        todoList.add(task);
        System.out.println("Введите задачу для добавления в список:");
        task = getTask.nextLine();
        System.out.println("Присвоить приоритет для задачи? 1 - да; 0 - нет");
        Scanner action  = new Scanner(System.in);
        int number = action.nextInt();
        if (number == 0) {
            todoList.add(task);
        } else {
            System.out.println("Введите приоритет для задачи от 1 до " + (todoList.getTodos().size() + 1) + " ,где 1 - первый пункт в списке");
            number = action.nextInt();
            if (number == todoList.getTodos().size() + 1){
                todoList.add(task);
            } else {
                todoList.add(number - 1, task);
            }
        }
        System.out.println("Нажмите: 0 - если хотите вывести список активных задач\n" +
                "\t\t1 - если хотите добавить новую задачу\n" +
                "\t\t2 - если хотите удалить задачу\n" +
                "\t\t3 - если хотите заменить задачу\n" +
                "\t\t4 - если хотите выйти из программы");
        number = action.nextInt();
        while (number != 4) {
            if (number == 0) {
                System.out.println("Список активных задач: ");
                for (int i = 0; i < todoList.getTodos().size(); i ++){
                    System.out.println((i + 1) + " - " + todoList.getTodos().get(i));
                }
                System.out.println("Нажмите: 1 - если хотите добавить новую задачу\n" +
                        "\t\t2 - если хотите удалить задачу\n" +
                        "\t\t3 - если хотите заменить задачу\n" +
                        "\t\t4 - если хотите выйти из программы");
                number = action.nextInt();
            }
            if (number == 1) {
                System.out.println("Введите задачу для добавления в список: ");
                task = getTask.nextLine();
                System.out.println("Присвоить приоритет для задачи? 1 - да; 0 - нет");
                number = action.nextInt();
                if (number == 0) {
                    todoList.add(task);
                } else {
                    System.out.println("Введите приоритет для задачи от 1 до " + (todoList.getTodos().size() + 1) + " ,где 1 - первый пункт в списке");
                    number = action.nextInt();
                    if (number == todoList.getTodos().size() + 1){
                        todoList.add(task);
                    } else {
                        todoList.add(number - 1, task);
                    }
                }
                System.out.println("Нажмите: 0 - если хотите вывести список активных задач\n" +
                        "\t\t1 - если хотите добавить новую задачу\n" +
                        "\t\t2 - если хотите удалить задачу\n" +
                        "\t\t3 - если хотите заменить задачу\n" +
                        "\t\t4 - если хотите выйти из программы");
                number = action.nextInt();
            }
            if (number == 2){
                System.out.println("Введите номер удаляемой задачи из списка ниже: ");
                for (int i = 0; i < todoList.getTodos().size(); i ++){
                    System.out.println((i + 1) + " - " + todoList.getTodos().get(i));
                }
                number = action.nextInt();
                todoList.delete(number - 1);
                System.out.println("Нажмите: 0 - если хотите вывести список активных задач\n" +
                        "\t\t1 - если хотите добавить новую задачу\n" +
                        "\t\t2 - если хотите удалить задачу\n" +
                        "\t\t3 - если хотите заменить задачу\n" +
                        "\t\t4 - если хотите выйти из программы");
                number = action.nextInt();
            }
            if (number == 3){
                System.out.println("Введите номер удаляемой задачи из списка ниже: ");
                for (int i = 0; i < todoList.getTodos().size(); i ++){
                    System.out.println((i + 1) + " - " + todoList.getTodos().get(i));
                }
                number = action.nextInt();
                System.out.println("Введите новую задачу: ");
                task = getTask.nextLine();
                todoList.edit(task, number - 1);
                System.out.println("Нажмите: 0 - если хотите вывести список активных задач\n" +
                        "\t\t1 - если хотите добавить новую задачу\n" +
                        "\t\t2 - если хотите удалить задачу\n" +
                        "\t\t3 - если хотите заменить задачу\n" +
                        "\t\t4 - если хотите выйти из программы");
                number = action.nextInt();
            }
        }


    }
}
