package main;

import main.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;


@RestController
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class TaskController {

    @Autowired
    Storage storage;

    @GetMapping("/tasks/")
    public List<Task> list() {
        try {
            return storage.getAllTasks().get();
        } catch (ExecutionException | InterruptedException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @PostMapping("/tasks/")
    public int add(Task task){
        try {
            return storage.addTask(task).get();
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace();
        }
        return task.getId();
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        try {
            Task task = storage.getTask(id).get();
            if (task == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return new ResponseEntity<>(task, HttpStatus.OK);
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @PutMapping("/tasks/{id}")
    public int updateTask(Task newTask, @PathVariable int id) {
        try {
            return storage.updateTask(newTask, id).get();
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace();
        }
        return id;
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            boolean result = storage.deleteTask(id).get();
            return result ? ResponseEntity.status(HttpStatus.OK).body(null) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
