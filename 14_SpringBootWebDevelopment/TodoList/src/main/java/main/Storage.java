package main;

import main.model.Task;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class Storage {
    private static int currentId = 1;
    private static final Map<Integer, Task> tasks = new HashMap<>();

    @Async
    public CompletableFuture<List<Task>> getAllTasks() {
        return CompletableFuture.completedFuture(new ArrayList<>(tasks.values()));
    }

    @Async
    public CompletableFuture<Integer> addTask(Task task) {
        Integer id = currentId++;
        task.setId(id);
        tasks.put(id, task);
        return CompletableFuture.completedFuture(id);
    }

    @Async
    public CompletableFuture<Task> getTask(int taskId) {
        if (tasks.containsKey(taskId)) {
            return CompletableFuture.completedFuture(tasks.get(taskId));
        }
        return null;
    }

    @Async
    public CompletableFuture<Boolean> deleteTask (int taskId){
        if (tasks.containsKey(taskId)) {
            tasks.remove(taskId);
            return CompletableFuture.completedFuture(true);
        } else {
            return CompletableFuture.completedFuture(false);
        }
    }

    @Async
    public CompletableFuture<Integer> updateTask (Task task, int taskId){
        Task newTask = tasks.get(taskId);
        if (newTask != null) {
            newTask.setTaskText(task.getTaskText());
            newTask.setDescription(task.getDescription());
        } else {
            task.setId(taskId);
            tasks.put(taskId, task);
        }
        return CompletableFuture.completedFuture(taskId);
    }
}
