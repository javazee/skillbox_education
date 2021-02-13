import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        System.out.println("""
                Команды управления списком TODO:
                \tLIST — выводит дела с их порядковыми номерами;
                \tADD — добавляет дело в конец списка или дело на определённое место, сдвигая остальные дела вперёд,
                \t\tесли указать номер; если указан несуществующий индекс - добавить в конец списка.
                \tEDIT — заменяет дело с указанным номером; если указан несуществующий индекс - ничего не делать.
                \tDELETE — удаляет; если указан несуществующий индекс - ничего не делать.
                \tEXIT — выход из программы.""");
        System.out.println("Input command:");
        Scanner command = new Scanner(System.in);
        String task = command.nextLine();
        Pattern pattern = Pattern.compile("(ADD|EDIT|DELETE)(\\s*\\d*)?(\\s*.*)?");
        Matcher match = pattern.matcher(task);
        do {
            if (task.contains("LIST")) {
                for (int i = 0; i < todoList.getTodos().size(); i++) {
                    System.out.println("\t" + (i + 1) + " - " + todoList.getTodos().get(i));
                }
                System.out.println("Input command:");
                task = command.nextLine();
                match = pattern.matcher(task);
            }else if (task.contains("ADD")) {
                if (match.find() && match.group(2).trim().matches("\\d+")){
                    todoList.add(Integer.parseInt(match.group(2).trim()) - 1, match.group(3).trim());
                } else {
                    todoList.add(match.group(3).trim());
                }
                System.out.println("Input command:");
                task = command.nextLine();
                match = pattern.matcher(task);
            } else if (task.contains("EDIT")) {
                if (match.find()) {
                    todoList.edit(match.group(3).trim(), Integer.parseInt(match.group(2).trim()) - 1);
                }
                System.out.println("Input command:");
                task = command.nextLine();
                match = pattern.matcher(task);
            } else if (task.contains("DELETE")) {
                if (match.find()) {
                    todoList.delete(Integer.parseInt(match.group(2).trim()) - 1);
                }
                System.out.println("Input command:");
                task = command.nextLine();
                match = pattern.matcher(task);
            }
        } while (!task.contains("EXIT"));
    }
}