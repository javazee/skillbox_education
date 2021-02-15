import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoList {
    ArrayList<String> todoList = new ArrayList<>();
    List<String> unchangeableList = Collections.unmodifiableList(todoList);
    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        todoList.add(todo);
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if (index < todoList.size()) {
            todoList.add(index, todo);
        } else {
            todoList.add(todo);
            System.out.println("ERROR: Invalid input. The new task is placed at the end of the list");
        }
    }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        if (index < todoList.size()) {
            todoList.set(index, todo);
        } else {
            System.out.println("ERROR: Invalid input. The list remains unchanged");
        }
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (index < todoList.size()) {
            todoList.remove(index);
        } else {
            System.out.println("ERROR: Invalid input. The list remains unchanged");
        }
    }
    public List<String> getTodos() {
        // TODO: вернуть список дел
        return unchangeableList;
    }

}