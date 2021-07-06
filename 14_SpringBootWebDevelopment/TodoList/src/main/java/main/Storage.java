package main;

import main.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    private static int currentId = 1;
    private static final Map<Integer, Task> tasks = new HashMap<>();

    public static List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    public static int addTask(Task task) {
        int id = currentId++;
        task.setId(id);
        tasks.put(id, task);
        return id;
    }

    public static Task getTask(int taskId) {
        if (tasks.containsKey(taskId)) {
            return tasks.get(taskId);
        }
        return null;
    }

    public static Boolean deleteTask (int taskId){
        if (tasks.containsKey(taskId)) {
            tasks.remove(taskId);
            return true;
        } else {
            return false;
        }
    }

    public static int updateTask (Task task, int taskId){
        Task newTask = tasks.get(taskId);
        if (newTask != null) {
            newTask.setTaskText(task.getTaskText());
        } else {
            task.setId(taskId);
            tasks.put(taskId, task);
        }
        return taskId;
    }
}
